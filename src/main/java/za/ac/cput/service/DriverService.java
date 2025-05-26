package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;
import java.util.List;
import java.util.Optional;

/*
    DriverService.java
    Driver Service Class
    Author: Kyle Bowers
    Date: 25/05/2025
*/

@Service
public class DriverService {
    private final DriverRepository repository;

    @Autowired
    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public Driver save(Driver driver) {
        return repository.save(driver);
    }

    public Optional<Driver> findById(String id) {
        return repository.findById(id);
    }

    public List<Driver> findAll() {
        return repository.findAll();
    }

    public Driver update(Driver driver) {
        return repository.save(driver);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
