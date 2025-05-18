package za.ac.cput.Factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.Helper.VehicleHelper;

/*
    DriverFactoryTest.java
    Driver Factory Test Class
    Author: Kyle Bowers
    Date: 17/05/2025
*/

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {

    @Test
    public void testCreateDriverSuccess() {
        Vehicle vehicle = VehicleHelper.createSampleVehicle();
        Driver driver = DriverFactory.createDriver(
                "D100",
                "Kyle",
                "Bowers",
                "0812708822",
                "kylebowers60@gmail.com",
                "LIC101",
                vehicle
        );

        assertNotNull(driver);
        assertEquals("Kyle", driver.getDriverName());
        assertEquals("Bowers", driver.getDriverSurname());
        assertEquals("kylebowers60@gmail.com", driver.getDriverEmail());
        assertEquals(vehicle, driver.getVehicle());
    }

    @Test
    public void testCreateDriverWithNullVehicleShouldFail() {
        assertThrows(IllegalArgumentException.class, () -> {
            DriverFactory.createDriver(
                    "D101",
                    "Romano",
                    "Christians",
                    "0727196078",
                    "romanochristians@gmail.com",
                    "LIC102",
                    null
            );
        });
    }
}
