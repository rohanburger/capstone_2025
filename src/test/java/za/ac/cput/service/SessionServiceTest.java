package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.Factory.*;
import za.ac.cput.domain.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
    SessionServiceTest.java
    Session Service Test
    Author:Rohan Janzen Burger 230171990
    Date:25/05/2025
*/
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SessionServiceTest {
    private User user;
    private Driver driver;
    private Location location;
    private Payment payment;
    private Session session;
    private Set<BankDetails> bankDetails;
    private BankBranch bankBranch;

    @Autowired
    private SessionService service;

    @BeforeEach
    void Setup(){
        bankDetails = new HashSet<>();
      payment = PaymentFactory.createPaymentFactory(150.0f);
      driver = DriverFactory.createDriver("John","Doe","0827877878","<EMAIL>","LIC101","1234",null);
      location = LocationFactory.createLocation( DropoffFactory.createDropoff("35 Hoodwink","Claremont","Cape Town"),
              PickupFactory.createPickupWithAttributes("40 Hoodwink","Claremont","Cape Town"));
      bankBranch =  BankBranchFactory.createBankBranch("Capitec", "CT543");
      bankDetails.add(BankDetailsFactory.createBankDetails("1321416546", "08/29", "128", bankBranch));
      assertNotNull(bankDetails);
      user = UserFactory.createUserWithAllAttributes("John","Doe","0827877878","john@gmail.com","1234", bankDetails);
      Session createsession= SessionFactory.createSessionFactory( user, driver, location, 2,  "Active",payment);
      session = service.create(createsession);
      assertNotNull(session);
      assertNotNull(session.getSessionid());

    }



    @Test
    void create() {
        Session created = service.create(session);
       assertNotNull(created);
        System.out.println(created);

    }

    @Test
    void read() {
        Session sessionread = service.read(session.getSessionid());
        assertNotNull(sessionread);
        System.out.println(sessionread);


    }

    @Test
    void update() {
        Session sessionupdate = new Session.Builder().copy(session).setPassengerCount(5).build();
        assertNotNull(sessionupdate);
        Session updated = service.update(sessionupdate);
        assertNotNull(updated);
        System.out.println(updated);

    }

    @Test
    void delete() {
        boolean deleted = service.delete(session.getSessionid());
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}