package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.PassengerFactory;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.Passenger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PassengerServiceTest {
    private BankDetails bankdetails;

    @Autowired
    private static PassengerService service;

    @BeforeEach
    void setUp() {
        bankdetails = new BankDetails();
    }

    private Passenger passenger = PassengerFactory.createPassengerWithAllAttributes("P003", "Scarlette", "Poole",
            "0827554251", "spoole@gmail.com", bankdetails);

    @Test
    @Order(1)
    void a_create() {
        Passenger created = service.create(passenger);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void b_read() {
        Passenger read = service.read(passenger.getPassId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void c_update() {
        Passenger newPassenger = new Passenger.PassengerBuilder().setPassName("Tina")
                .build();
        Passenger updated = service.update(newPassenger);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void d_delete() {
        boolean deleted = service.delete(passenger.getPassId());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println(service.getAll());
    }

}