//package za.ac.cput.service;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.Factory.UserFactory;
//import za.ac.cput.domain.BankDetails;
//import za.ac.cput.domain.User;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class UserServiceTest {
//    @Autowired
//    private UserService service;
//
//    @BeforeEach
//    void setUp() {
//        bankdetails = new BankDetails();
//    }
//
//    private User passenger = UserFactory.createUserWithAllAttributes( "Scarlette", "Poole",
//            "0827554251", "spoole@gmail.com", bankdetails);
//
//    @Test
//    @Order(1)
//    void a_create() {
//        User created = service.create(passenger);
//        assertNotNull(created);
//        System.out.println(created);
//    }
//
//    @Test
//    @Order(2)
//    void b_read() {
//        User read = service.read(passenger.getUserId());
//        assertNotNull(read);
//        System.out.println(read);
//    }
//
//    @Test
//    @Order(3)
//    void c_update() {
//        User newPassenger = new User.PassengerBuilder().setPassName("Tina")
//                .build();
//        User updated = service.update(newPassenger);
//        assertNotNull(updated);
//        System.out.println(updated);
//    }
//
//    @Test
//    @Order(4)
//    void d_delete() {
//        boolean deleted = service.delete(passenger.getPassId());
//        assertTrue(deleted);
//        System.out.println(deleted);
//    }
//
//    @Test
//    @Order(5)
//    void e_getAll() {
//        System.out.println(service.getAll());
//    }
//
//}