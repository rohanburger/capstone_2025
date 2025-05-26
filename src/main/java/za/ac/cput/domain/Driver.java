package za.ac.cput.domain;

import jakarta.persistence.*;
import java.util.Objects;

/*
    Driver.java
    Driver Builder Class
    Author: Kyle Bowers
    Date: 10/05/2025
*/

@Entity
public class Driver {

    @Id
    private String driverId;
    private String driverName;
    private String driverSurname;
    private String driverPhoneNum;
    private String driverEmail;
    private String licenseNum;

    @OneToOne
    private Vehicle vehicle;

    public Driver() {}

    public Driver(String driverId, String driverName, String driverSurname,
                  String driverPhoneNum, String driverEmail, String licenseNum,
                  Vehicle vehicle) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverSurname = driverSurname;
        this.driverPhoneNum = driverPhoneNum;
        this.driverEmail = driverEmail;
        this.licenseNum = licenseNum;
        this.vehicle = vehicle;
    }

    public String getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public String getDriverSurname() { return driverSurname; }
    public String getDriverPhoneNum() { return driverPhoneNum; }
    public String getDriverEmail() { return driverEmail; }
    public String getLicenseNum() { return licenseNum; }
    public Vehicle getVehicle() { return vehicle; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return driverId.equals(driver.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverSurname='" + driverSurname + '\'' +
                ", driverPhoneNum='" + driverPhoneNum + '\'' +
                ", driverEmail='" + driverEmail + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}
