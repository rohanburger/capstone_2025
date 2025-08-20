package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Location;
import za.ac.cput.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    private LocationService locationService;
    @Autowired LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @PostMapping("/create")
    public Location create(@RequestBody Location location){
        return locationService.create(location);
    }

    @GetMapping("/read/{locationId}")
    public Location read(@PathVariable Long locationId){
        return locationService.read(locationId);
    }

    @PutMapping("/update")
    public Location update(@RequestBody Location location){
        return locationService.update(location);
    }
    @DeleteMapping("/delete/{locationId}")
    public boolean delete(@PathVariable Long locationId){
        return locationService.delete(locationId);
    }
    @GetMapping("/all")
    public List<Location> getAll(){
        return locationService.getall();
    }
}
