package za.ac.cput.domain;

/*
    Vehicle.java
    Vehicle builder Class
    Author:Kyle Bowers
    Date:10/05/2025
*/

public class Vehicle {
    private String vehicleId;
    private String licenseNum;

    public Vehicle(String vehicleId, String licenseNum) {
        this.vehicleId = vehicleId;
        this.licenseNum = licenseNum;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                '}';
    }
}
