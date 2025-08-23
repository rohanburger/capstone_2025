package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;

/*
    DriverFactoryTest.java
    Driver Factory Test Class
    Author: Kyle Bowers
    Date: 17/05/2025
*/

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {
    private  Set<Vehicle> vehicle;

    @BeforeEach
    public void setUp() {
        vehicle  = new HashSet<>();
        vehicle.add(VehicleFactory.createVehicle("CW456890"));
    }

    @Test
    public void InvalidDriverName() {
        Driver driver = DriverFactory.createDriver("", "Bowers", "0812708822", "kylebowers60@gmail.com",
                "LIC101","12414",vehicle);
        assertNotNull(driver);
        assertEquals("", driver.getDriverName());
    }

    @Test
    public void InvalidDriverSurname(){
        Driver driver = DriverFactory.createDriver("Kyle", "", "0812708822", "kylebowers60@gmail.com",
                "LIC101","12414",vehicle);
        assertNotNull(driver);
        assertEquals("", driver.getDriverSurname());
    }

    @Test
    public void InvalidDriverPhoneNumber(){
        Driver driver = DriverFactory.createDriver("Kyle", "Bowers", "", "kylebowers60@gmail.com",
                "LIC101","12414",vehicle);
        assertNotNull(driver);
        assertEquals("", driver.getDriverPhoneNum());
    }

    @Test
    public void InvalidDriverEmail(){
        Driver driver = DriverFactory.createDriver("Kyle", "Bowers", "0812708822", "",
                "LIC101","12414",vehicle);
        assertNotNull(driver);
        assertEquals("", driver.getDriverEmail());
    }

    @Test
    public void InvalidLicenceNum(){
        Driver driver = DriverFactory.createDriver("Kyle", "Bowers", "0812708822", "kylebowers60@gmail.com",
                "","12414",vehicle);
        assertNotNull(driver);
        assertEquals("", driver.getLicenseNum());
    }


}
