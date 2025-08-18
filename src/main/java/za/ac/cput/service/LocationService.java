package za.ac.cput.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;
import za.ac.cput.service.Interfaces.ILocationService;

import java.util.List;

@Service
public class LocationService implements ILocationService {

    private LocationRepository repository;
    @Autowired
    public LocationService(LocationRepository repository){
        this.repository = repository;
    }
    @Override
    public Location create(Location location) {
        return this.repository.save(location);
    }

    @Override
    public Location read(Long s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Location update(Location location) {
        return this.repository.save(location);
    }

    @Override
    public boolean delete(Long s) {
        this.repository.deleteById(s);
        return true;
    }

    @Override
    public List<Location> getall() {
        return this.repository.findAll();
    }
}
