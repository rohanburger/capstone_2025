package za.ac.cput.domain;
/*
    Session.java
    Session builder Class
    Author:Rohan Janzen Burger 230171990
    Date:08/05/2025
*/
public class Session {
    private String sessionid;//Initialize all neccesary attributes
    private Passenger passenger;
    private Driver driver;
    private Location location;
    private int passengerCount;
    private String sessionStatus;
    private Payment payment;

    private Session() {//Default constructor

    }

    private Session(Builder builder) {//Constructor witht he paramenter of the builder
        this.passenger = builder.passenger;//The Builder attributes are assigned the values from the builder pattern
        this.driver = builder.driver;
        this.location = builder.location;
        this.passengerCount = builder.passengerCount;
        this.sessionStatus = builder.sessionStatus;
        this.sessionid = builder.sessionid;
        this.payment = builder.payment;
    }

    public Passenger getPassenger() {//Get method retrieving the value
        return passenger;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public Location getLocation() {
        return location;
    }

    public Payment getPayment() {
        return payment;
    }

    public Driver getDriver() {
        return driver;
    }



    public String getSessionid() {
        return sessionid;
    }

    @Override
    public String toString() {//To String displays the attribute values as a string
        return "============================"+'\n'+
                "Session Object:"+'\n'+
                "============================"+'\n'+
                "Session id: " + sessionid +'\n'+
                "PassengerCount: "+ passengerCount+ '\n'+
                "Session Status: " + sessionStatus +'\n'+
                passenger +'\n'+
                driver +'\n'+
                location+'\n'+
                payment +'\n'+
                "============================"+'\n';
    }


    public static class Builder {//Builder class contained inside of the domain class
        private String sessionid;//Attributes for the builder class
        private Passenger passenger;
        private Driver driver;
        private Location location;
        private int passengerCount;
        private String sessionStatus;

        private Payment payment;


        public Builder setPassenger(Passenger passenger) {//Method with paramters that sets the value of the attribute ,expects a return of type builder
            this.passenger = passenger;
            return this;

        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;

        }

        public Builder setPassengerCount(int passengerCount) {
            this.passengerCount = passengerCount;
            return this;

        }


        public Builder setSessionStatus(String sessionStatus) {
            this.sessionStatus = sessionStatus;
            return this;

        }

        public Builder setSessionid(String sessionid) {
            this.sessionid = sessionid;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Session build() {//Method that returns/builds a type Session
            return new Session(this);
        }

    }

}
