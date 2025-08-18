/*
BankBranchFactoryTest.java
Bank branch factory test class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/

package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BankBranch;

import static org.junit.jupiter.api.Assertions.*;

class BankBranchFactoryTest {

    @Test
    void invalidBranchName() {
        BankBranch branch = BankBranchFactory.createBankBranch("", "CT543");
        assertNotNull(branch);
        assertEquals("", branch.getBankBranchName());
    }

    @Test
    void invalidBranchCode() {
        BankBranch branch = BankBranchFactory.createBankBranch("Capitec", "");
        assertNotNull(branch);
        assertEquals("", branch.getBankBranchCode());
    }
}
