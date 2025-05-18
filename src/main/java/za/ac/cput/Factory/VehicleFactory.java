package za.ac.cput.Factory;

import za.ac.cput.domain.Vehicle;
/*
    VehicleFactory.java
    Vehicle Factory Class
    Author:Kyle Bowers
    Date:17/05/2025
*/

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleId, String licenseNum) {
        if (vehicleId == null || licenseNum == null) {
            throw new IllegalArgumentException("Vehicle ID and License Number cannot be null");
        }
        return new Vehicle(vehicleId, licenseNum);
    }
}
