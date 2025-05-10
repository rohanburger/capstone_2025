package za.ac.cput.domain;

/*
    Driver.java
    Driver builder Class
    Author:Kyle Bowers
    Date:10/05/2025
*/

public class Driver {
    private String driverId;
    private String driverName;
    private String driverSurname;
    private String driverPhoneNum;
    private String driverEmail;
    private String licenseNum;


    public Driver() {
    }

    public Driver(Builder builder) {
        this.driverId = builder.driverId;
        this.driverName =  builder.driverName;
        this.driverSurname = builder.driverSurname;
        this.driverPhoneNum = builder.driverPhoneNum;
        this.driverEmail = builder.driverEmail;
        this.licenseNum = builder.licenseNum;
    }

    public String getDriverId() {
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

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverSurname='" + driverSurname + '\'' +
                ", driverPhoneNum='" + driverPhoneNum + '\'' +
                ", driverEmail='" + driverEmail + '\'' +
                ", licenseNum='" + licenseNum + '\'' +
                '}';
    }

    public static class Builder{
        private String driverId;
        private String driverName;
        private String driverSurname;
        private String driverPhoneNum;
        private String driverEmail;
        private String licenseNum;

        public Builder setDriverId(String driverId) {
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
        public Driver build(){
            return new Driver(this);
        }
    }
}
