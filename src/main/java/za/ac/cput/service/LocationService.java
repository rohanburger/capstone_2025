package za.ac.cput.service;
//

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.LocationRepository;

import java.util.List;

@Service
public class LocationService implements LocationServiceImpl{

    @Autowired
    private static LocationServiceImpl service;


    private LocationRepository repository;



    @Override
    public Location create(Location location) {
        return this.repository.save(location);
    }

    @Override
    public Location read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Location update(Location location) {
        return this.repository.save(location);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        return true;
    }

    @Override
    public List<Location> getall() {
        return this.repository.findAll();
    }
}
