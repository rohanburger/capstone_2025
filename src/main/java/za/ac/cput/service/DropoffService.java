package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.repository.DropoffRepository;
import za.ac.cput.service.Interfaces.IDropoffService;

import java.util.List;

@Service
public class DropoffService implements IDropoffService {

    private DropoffRepository repository;
    @Autowired
    DropoffService(DropoffRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Dropoff> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Dropoff create(Dropoff dropoff) {
        return this.repository.save(dropoff);
    }

    @Override
    public Dropoff read(Long aLong) {
        return this.repository.findById(aLong).orElse(null);
    }

    @Override
    public Dropoff update(Dropoff dropoff) {
        return this.repository.save(dropoff);
    }

    @Override
    public boolean delete(Long aLong) {
        repository.deleteById(aLong);
        return true;
    }
}
