package za.ac.cput.controller.Finished;

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
    }

    @PostMapping("/create")
    public String createUser(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("licenseNum") String licenseNum,
            @RequestParam("licensePlateNum") String licensePlateNum,
            HttpSession session,
            Model model
    ) {
        //Email and licenseNum are unique
        if (driverService.existsByDriverEmail(email)) {
            model.addAttribute("error", "Email already exists!");
            return "driverRegister";
        }


        if(vehicleService.existsByPlateNumber(licensePlateNum)){
            model.addAttribute("error", "License plate number already exists!");
            return "driverRegister";
        }

        try{
            Vehicle vehicle = VehicleFactory.createVehicle(licensePlateNum);
            Driver driver = DriverFactory.createDriver(name,surname,phoneNumber,email,licenseNum,password,vehicle);
            driverService.create(driver);
            session.setAttribute("user", driver);
            session.setAttribute("role", "driver");
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "driverRegister";
        }





    }
}
