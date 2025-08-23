package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Pickup;
import za.ac.cput.service.PickupService;

import java.util.List;

@RestController
@RequestMapping("/pickup")
public class PickupController {

    private PickupService pickupService;
    @Autowired
    PickupController(PickupService pickupService){
        this.pickupService = pickupService;
    }

    @PostMapping("/create")
    public Pickup create(@RequestBody Pickup pickup){
        return pickupService.create(pickup);
    }
    @RequestMapping("/read/{pickupId}")
    public Pickup read(@PathVariable Long pickupId){
        return pickupService.read(pickupId);
    }
    @RequestMapping("/update")
    public Pickup update(@RequestBody Pickup pickup){
        return pickupService.update(pickup);
    }
    @RequestMapping("/delete/{pickupId}")
    public boolean delete(@PathVariable Long pickupId){
        return pickupService.delete(pickupId);
    }

    @RequestMapping("/all")
    public List<Pickup> getAll(){
        return pickupService.getAll();
    }
}
