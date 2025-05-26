package za.ac.cput.service;

/*
    DropoffService.java
    Dropoff Service Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.repository.DropoffRepository;
import za.ac.cput.repository.LocationRepository;

import java.util.List;
@Service
public class DropoffService implements DropoffServiceImpl{

    @Autowired
    private static DropoffServiceImpl service;


    private DropoffRepository repository;



    @Override
    public Dropoff create(Dropoff dropoff) {
        return this.repository.save(dropoff);
    }

    @Override
    public Dropoff read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Dropoff update(Dropoff dropoff) {
        return this.repository.save(dropoff);
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        return true;
    }

    @Override
    public List<Dropoff> getall() {
        return this.repository.findAll();
    }

}
