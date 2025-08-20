package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.DriverFactory;
import za.ac.cput.Factory.VehicleFactory;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;


import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DriverServiceTest {

    @Autowired
    private DriverService service;
    private Driver driver;
    private Set<Vehicle> vehicles;

    @BeforeEach
    void setUp() {
        vehicles = new HashSet<>();
        vehicles.add(VehicleFactory.createVehicle("939939393"));
        Driver createDriver = DriverFactory.createDriver("John","Doe","0827877878","<EMAIL>","LIC101",vehicles);
        driver = service.create(createDriver);
        assertNotNull(driver);
        assertNotNull(driver.getDriverId());
    }

    @Test
    void create() {
        Driver created = service.create(driver);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Driver read = service.read(driver.getDriverId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Driver newDriver = new Driver.Builder().copy(driver).setDriverName("Jane").build();
        assertNotNull(newDriver);
        Driver updated = service.update(newDriver);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean deleted = service.delete(driver.getDriverId());
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}