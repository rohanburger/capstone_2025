package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create")
    public Vehicle create(@RequestBody Vehicle vehicle){
        return vehicleService.create(vehicle);
    }

    @GetMapping("/read/{vehicleId}")
    public Vehicle read(@PathVariable Long vehicleId){
        return vehicleService.read(vehicleId);
    }

    @PutMapping("/update")
    public Vehicle update(@RequestBody Vehicle vehicle){
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/delete/{vehicleId}")
    public boolean delete(@PathVariable Long vehicleId){
        return vehicleService.delete(vehicleId);
    }

    @GetMapping("/all")
    public Iterable<Vehicle> getAll(){
        return vehicleService.getAll();
    }
}
