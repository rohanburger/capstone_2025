package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.VehicleRepository;
import za.ac.cput.service.Interfaces.IVehicleService;

import java.util.List;

@Service
public class VehicleService implements IVehicleService {
    private VehicleRepository repository;
    @Autowired VehicleService(VehicleRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Vehicle> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.repository.save(vehicle);
    }

    @Override
    public Vehicle read(Long aLong) {
        return this.repository.findById(aLong).orElse(null);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return this.repository.save(vehicle);
    }

    @Override
    public boolean delete(Long aLong) {
        repository.deleteById(aLong);
        return true;
    }
}
