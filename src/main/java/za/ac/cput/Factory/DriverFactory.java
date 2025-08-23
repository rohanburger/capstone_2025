package za.ac.cput.Factory;

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Vehicle;

import java.util.Set;

/*
    DriverFactory.java
    Factory class for Driver
    Author: Kyle Bowers
    Date: 18/05/2025
*/

public class DriverFactory {
    public static Driver createDriver( String driverName, String driverSurname,
                                      String driverPhoneNum, String driverEmail, String licenseNum, String driverPassword,
                                      Set<Vehicle> vehicle) {

        if (Helper.isNullOrEmpty(driverName) || Helper.isNullOrEmpty(driverSurname)||Helper.isNullOrEmpty(driverPhoneNum)||
                Helper.isNullOrEmpty(driverEmail)||Helper.isNullOrEmpty(licenseNum)){
            System.out.println( "Error: Driver details are null or empty");
        }

        return new Driver.Builder()
                .setDriverName(driverName)
                .setDriverSurname(driverSurname)
                .setDriverPhoneNum(driverPhoneNum)
                .setDriverEmail(driverEmail)
                .setLicenseNum(licenseNum)
                .setDriverPassword(driverPassword)
                .setVehicle(vehicle)
                .build();
    }
}
