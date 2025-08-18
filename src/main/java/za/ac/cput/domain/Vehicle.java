package za.ac.cput.domain;

import jakarta.persistence.*;

/*
    Vehicle.java
    Vehicle builder Class
    Author:Kyle Bowers
    Date:10/05/2025
*/
@Entity
@Table(name="Vehicle")
public class Vehicle {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private String licensePlateNum;



    protected Vehicle() {
    }

    private Vehicle(Builder builder) {
        this.vehicleId = builder.vehicleId;
        this.licensePlateNum = builder.licensePlateNum;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", licenseNum='" + licensePlateNum + '\'' +
                '}';
    }

    public static class Builder {
        private Long vehicleId;
        private String licensePlateNum;

        public Builder setVehicleId(Long vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public Builder setLicensePlateNum(String licensePlateNum) {
            this.licensePlateNum = licensePlateNum;
            return this;
        }

        public Builder copy(Vehicle vehicle) {
            this.vehicleId = vehicle.vehicleId;
            this.licensePlateNum = vehicle.licensePlateNum;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
