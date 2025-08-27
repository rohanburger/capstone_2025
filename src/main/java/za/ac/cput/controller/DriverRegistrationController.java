package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Factory.DriverFactory;
import za.ac.cput.Factory.VehicleFactory;
import za.ac.cput.domain.*;
import za.ac.cput.service.DriverService;
import za.ac.cput.service.VehicleService;

@Controller
@RequestMapping("/driverRegister")
public class DriverRegistrationController {

    private DriverService driverService;
    private VehicleService vehicleService;
    @Autowired
    DriverRegistrationController(DriverService driver,VehicleService vehicleService){
        this.driverService = driver;
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public String createDriverPage() {
        return "driverRegister";
    }// Handles the /driverRegister GET request

    @PostMapping("/create")
    public String createUser(
            @RequestParam("name") String name,// Captures the name from the form
            @RequestParam("surname") String surname,// Captures the surname from the form
            @RequestParam("phoneNumber") String phoneNumber,// Captures the phoneNumber from the form
            @RequestParam("email") String email,// Captures the email from the form
            @RequestParam("password") String password,// Captures the password from the form
            @RequestParam("licenseNum") String licenseNum,// Captures the licenseNum from the form
            @RequestParam("licensePlateNum") String licensePlateNum,// Captures the licensePlateNum from the form
            HttpSession session,// Captures the session object from the form
            Model model// Captures the model object from the form
    ) {

        if (driverService.existsByDriverEmail(email)) {// Checks if the email is already in use
            model.addAttribute("error", "Email already exists!");
            return "driverRegister";
        }


        if(vehicleService.existsByPlateNumber(licensePlateNum)){// Checks if the license plate number is already in use
            model.addAttribute("error", "License plate number already exists!");
            return "driverRegister";
        }

        try{
            Vehicle vehicle = VehicleFactory.createVehicle(licensePlateNum);// Creates a new Vehicle object with the specified licensePlateNum
            Driver driver = DriverFactory.createDriver(name,surname,phoneNumber,email,licenseNum,password,vehicle);// Creates a new Driver object with the specified name,
            // surname, phoneNumber, email, licenseNum, and password
            driverService.create(driver);// Calls the create method in the DriverService class to create the driver
            session.setAttribute("user", driver);// Sets the driver object to the session attribute "user"
            session.setAttribute("role", "driver");// Sets the role attribute in the session to "driver"
            return "redirect:/";
        } catch (IllegalArgumentException e) {// Handles any IllegalArgumentExceptions that may be thrown during the creation of the driver
            model.addAttribute("error", e.getMessage());
            return "driverRegister";
        }





    }
}
