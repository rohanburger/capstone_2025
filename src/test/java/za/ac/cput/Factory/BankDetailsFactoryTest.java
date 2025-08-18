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
import static org.junit.jupiter.api.Assertions.*;

class BankDetailsFactoryTest {

    @Test
    void invalidBankCardNum() {
        BankDetails details = BankDetailsFactory.createBankDetails("", "08/29", "128",
                BankBranchFactory.createBankBranch("Capitec", "CT543"));
        assertNotNull(details);
        assertEquals("", details.getBankCardNum());
    }

    @Test
    void invalidBankCardDate() {
        BankDetails details = BankDetailsFactory.createBankDetails("1234567890", "", "128",
                BankBranchFactory.createBankBranch("Capitec", "CT543"));
        assertNotNull(details);
        assertEquals("", details.getBankCardDate());
    }

    @Test
    void invalidBankCardCVV() {
        BankDetails details = BankDetailsFactory.createBankDetails("1234567890", "08/29", "",
                BankBranchFactory.createBankBranch("Capitec", "CT543"));
    }


}
