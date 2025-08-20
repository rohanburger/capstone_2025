package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Driver;
import za.ac.cput.service.DriverService;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    private DriverService driverService;
    @Autowired
    DriverController(DriverService driver){
        this.driverService = driver;
    }

    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver){
        return driverService.create(driver);
    }

    @GetMapping("/read/{driverId}")
    public Driver read(@PathVariable Long driverId){
        return driverService.read(driverId);
    }

    @PutMapping("/update")
    public Driver update(@RequestBody Driver driver){
        return driverService.update(driver);
    }

    @DeleteMapping("/delete/{driverId}")
    public boolean delete(@PathVariable Long driverId){
        return driverService.delete(driverId);
    }

    @GetMapping("/all")
    public List<Driver> getAll(){
        return driverService.getAll();
    }

}
