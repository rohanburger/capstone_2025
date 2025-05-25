package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Pickup;
import za.ac.cput.repository.PickupRepository;

import java.util.List;

@Service
public class PickupService implements IPickupService{
    @Autowired
    private static IPickupService service;

    private PickupRepository repository;

    public static IPickupService getService(){
        if(service == null){
            service = new PickupService();
        }
        return service;
    }

    @Override
    public Pickup create(Pickup pickup) {
        return this.repository.save(pickup);
    }

    @Override
    public Pickup read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pickup update(Pickup pickup) {
        return this.repository.save(pickup);
    }

    @Override
    public boolean delete(String id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Pickup> getAll() {
        return repository.findAll(); //retrieves a list of Pickup
    }

}
