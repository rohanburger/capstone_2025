/*
BankDetails.java
Bank Details Class
Author: RD Christians (230588204)
Date: 8 May 2025
*/

package za.ac.cput.domain;

import jakarta.persistence.*;

/*
 * BankDetails.java
 * Stores user's bank card information.
 * Author: RD Christians (230588204)
 * Date: 08 May 2025
 */
@Entity
@Table (name="BankDetails")
public class BankDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long backDetailsId;
    private String bankCardNum;
    private String bankCardDate;
    private String bankCardCVV;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})// Bankdetails can have many to one relationship with bankbranch
    // if you pesist/save or merge/update Bankdetails, associated bankbranch will also be
    @JoinColumn(name = "bankBranchId")
    private BankBranch bankBranch;

    //default constructor
    protected BankDetails() {

    }

    // Constructor
    private BankDetails(Builder builder) {
        this.backDetailsId = builder.backDetailsId;
        this.bankCardNum = builder.bankCardNum;
        this.bankCardDate = builder.bankCardDate;
        this.bankCardCVV = builder.bankCardCVV;
        this.bankBranch = builder.bankBranch;
    }

    // Getters
    public Long getBackDetailsId() {
        return backDetailsId;
    }
    public String getBankCardNum() {
        return bankCardNum;
    }

    public String getBankCardDate() {
        return bankCardDate;
    }

    public String getBankCardCVV() {
        return bankCardCVV;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "BankDetails{" +
                "CardNum='" + bankCardNum + '\'' +
                ", ExpiryDate='" + bankCardDate + '\'' +
                ", CVV='" + bankCardCVV + '\'' +
                ", Branch=" + (bankBranch != null ? bankBranch.getBankBranchName() : "N/A") +
                '}';
    }

    // Builder pattern for easy object creation
    public static class Builder {
        private Long backDetailsId;
        private String bankCardNum;
        private String bankCardDate;
        private String bankCardCVV;
        private BankBranch bankBranch;

        public Builder setBackDetailsId(Long backDetailsId) {
            this.backDetailsId = backDetailsId;
            return this;
        }
        public Builder setBankCardNum(String bankCardNum) {
            this.bankCardNum = bankCardNum;
            return this;
        }

        public Builder setBankCardDate(String bankCardDate) {
            this.bankCardDate = bankCardDate;
            return this;
        }

        public Builder setBankCardCVV(String bankCardCVV) {
            this.bankCardCVV = bankCardCVV;
            return this;
        }

        public Builder setBankBranch(BankBranch bankBranch) {
            this.bankBranch = bankBranch;
            return this;
        }

        public Builder copy(BankDetails bankDetails) {
            this.backDetailsId = bankDetails.backDetailsId;
            this.bankCardNum = bankDetails.bankCardNum;
            this.bankCardDate = bankDetails.bankCardDate;
            this.bankCardCVV = bankDetails.bankCardCVV;
            this.bankBranch = bankDetails.bankBranch;
            return this;
        }

        public BankDetails build() {
            return new BankDetails(this);
        }
    }
}
