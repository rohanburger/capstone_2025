/*
BankDetailsFactory.java
Bank details factory class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/

package za.ac.cput.Factory;

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;

import java.sql.SQLOutput;

public class BankDetailsFactory {

    public static BankDetails createBankDetails(String bankCardNum, String bankCardDate, String bankCardCVV, BankBranch bankBranch) {
        if (Helper.isNullOrEmpty(bankCardNum) || Helper.isNullOrEmpty(bankCardDate)
                || Helper.isNullOrEmpty(bankCardCVV) ) {
            System.out.println("Error: Bank details are null or empty.");
        }

        return new BankDetails.Builder()
                .setBankCardNum(bankCardNum)
                .setBankCardDate(bankCardDate)
                .setBankCardCVV(bankCardCVV)
                .setBankBranch(bankBranch)
                .build();
    }
}
