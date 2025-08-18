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
    public void InvalidVehicleLicensePlateNum () {
        Vehicle vehicle = VehicleFactory.createVehicle("");
        assertNotNull(vehicle);
        assertEquals("", vehicle.getLicensePlateNum());
    }
}