package za.ac.cput.Helper;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;

/*
    DriverHelper.java
    Driver Helper Class
    Author: Kyle Bowers
    Date: 17/05/2025
*/

public class DriverHelper {
    public static Driver createSampleDriver() {
        Vehicle vehicle = VehicleHelper.createSampleVehicle();
        return new Driver.Builder()
                .setDriverId("D001")
                .setDriverName("Rohan")
                .setDriverSurname("Burger")
                .setDriverPhoneNum("0711234567")
                .setDriverEmail("rohanburger@gmail.com")
                .setLicenseNum("LIC12345")
                .setVehicle(vehicle)
                .build();
    }
}
