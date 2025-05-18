package za.ac.cput.Factory;

/*  PassengerFactory.java
    Passenger Factory class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 15/05/2025
*/

import za.ac.cput.Helper.PassengerHelper;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.Passenger;

public class PassengerFactory {
    //create Passenger objects with all attributes
    public static Passenger createPassengerWithAllAttributes(String passId,
                                                             String passName,
                                                             String passSurname,
                                                             String passPhoneNum,
                                                             String passEmail,
                                                             BankDetails bankdetails) {

        if (PassengerHelper.isNullOrEmpty(passId) || PassengerHelper.isNullOrEmpty(passName) ||
                PassengerHelper.isNullOrEmpty(passSurname) || PassengerHelper.isNullOrEmpty(passPhoneNum) ||
                PassengerHelper.isNullOrEmpty(passEmail)) {
            System.out.println("Passenger field(s) are empty. Please fill in your information");
            return null;
        }

        if (!PassengerHelper.isValidEmail(passEmail)) {
            System.out.println("Invalid email. Try again");
            return null;
        }

        //create and return new passenger object using builder pattern
        return new Passenger.PassengerBuilder()
                .setPassId(passId)
                .setPassName(passName)
                .setPassSurname(passSurname)
                .setPassPhoneNum(passPhoneNum)
                .setPassEmail(passEmail)
                .setBankdetails(bankdetails)
                .build();

    }

}
