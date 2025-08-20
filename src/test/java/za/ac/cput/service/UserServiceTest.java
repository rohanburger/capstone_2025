package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.BankBranchFactory;
import za.ac.cput.Factory.BankDetailsFactory;
import za.ac.cput.Factory.UserFactory;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService service;
    private User user;
    private Set<BankDetails> bankdetails;
    private BankBranch bankBranch;

    @BeforeEach
    void setUp() {
        bankdetails = new HashSet<>();
        bankBranch =  BankBranchFactory.createBankBranch("Capitec", "CT543");
        bankdetails.add(BankDetailsFactory.createBankDetails("1321416546", "08/29", "128", bankBranch));
        User createUser = UserFactory.createUserWithAllAttributes("John","Doe","0827877878","john@gmail.com", bankdetails);
        user = service.create(createUser);
        assertNotNull(user);
        assertNotNull(user.getUserId());
    }


    @Test
    void a_create() {
        User createdUser = service.create(user);
        assertNotNull(createdUser);
        System.out.println(createdUser);
    }

    @Test
    void b_read() {
        User read = service.read(user.getUserId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        User updatedUser = new User.UserBuilder().copy(user).setUserName("Tina")
                .build();
        User updated = service.update(updatedUser);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(user.getUserId());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }

}