package za.ac.cput.service;

/*
    LocationServiceTest.java
    Location Services Test Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.Factory.DropoffFactory;
import za.ac.cput.Factory.LocationFactory;
import za.ac.cput.Factory.PickupFactory;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.Pickup;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LocationServiceTest {

    private Dropoff dropoff;
    private Pickup pickup;
    @Autowired
    private LocationService locationService;
    private Location location;

    @BeforeEach
    public void setUp() {
        dropoff =DropoffFactory.createDropoff("35 Hoodwink","Claremont","Cape Town");
        pickup =PickupFactory.createPickupWithAttributes("40 Hoodwink","Claremont","Cape Town");

        Location createlocation = LocationFactory.createLocation(dropoff, pickup);
        location = locationService.create(createlocation);
        assertNotNull(location);
        assertNotNull(location.getLocationId());
    }
    @Test
    void create() {
        Location created = locationService.create(location);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Location read= locationService.read(location.getLocationId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Location newLocation = new Location.LocationBuilder().copy(location).build();
        locationService.update(newLocation);
        Location updated = locationService.read(newLocation.getLocationId());
    }

    @Test
    void delete() {
        boolean delete= locationService.delete(location.getLocationId());
        assertNotNull(delete);
        System.out.println(delete);
    }

    @Test
    void getall() {
        System.out.println(locationService.getall());
    }
}
