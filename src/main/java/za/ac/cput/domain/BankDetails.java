/*
BankDetails.java
Bank Details Class
Author: RD Christians (230588204)
Date: 8 May 2025
*/

package za.ac.cput.domain;

/*
 * BankDetails.java
 * Stores user's bank card information.
 * Author: RD Christians (230588204)
 * Date: 08 May 2025
 */

public class BankDetails {
    private String bankCardNum;
    private String bankCardDate;
    private String bankCardCVV;
    private BankBranch bankBranch; // Added link to BankBranch

    // Constructor
    public BankDetails(String bankCardNum, String bankCardDate, String bankCardCVV, BankBranch bankBranch) {
        this.bankCardNum = bankCardNum;
        this.bankCardDate = bankCardDate;
        this.bankCardCVV = bankCardCVV;
        this.bankBranch = bankBranch;
    }

    // Getters
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
        private String bankCardNum;
        private String bankCardDate;
        private String bankCardCVV;
        private BankBranch bankBranch;

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

        public BankDetails build() {
            return new BankDetails(bankCardNum, bankCardDate, bankCardCVV, bankBranch);
        }
    }
}
