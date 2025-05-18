package za.ac.cput.Factory;

import za.ac.cput.domain.Vehicle;
/*
    VehicleFactoryTest.java
    Vehicle Factory Tester Class
    Author:Kyle Bowers
    Date:17/05/2025
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {
    @Test
    public void testCreateVehicleSuccess() {
        Vehicle vehicle = VehicleFactory.createVehicle("V100", "XYZ9999");
        assertNotNull(vehicle);
        assertEquals("V100", vehicle.getVehicleId());
        assertEquals("XYZ9999", vehicle.getLicenseNum());
    }

    @Test
    public void testCreateVehicleWithNullShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            VehicleFactory.createVehicle(null, "XYZ9999");
        });
    }
}