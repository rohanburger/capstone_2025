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
public class driverProfileController {
    private DriverService driverService;
    private VehicleService vehicleService;

    @Autowired
    public driverProfileController(DriverService driverService,VehicleService vehicleService){
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String getDriverProfile(HttpSession session, Model model) {
        Driver driver = (Driver) session.getAttribute("user");
        if (driver == null) {
            return "redirect:/driverRegister";
        }

        Driver driverProfile = driverService.read(driver.getDriverId());
        Vehicle vehicle = driverProfile.getVehicle();

        model.addAttribute("driver", driverProfile);
        model.addAttribute("vehicle", vehicle);
        return "driverProfile";
    }

    @PostMapping("/update")
    public String updateDriverProfile(
            @RequestParam("driverId") Long driverId,
            @RequestParam("name") String driverName,
            @RequestParam("surname") String driverSurname,
            @RequestParam("phoneNumber") String driverPhoneNum,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("licenseNum") String licenseNum,
            @RequestParam("licensePlateNum") String licensePlateNum,
            HttpSession session

    ){
        Driver oldDriver = driverService.read(driverId);
        if (oldDriver == null) return "redirect:/driverProfile?error=UserNotFound";

        Vehicle oldVehicle = oldDriver.getVehicle();
        Vehicle newVehicle = new Vehicle.Builder()
                .copy(oldVehicle)
                .setLicensePlateNum(licensePlateNum)
                .build();

        Driver updatedDriver = new Driver.Builder().copy(oldDriver)
                .setDriverName(driverName)
                .setDriverSurname(driverSurname)
                .setDriverPhoneNum(driverPhoneNum)
                .setDriverEmail(email)
                .setLicenseNum(licenseNum)
                .setDriverPassword(password)
                .setVehicle(newVehicle)
                .build();

        driverService.update(updatedDriver);
        session.setAttribute("user", updatedDriver);

        return "redirect:/driverProfile";
    }

    @PostMapping("/delete")
    public String deleteDriverProfile(HttpSession session){
        Driver driver = (Driver) session.getAttribute("user");
        if (driver !=null){
            driverService.delete(driver.getDriverId());
            session.invalidate();
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
