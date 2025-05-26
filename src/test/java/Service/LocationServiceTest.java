package Service;

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
import org.springframework.stereotype.Service;
import za.ac.cput.Factory.LocationFactory;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.Pickup;
import za.ac.cput.service.LocationService;
import za.ac.cput.service.LocationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Service
@TestMethodOrder(MethodOrderer.MethodName.class)
public class LocationServiceTest {

    private Dropoff dropoff;
    private Pickup pickup;

    @BeforeEach
    public void setUp() {
         dropoff = new Dropoff();
         pickup = new Pickup();
    }

    @Autowired
    private LocationServiceImpl locationService;


    private Location location = LocationFactory.createLocation("001",dropoff, pickup);

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
        boolean delete= locationService.delete("001");
        assertNotNull(delete);
        System.out.println(delete);
    }

    @Test
    void getall() {
        System.out.println(locationService.getall());
    }
}
