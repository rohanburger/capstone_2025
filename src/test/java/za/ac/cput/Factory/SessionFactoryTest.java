package za.ac.cput.Factory;


import org.junit.jupiter.api.*;
import za.ac.cput.domain.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    SessionFactoryTest.java
    Session Factory Test Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
class SessionFactoryTest {
    private Passenger passenger;
    private Driver driver;
    private Location location;
    private Payment payment;

    @BeforeEach
    void Setup(){
        passenger = new Passenger( );
        driver = new Driver();
        location= new Location();
        payment = new Payment();
    }

    @Test
    void createSession_SessionIdNullOrEmpty() {
        Session session = SessionFactory.createSessionFactory("", passenger, driver, location, 2,  "Active",payment);
        assertNotNull(session);
        assertEquals("", session.getSessionid());
    }

    @Test
    void createSession_PassengerCountIsZero() {
        Session session = SessionFactory.createSessionFactory("123", passenger, driver, location, 0,  "Pending",payment);
        assertNotNull(session);
        assertEquals(0, session.getPassengerCount());
    }

    @Test
    void createSession_SessionStatusNullOrEmpty() {
        Session session = SessionFactory.createSessionFactory("123", passenger, driver, location, 2,  "",payment);
        assertNotNull(session);
        assertEquals("", session.getSessionStatus());
    }

    @Test
    void createSession_InvalidSessionStatus() {
        Session session = SessionFactory.createSessionFactory("123", passenger, driver, location, 2,  "On The Road again",payment);
        assertNotNull(session);
        assertEquals("On The Road again", session.getSessionStatus());
    }




}