package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Objects;

/*
    Vehicle.java
    Vehicle builder Class
    Author:Kyle Bowers
    Date:10/05/2025
*/

@Entity
public class Vehicle {
    @Id
    private String vehicleId;
    private String make;
    private String model;
    private String licensePlate;

    public Vehicle() {}

    public Vehicle(String vehicleId, String make, String model, String licensePlate) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getVehicleId() { return vehicleId; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getLicensePlate() { return licensePlate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId.equals(vehicle.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
