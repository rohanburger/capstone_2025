package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/*
    Session.java
    Session entity class
    Author: Rohan Janzen Burger 230171990
    Date: 08/05/2025
*/
@Entity
@Table(name = "Session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    // Many sessions can belong to one user
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "passengerId")
    private User user;

    // Many sessions can have one driver
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "driverId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Driver driver;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "locationId")
    private Location location;

    private int passengerCount;
    private String sessionStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId")
    private Payment payment;

    // Default constructor
    protected Session() {}

    private Session(Builder builder) {
        this.sessionId = builder.sessionId;
        this.user = builder.user;
        this.driver = builder.driver;
        this.location = builder.location;
        this.passengerCount = builder.passengerCount;
        this.sessionStatus = builder.sessionStatus;
        this.payment = builder.payment;
    }

    // Getters
    public Long getSessionId() {
        return sessionId;
    }

    public User getUser() {
        return user;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getLocation() {
        return location;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public String getSessionStatus() {
        return sessionStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "============================\n" +
                "Session Object:\n" +
                "============================\n" +
                "Session ID: " + sessionId + '\n' +
                "Passenger Count: " + passengerCount + '\n' +
                "Session Status: " + sessionStatus + '\n' +
                user + '\n' +
                driver + '\n' +
                location + '\n' +
                payment + '\n' +
                "============================\n";
    }

    public static class Builder {
        private Long sessionId;
        private User user;
        private Driver driver;
        private Location location;
        private int passengerCount;
        private String sessionStatus;
        private Payment payment;

        public Builder setSessionId(Long sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        public Builder setUser(User user) {
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

        public Builder setPayment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public Builder copy(Session session) {
            this.sessionId = session.sessionId;
            this.user = session.user;
            this.driver = session.driver;
            this.location = session.location;
            this.passengerCount = session.passengerCount;
            this.sessionStatus = session.sessionStatus;
            this.payment = session.payment;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }
}
