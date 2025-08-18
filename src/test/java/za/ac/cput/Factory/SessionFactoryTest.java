package za.ac.cput.Factory;


import org.junit.jupiter.api.*;
import org.mockito.internal.matchers.Null;
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
    private User user;
    private Driver driver;
    private Location location;
    private Payment payment;

    @BeforeEach
    void setUp(){
        driver = DriverFactory.createDriver("Jeff", "Bowers", "0812708822", "jeffbowers60@gmail.com", "LIC101", null);
        user = UserFactory.createUserWithAllAttributes("John","Doe","0827877878","john@gmail.com",null);
        location =LocationFactory.createLocation( DropoffFactory.createDropoff("35 Hoodwink","Claremont","Cape Town"),
                PickupFactory.createPickupWithAttributes("40 Hoodwink","Claremont","Cape Town"));
        payment = PaymentFactory.createPaymentFactory(150.0f);


    }

    @Test
    void createSession_PassengerCountIsZero() {
        Session session = SessionFactory.createSessionFactory( user, driver, location, 0,  "Pending",payment);
        assertNotNull(session);
        assertEquals(0, session.getPassengerCount());
    }

    @Test
    void createSession_SessionStatusNullOrEmpty() {
        Session session = SessionFactory.createSessionFactory( user, driver, location, 2,  "",payment);
        assertNotNull(session);
        assertEquals("", session.getSessionStatus());
    }

    @Test
    void createSession_InvalidSessionStatus() {
        Session session = SessionFactory.createSessionFactory( user, driver, location, 2,  "On The Road again",payment);
        assertNotNull(session);
        assertEquals("On The Road again", session.getSessionStatus());
    }




}