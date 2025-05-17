/*
BankBranchFactory.java
Bank branch factory class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/


package za.ac.cput.Factory;

import za.ac.cput.domain.BankBranch;
import za.ac.cput.Helper.BankHelper;

public class BankBranchFactory {

    public static BankBranch createBankBranch(String bankBranchName, String bankBranchCode) {
        if (BankHelper.isNullOrEmpty(bankBranchName) || BankHelper.isNullOrEmpty(bankBranchCode)) {
            return null;
        }

        String id = BankHelper.generateId();

        return new BankBranch.Builder()
                .setBankBranchId(id)
                .setBankBranchName(bankBranchName)
                .setBankBranchCode(bankBranchCode)
                .build();
    }
}
