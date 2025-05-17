/*
BankBranchFactoryTest.java
Bank branch factory test class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.Factory.BankBranchFactory;
import static org.junit.jupiter.api.Assertions.*;

class BankBranchFactoryTest {

    @Test
    void createBankBranch_success() {
        BankBranch branch = BankBranchFactory.createBankBranch("Cape Town Central", "CT543");

        assertNotNull(branch);
        assertNotNull(branch.getBankBranchId());
        assertEquals("Cape Town Central", branch.getBankBranchName());
        assertEquals("CT543", branch.getBankBranchCode());
    }

    @Test
    void createBankBranch_nullFields() {
        BankBranch branch = BankBranchFactory.createBankBranch("", null);
        assertNull(branch);
    }
}
