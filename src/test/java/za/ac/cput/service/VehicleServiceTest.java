package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.VehicleFactory;
import za.ac.cput.domain.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleServiceTest {

    @Autowired
    private VehicleService vehicleService;
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        Vehicle createVehicle = VehicleFactory.createVehicle("939939393");
        vehicle = vehicleService.create(createVehicle);
        assertNotNull(vehicle);
        assertNotNull(vehicle.getVehicleId());
    }

    @Test
    void getAll() {
        System.out.println(vehicleService.getAll());
    }

    @Test
    void create() {
        Vehicle created = vehicleService.create(vehicle);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Vehicle read = vehicleService.read(vehicle.getVehicleId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        Vehicle update = new Vehicle.Builder().copy(vehicle).setLicensePlateNum("422200").build();
        assertNotNull(update);
        Vehicle updated = vehicleService.update(update);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean deleted = vehicleService.delete(vehicle.getVehicleId());
        assertTrue(deleted);
    }
}