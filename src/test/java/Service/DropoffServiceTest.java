package Service;

/*
    DropoffServiceTest.java
    Dropoff Services Test Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Factory.DropoffFactory;
import za.ac.cput.Factory.LocationFactory;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.service.DropoffServiceImpl;
import za.ac.cput.service.LocationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@Service
@TestMethodOrder(MethodOrderer.MethodName.class)
class DropoffServiceTest {

    @Autowired
    private DropoffServiceImpl dropoffService;


    private Dropoff dropoff = DropoffFactory.createDropoff("001","35 Salts", "Salt River", "Cape Town");

    @Test
    void create() {
        Dropoff created = dropoffService.create(dropoff);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Dropoff read= dropoffService.read(dropoff.getDropoffId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Dropoff newLocation = new Dropoff.DropoffBuilder().copy(dropoff).build();
        dropoffService.update(newLocation);
        Dropoff updated = dropoffService.read(newLocation.getDropoffId());
    }

    @Test
    void delete() {
        boolean delete= dropoffService.delete("001");
        assertNotNull(delete);
        System.out.println(delete);
    }

    @Test
    void getall() {
        System.out.println(dropoffService.getall());
    }

}