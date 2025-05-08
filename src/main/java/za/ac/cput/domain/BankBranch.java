/*
BankBranch.java
Bank branch info used for linking accounts.
Author: RD Christians (230588204)
Date: 8 May 2025
*/

package za.ac.cput.domain;


public class BankBranch {
    private String bankBranchId;
    private String bankBranchName;
    private String bankBranchCode;

    // Constructor
    public BankBranch(String bankBranchId, String bankBranchName, String bankBranchCode) {
        this.bankBranchId = bankBranchId;
        this.bankBranchName = bankBranchName;
        this.bankBranchCode = bankBranchCode;
    }

    // Getters
    public String getBankBranchId() {
        return bankBranchId;
    }

    public String getBankBranchName() {
        return bankBranchName;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "ID='" + bankBranchId + '\'' +
                ", Name='" + bankBranchName + '\'' +
                ", Code='" + bankBranchCode + '\'' +
                '}';
    }

    // builder for flexibility
    public static class Builder {
        private String bankBranchId;
        private String bankBranchName;
        private String bankBranchCode;

        public Builder setBankBranchId(String bankBranchId) {
            this.bankBranchId = bankBranchId;
            return this;
        }

        public Builder setBankBranchName(String bankBranchName) {
            this.bankBranchName = bankBranchName;
            return this;
        }

        public Builder setBankBranchCode(String bankBranchCode) {
            this.bankBranchCode = bankBranchCode;
            return this;
        }

        public BankBranch build() {
            return new BankBranch(bankBranchId, bankBranchName, bankBranchCode);
        }
    }
}
