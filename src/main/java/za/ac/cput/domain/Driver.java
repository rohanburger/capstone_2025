package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Set;

/*
    Driver.java
    Driver Builder Class
    Author: Kyle Bowers
    Date: 10/05/2025
*/
@Entity
@Table (name="Driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;
    private String driverName;
    private String driverSurname;
    private String driverPhoneNum;
    @Column(unique = true)
    private String driverEmail;
    private String driverPassword;
    @Column(unique = true)
    private String licenseNum;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "driver_Id")
    private Set<Vehicle> vehicles;

    public Driver() {
    }

    public Driver(Builder builder) {
        this.driverId = builder.driverId;
        this.driverName = builder.driverName;
        this.driverSurname = builder.driverSurname;
        this.driverPhoneNum = builder.driverPhoneNum;
        this.driverEmail = builder.driverEmail;
        this.licenseNum = builder.licenseNum;
        this.driverPassword = builder.driverPassword;
        this.vehicles = builder.vehicles;
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public String getDriverPhoneNum() {
        return driverPhoneNum;
    }

    public String getDriverEmail() {
        return driverEmail;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public String getDriverPassword() {
        return driverPassword;
    }
    public Set<Vehicle> getVehicle() {
        return vehicles;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", driverSurname='" + driverSurname + '\'' +
                ", driverPhoneNum='" + driverPhoneNum + '\'' +
                ", driverEmail='" + driverEmail + '\'' +
                ", driverPassword='" + driverPassword + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }

    public static class Builder {
        private Long driverId;
        private String driverName;
        private String driverSurname;
        private String driverPhoneNum;
        private String driverEmail;
        private String licenseNum;
        private String driverPassword;
        private Set<Vehicle> vehicles;

        public Builder setDriverId(Long driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setDriverName(String driverName) {
            this.driverName = driverName;
            return this;
        }

        public Builder setDriverSurname(String driverSurname) {
            this.driverSurname = driverSurname;
            return this;
        }

        public Builder setDriverPhoneNum(String driverPhoneNum) {
            this.driverPhoneNum = driverPhoneNum;
            return this;
        }

        public Builder setDriverEmail(String driverEmail) {
            this.driverEmail = driverEmail;
            return this;
        }

        public Builder setLicenseNum(String licenseNum) {
            this.licenseNum = licenseNum;
            return this;
        }

        public Builder setDriverPassword(String driverPassword) {
            this.driverPassword = driverPassword;
            return this;
        }

        public Builder setVehicle(Set<Vehicle> vehicle) {
            this.vehicles = vehicle;
            return this;
        }

        public Builder copy(Driver driver) {
            this.driverId = driver.driverId;
            this.driverName = driver.driverName;
            this.driverSurname = driver.driverSurname;
            this.driverPhoneNum = driver.driverPhoneNum;
            this.driverEmail = driver.driverEmail;
            this.licenseNum = driver.licenseNum;
            this.driverPassword = driver.driverPassword;
            this.vehicles = driver.vehicles;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }
}
