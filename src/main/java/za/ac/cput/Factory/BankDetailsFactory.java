/*
BankDetailsFactory.java
Bank details factory class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/

package za.ac.cput.Factory;

import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.Helper.BankHelper;

public class BankDetailsFactory {

    public static BankDetails createBankDetails(String bankCardNum, String bankCardDate, String bankCardCVV, BankBranch bankBranch) {
        if (BankHelper.isNullOrEmpty(bankCardNum) || BankHelper.isNullOrEmpty(bankCardDate)
                || BankHelper.isNullOrEmpty(bankCardCVV) || bankBranch == null) {
            return null;
        }

        return new BankDetails.Builder()
                .setBankCardNum(bankCardNum)
                .setBankCardDate(bankCardDate)
                .setBankCardCVV(bankCardCVV)
                .setBankBranch(bankBranch)
                .build();
    }
}
