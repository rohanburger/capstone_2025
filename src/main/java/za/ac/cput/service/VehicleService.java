package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.VehicleRepository;
import java.util.List;
import java.util.Optional;

/*
    VehicleService.java
    Vehicle Service Class
    Author: Kyle Bowers
    Date: 25/05/2025
*/

@Service
public class VehicleService {
    private final VehicleRepository repository;

    @Autowired
    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Optional<Vehicle> findById(String id) {
        return repository.findById(id);
    }

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle update(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
