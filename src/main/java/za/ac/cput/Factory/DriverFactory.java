package za.ac.cput.Factory;

import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;

/*
    DriverFactory.java
    Factory class for Driver
    Author: Kyle Bowers
    Date: 18/05/2025
*/

public class DriverFactory {
    public static Driver createDriver(String driverId, String driverName, String driverSurname,
                                      String driverPhoneNum, String driverEmail, String licenseNum,
                                      Vehicle vehicle) {
        if (driverId == null || driverId.isEmpty())
            throw new IllegalArgumentException("Driver ID is required");
        if (driverName == null || driverName.isEmpty())
            throw new IllegalArgumentException("Driver name is required");
        if (vehicle == null)
            throw new IllegalArgumentException("Vehicle cannot be null");

        return new Driver.Builder()
                .setDriverId(driverId)
                .setDriverName(driverName)
                .setDriverSurname(driverSurname)
                .setDriverPhoneNum(driverPhoneNum)
                .setDriverEmail(driverEmail)
                .setLicenseNum(licenseNum)
                .setVehicle(vehicle)
                .build();
    }
}
