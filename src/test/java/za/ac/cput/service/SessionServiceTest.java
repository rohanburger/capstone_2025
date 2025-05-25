package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.Factory.SessionFactory;
import za.ac.cput.domain.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SessionServiceTest {
    private Passenger passenger;
    private Driver driver;
    private Location location;
    private Payment payment;

    @Autowired
    private static SessionService service;

    @BeforeEach
    void Setup(){
        passenger = new Passenger( );
        driver = new Driver();
        location= new Location();
        payment = new Payment();
    }

    private Session session = SessionFactory.createSessionFactory("123", passenger, driver, location, 2,  "Active",payment);

    @Test
    void create() {
       Session session1 = SessionFactory.createSessionFactory("124", passenger, driver, location, 2,  "Active",payment);
       assertNotNull(session1);
        System.out.println(session1.toString());

    }

    @Test
    void read() {
        Session sessionread = service.read(session.getSessionid());
        assertNotNull(sessionread);
        System.out.println(sessionread.toString());

    }

    @Test
    void update() {
        Session sessionupdate = new Session.Builder().setPassengerCount(3).build();
        assertNotNull(sessionupdate);
        Session updated = service.update(sessionupdate);
        assertNotNull(updated);
        System.out.println(sessionupdate.toString());
    }

    @Test
    void delete() {
        boolean deleted = service.delete(session.getSessionid());
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        List<Session> sessions = service.getAll();
        assertFalse(sessions.isEmpty());
    }
}