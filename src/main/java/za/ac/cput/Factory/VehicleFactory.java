package za.ac.cput.Factory;

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.Vehicle;
/*
    VehicleFactory.java
    Vehicle Factory Class
    Author:Kyle Bowers
    Date:17/05/2025
*/

public class VehicleFactory {
    public static Vehicle createVehicle(String licensePlateNum) {

        if (Helper.isNullOrEmpty(licensePlateNum)){
            throw new IllegalArgumentException("Error: Vehicle license number is null or empty");
        }

        return new Vehicle.Builder()
                .setLicensePlateNum(licensePlateNum)
                .build();
    }
}
