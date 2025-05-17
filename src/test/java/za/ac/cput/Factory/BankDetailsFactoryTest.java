/*
BankDetailsFactoryTest.java
Bank details factory test class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.Factory.BankBranchFactory;
import za.ac.cput.Factory.BankDetailsFactory;

import static org.junit.jupiter.api.Assertions.*;

class BankDetailsFactoryTest {

    @Test
    void createBankDetails_success() {
        BankBranch branch = BankBranchFactory.createBankBranch("Capitec", "SD987");
        BankDetails details = BankDetailsFactory.createBankDetails("0485792597320483", "08/29", "128", branch);

        assertNotNull(details);
        assertEquals("0485792597320483", details.getBankCardNum());
        assertEquals("08/29", details.getBankCardDate());
        assertEquals("128", details.getBankCardCVV());
        assertEquals("Capitec", details.getBankBranch().getBankBranchName());
    }

    @Test
    void createBankDetails_invalidInput() {
        BankDetails details = BankDetailsFactory.createBankDetails(null, "01/30", "456", null);
        assertNull(details);
    }
}
