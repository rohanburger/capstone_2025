package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Pickup;
import za.ac.cput.repository.PickupRepository;
import za.ac.cput.service.Interfaces.IPickupService;

import java.util.List;

@Service
public class PickupService implements IPickupService {

    private PickupRepository repository;
    @Autowired
    public PickupService(PickupRepository repository){
        this.repository = repository;
    }

    @Override
    public Pickup create(Pickup pickup) {
        return this.repository.save(pickup);
    }

    @Override
    public Pickup read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pickup update(Pickup pickup) {
        return this.repository.save(pickup);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Pickup> getAll() {
        return repository.findAll(); //retrieves a list of Pickup
    }

}
