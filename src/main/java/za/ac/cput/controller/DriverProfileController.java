package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.service.DriverService;
import za.ac.cput.service.VehicleService;

@Controller
@RequestMapping("/driverProfile")
public class DriverProfileController {
    private DriverService driverService;
    private VehicleService vehicleService;

    @Autowired
    public DriverProfileController(DriverService driverService, VehicleService vehicleService){
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String getDriverProfile(HttpSession session, Model model) {
        Driver driver = (Driver) session.getAttribute("user");// Gets the user from the session and casts it to a Driver object
        if (driver == null) {// If the user is null, redirect to the driverRegister page
            return "redirect:/driverRegister";
        }

        Driver driverProfile = driverService.read(driver.getDriverId());// Calls the read method in the DriverService class to retrieve the driver with the specified driverId
        Vehicle vehicle = driverProfile.getVehicle();// Retrieves the vehicle object from the driver object

        model.addAttribute("driver", driverProfile);//Sets the driverProfile object to the driver attribute in the model
        model.addAttribute("vehicle", vehicle);// Sets the vehicle object to the vehicle attribute in the model
        return "driverProfile";
    }

    @PostMapping("/update")
    public String updateDriverProfile(
            @RequestParam("driverId") Long driverId,// Captures the driverId from the form
            @RequestParam("name") String driverName,// Captures the driverName from the form
            @RequestParam("surname") String driverSurname,// Captures the driverSurname from the form
            @RequestParam("phoneNumber") String driverPhoneNum,// Captures the driverPhoneNumber from the form
            @RequestParam("email") String email,// Captures the driverEmail from the form
            @RequestParam("password") String password,// Captures the driverPassword from the form
            @RequestParam("licenseNum") String licenseNum,// Captures the driverLicenseNum from the form
            @RequestParam("licensePlateNum") String licensePlateNum,// Captures the driverLicensePlateNum from the form
            HttpSession session// Captures the session object from the form

    ){
        Driver oldDriver = driverService.read(driverId); // Calls the read method in the DriverService class to retrieve the driver with the specified driverId
        if (oldDriver == null) return "redirect:/driverProfile?error=UserNotFound";
        Vehicle oldVehicle = oldDriver.getVehicle();// Retrieves the vehicle object from the driver object
        Vehicle newVehicle = new Vehicle.Builder()// Creates a new Vehicle object with the specified licensePlateNum
                .copy(oldVehicle)
                .setLicensePlateNum(licensePlateNum)
                .build();

        Driver updatedDriver = new Driver.Builder().copy(oldDriver)// Creates a new Driver object with the specified driverId,
                // driverName, driverSurname, driverPhoneNumber, driverEmail, driverLicenseNum, driverPassword, and vehicle
                .setDriverName(driverName)
                .setDriverSurname(driverSurname)
                .setDriverPhoneNum(driverPhoneNum)
                .setDriverEmail(email)
                .setLicenseNum(licenseNum)
                .setDriverPassword(password)
                .setVehicle(newVehicle)
                .build();

        driverService.update(updatedDriver);// Calls the update method in the DriverService
        session.setAttribute("user", updatedDriver);// Sets the updatedDriver object in the session

        return "redirect:/driverProfile";
    }

    @PostMapping("/delete")
    public String deleteDriverProfile(HttpSession session){// Handles the /driverProfile/delete POST request
        Driver driver = (Driver) session.getAttribute("user");// Gets the user from the session and casts it to a Driver object
        if (driver !=null){// If the user is not null, delete the user and invalidate the session
            driverService.delete(driver.getDriverId());// Calls the delete method in the DriverService class to delete the driver with the specified driverId
            session.invalidate();// Invalidates the session
            return "redirect:/";
        }
        return "redirect:/";
    }

    @PostMapping("/logout")// Handles the /driverProfile/logout POST request
    public String logout(HttpSession session){// Handles the /driverProfile/logout POST request
        session.invalidate();// Invalidates the session
        return "redirect:/";// Redirects to the home page after the session is invalidated
    }
}
