package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.DropoffFactory;
import za.ac.cput.domain.Dropoff;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DropoffServiceTest {

    @Autowired
    private DropoffService dropoffService;
    private Dropoff dropoff;

    @BeforeEach
    void setUp(){
        Dropoff createdropoff = DropoffFactory.createDropoff("35 Hoodwink","Claremont","Cape Town");
        dropoff = dropoffService.create(createdropoff);
        assertNotNull(dropoff);
        assertNotNull(dropoff.getDropoffId());
    }

    @Test
    void getAll() {
        System.out.println(dropoffService.getAll());
    }

    @Test
    void create() {
        Dropoff created = dropoffService.create(dropoff);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        dropoff = dropoffService.read(dropoff.getDropoffId());
        assertNotNull(dropoff);
        System.out.println(dropoff);
    }

    @Test
    void update() {
        dropoff = new Dropoff.DropoffBuilder().copy(dropoff).setDropoffStreet("Mackles Rd").build();
        Dropoff updated = dropoffService.update(dropoff);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean deleted = dropoffService.delete(dropoff.getDropoffId());
        assertTrue(deleted);
    }
}