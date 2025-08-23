package za.ac.cput.controller.DomainControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.service.DropoffService;

import java.util.List;

@RestController
@RequestMapping("/dropoff")
public class DropOffController {

    private DropoffService dropoffService;
    @Autowired
    DropOffController(DropoffService dropoffService){
        this.dropoffService = dropoffService;
    }

    @PostMapping("/create")
    public Dropoff create(@RequestBody Dropoff dropoff){
        return dropoffService.create(dropoff);
    }

    @GetMapping("/read/{dropoffId}")
    public Dropoff read(@PathVariable Long dropoffId){
        return dropoffService.read(dropoffId);
    }

    @PutMapping("/update")
    public Dropoff update(@RequestBody Dropoff dropoff){
        return dropoffService.update(dropoff);
    }

    @DeleteMapping("/delete/{dropoffId}")
    public boolean delete(@PathVariable Long dropoffId){
        return dropoffService.delete(dropoffId);
    }

    @GetMapping("/all")
    public List<Dropoff> getAll(){
        return dropoffService.getAll();
    }

}
