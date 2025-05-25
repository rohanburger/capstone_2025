package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Passenger;
import za.ac.cput.repository.PassengerRepository;

import java.util.List;

@Service
public class PassengerService implements IPassengerService {
    @Autowired
    private static IPassengerService service;

    private PassengerRepository repository;

    public static IPassengerService getService(){
        if(service == null){
            service = new PassengerService();
        }
        return service;
    }

    @Override
    public Passenger create(Passenger passenger) {
        return this.repository.save(passenger);
    }

    @Override
    public Passenger read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return this.repository.save(passenger);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Passenger> getAll() {
        return repository.findAll(); //retrieves a list of Passenger
    }
}
