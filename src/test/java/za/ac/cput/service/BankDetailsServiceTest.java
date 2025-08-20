package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.BankBranchFactory;
import za.ac.cput.Factory.BankDetailsFactory;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankDetailsServiceTest {

    @Autowired
    private BankDetailsService service;
    private BankDetails bankdetails;
    private BankBranch bankBranch;

    @BeforeEach
    void setUp() {
        BankBranch bankBranch = BankBranchFactory.createBankBranch("Capitec", "CT543");
        BankDetails createBankDetails = BankDetailsFactory.createBankDetails("1321416546", "08/29", "128", bankBranch);
        bankdetails = service.create(createBankDetails);
        assertNotNull(bankdetails);

    }

    @Test
    void create() {
        BankDetails created = service.create(bankdetails);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        BankDetails read = service.read(bankdetails.getBackDetailsId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        BankDetails update = new BankDetails.Builder().copy(bankdetails).setBankCardNum("0389048989340").build();
        assertNotNull(update);
        BankDetails updated = service.update(update);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean deleted = service.delete(bankdetails.getBackDetailsId());
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}