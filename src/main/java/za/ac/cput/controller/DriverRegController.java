package za.ac.cput.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.*;
import za.ac.cput.service.DriverService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/driverRegister")
public class DriverRegController {

    private DriverService driverService;
    @Autowired
    DriverRegController(DriverService driver){
        this.driverService = driver;
    }

    @GetMapping
    public String createDriverForm() {
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

            HttpSession session
    ) {

        Vehicle vehicle = new Vehicle.Builder()
                .setLicensePlateNum(licenseNum)
                .build();

        Set<Vehicle> vehicleSet = new HashSet<>();
        vehicleSet.add(vehicle);


        Driver driver = new Driver.Builder()
                .setDriverName(name)
                .setDriverSurname(surname)
                .setDriverPhoneNum(phoneNumber)
                .setDriverEmail(email)
                .setLicenseNum(licenseNum)
                .setDriverPassword(password)
                .setVehicle(vehicleSet)
                .build();


        driverService.create(driver);
        session.setAttribute("user", driver);
        session.setAttribute("role", "driver");

        return "redirect:/";
    }








//
//    @PostMapping("/create")
//    public Driver create(@RequestBody Driver driver){
//        return driverService.create(driver);
//    }
//
//    @GetMapping("/read/{driverId}")
//    public Driver read(@PathVariable Long driverId){
//        return driverService.read(driverId);
//    }
//
//    @PutMapping("/update")
//    public Driver update(@RequestBody Driver driver){
//        return driverService.update(driver);
//    }
//
//    @DeleteMapping("/delete/{driverId}")
//    public boolean delete(@PathVariable Long driverId){
//        return driverService.delete(driverId);
//    }
//
//    @GetMapping("/all")
//    public List<Driver> getAll(){
//        return driverService.getAll();
//    }

}
