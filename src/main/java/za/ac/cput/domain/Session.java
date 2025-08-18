package za.ac.cput.domain;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/*
    Session.java
    Session builder Class
    Author:Rohan Janzen Burger 230171990
    Date:08/05/2025
*/
@Entity
@Table (name="Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionid;//Initialize all neccesary attributes

    @OneToOne
    @JoinColumn(name = "passengerId")
    private User user;
    @OneToOne
    @JoinColumn(name = "driverId")
    private Driver driver;
    @OneToOne
    @JoinColumn(name = "locationId")
    private Location location;
    private int passengerCount;
    private String sessionStatus;
    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    protected Session() {//Default constructor

    }

    private Session(Builder builder) {//Constructor witht he paramenter of the builder
        this.user = builder.user;//The Builder attributes are assigned the values from the builder pattern
        this.driver = builder.driver;
        this.location = builder.location;
        this.passengerCount = builder.passengerCount;
        this.sessionStatus = builder.sessionStatus;
        this.sessionid = builder.sessionid;
        this.payment = builder.payment;
    }

    public User getUser() {//Get method retrieving the value
        return user;
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

    public Long getSessionid() {
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
                user +'\n'+
                driver +'\n'+
                location+'\n'+
                payment +'\n'+
                "============================"+'\n';
    }


    public static class Builder {//Builder class contained inside of the domain class
        private Long sessionid;//Attributes for the builder class
        private User user;
        private Driver driver;
        private Location location;
        private int passengerCount;
        private String sessionStatus;

        private Payment payment;


        public Builder setPassenger(User user) {//Method with paramters that sets the value of the attribute ,expects a return of type builder
            this.user = user;
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

        public Builder setSessionid(Long sessionid) {
            this.sessionid = sessionid;
            return this;
        }

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder copy(Session session){
            this.user=session.user;
            this.driver=session.driver;
            this.location=session.location;
            this.passengerCount=session.passengerCount;
            this.sessionStatus=session.sessionStatus;
            this.sessionid=session.sessionid;
            this.payment=session.payment;
            return this;
        }

        public Session build() {//Method that returns/builds a type Session
            return new Session(this);
        }

    }

}
