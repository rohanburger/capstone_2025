package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.BankBranchFactory;
import za.ac.cput.domain.BankBranch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BankBranchServiceTest {

    @Autowired
    private BankBranchService service;
    private BankBranch bankBranch;

    @BeforeEach
    void setUp() {
        BankBranch createBankBranch = BankBranchFactory.createBankBranch("Capitec", "CT543");
        bankBranch = service.create(createBankBranch);
        assertNotNull(bankBranch);
        assertNotNull(bankBranch.getBankBranchId());
    }
    @Test
    void create() {
        BankBranch created = service.create(bankBranch);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        BankBranch read = service.read(bankBranch.getBankBranchId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void update() {
        BankBranch newBranch = new BankBranch.Builder().copy(bankBranch).setBankBranchName("ABSA").build();
        assertNotNull(newBranch);
        BankBranch updated = service.update(newBranch);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void delete() {
        boolean deleted = service.delete(bankBranch.getBankBranchId());
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        System.out.println( service.getAll());
    }
}