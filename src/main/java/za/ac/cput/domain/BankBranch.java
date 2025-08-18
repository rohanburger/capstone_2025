/*
BankBranch.java
Bank branch info used for linking accounts.
Author: RD Christians (230588204)
Date: 8 May 2025
*/

package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
@Table(name="BankBranch")
public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankBranchId;
    private String bankBranchName;
    private String bankBranchCode;

    // Constructor
    protected BankBranch() {

    }
    private BankBranch(Builder builder) {
        this.bankBranchId = builder.bankBranchId;
        this.bankBranchName = builder.bankBranchName;
        this.bankBranchCode = builder.bankBranchCode;
    }

    // Getters
    public Long getBankBranchId() {
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
        private Long bankBranchId;
        private String bankBranchName;
        private String bankBranchCode;

        public Builder setBankBranchId(Long bankBranchId) {
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

        public Builder copy(BankBranch bankBranch) {
            this.bankBranchId = bankBranch.bankBranchId;
            this.bankBranchName = bankBranch.bankBranchName;
            this.bankBranchCode = bankBranch.bankBranchCode;
            return this;
        }

        public BankBranch build() {
            return new BankBranch(this);
        }
    }
}
