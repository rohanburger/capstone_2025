/*
BankBranchFactory.java
Bank branch factory class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/


package za.ac.cput.Factory;

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.BankBranch;

public class BankBranchFactory {

    public static BankBranch createBankBranch(String bankBranchName, String bankBranchCode) {
        if (Helper.isNullOrEmpty(bankBranchName) || Helper.isNullOrEmpty(bankBranchCode)) {
            System.out.println( "Error: Bank branch details are null or empty");
        }

        return new BankBranch.Builder()
                .setBankBranchName(bankBranchName)
                .setBankBranchCode(bankBranchCode)
                .build();
    }
}
