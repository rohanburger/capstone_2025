package za.ac.cput.domain;

/*  Passenger.java
    Passenger POJO class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 08/05/2025
*/

public class Passenger {
    //private fields that stores information
    private String passId;
    private String passName;
    private String passSurname;
    private String passPhoneNum;
    private String passEmail;
    private BankDetails bankdetails; // linked to BankDetails class

    //default constructor
    public Passenger() {
    }

    //initialises object using PassengerBuilder
    private Passenger(PassengerBuilder builder) {
        this.passId = builder.passId;
        this.passName = builder.passName;
        this.passSurname = builder.passSurname;
        this.passPhoneNum = builder.passPhoneNum;
        this.passEmail = builder.passEmail;
        this.bankdetails = builder.bankdetails;
    }

    //getter methods used for access
    public String getPassId() {
        return passId;
    }

    public String getPassName() {
        return passName;
    }

    public String getPassSurname() {
        return passSurname;
    }

    public String getPassPhoneNum() {
        return passPhoneNum;
    }

    public String getPassEmail() {
        return passEmail;
    }

    public BankDetails getBankdetails() {
        return bankdetails;
    }

    //displays string representation of object and overrides
    @Override
    public String toString() {
        return "Passenger{" +
                "passid='" + passId + '\'' +
                ", passName='" + passName + '\'' +
                ", passSurname='" + passSurname + '\'' +
                ", passPhoneNum='" + passPhoneNum + '\'' +
                ", passEmail='" + passEmail +
                ", bankdetails=" + bankdetails +
                '}';
    }

    //constructs passenger objects
    public static class PassengerBuilder {
        private String passId;
        private String passName;
        private String passSurname;
        private String passPhoneNum;
        private String passEmail;
        private BankDetails bankdetails;

        //return builder objects
        public PassengerBuilder setPassId(String passId) {
            this.passId = passId;
            return this;
        }

        public PassengerBuilder setPassName(String passName) {
            this.passName = passName;
            return this;
        }

        public PassengerBuilder setPassSurname(String passSurname) {
            this.passSurname = passSurname;
            return this;
        }

        public PassengerBuilder setPassPhoneNum(String passPhoneNum) {
            this.passPhoneNum = passPhoneNum;
            return this;
        }

        public PassengerBuilder setPassEmail(String passEmail) {
            this.passEmail = passEmail;
            return this;
        }

        public PassengerBuilder setBankdetails(BankDetails bankdetails) {
            this.bankdetails = bankdetails;
            return this;
        }

        //builds and returns a new passenger object
        public Passenger build() {
            return new Passenger(this);
        }
    }
}
