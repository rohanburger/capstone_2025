package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.DriverRepository;
import za.ac.cput.service.Interfaces.IDriverService;

import za.ac.cput.domain.Driver;
import java.util.List;

@Service
public class DriverService implements IDriverService {

    private DriverRepository repository;
    @Autowired
    DriverService(DriverRepository repository){
        this.repository = repository;
    }

    @Override
    public Driver create(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Driver read(Long aLong) {
        return this.repository.findById(aLong).orElse(null);
    }

    @Override
    public Driver update(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public boolean delete(Long aLong) {
        repository.deleteById(aLong);
        return true;
    }

    @Override
    public List<Driver> getAll() {
        return this.repository.findAll();
    }

    public Driver findByDriverEmailAndDriverPassword(String email, String password) {
        return repository.findByDriverEmailAndDriverPassword(email, password).orElse(null);
    }
    public boolean existsByDriverEmail(String email) {
        return repository.existsByDriverEmail(email);
    }
}
