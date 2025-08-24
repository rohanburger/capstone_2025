package za.ac.cput.Factory;

/*  UserFactory.java
    Passenger Factory class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 15/05/2025
*/

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;

import java.util.Set;

public class UserFactory {
    //create Passenger objects with all attributes
    public static User createUserWithAllAttributes(
                                                        String userName,
                                                        String userSurname,
                                                        String userPhoneNum,
                                                        String userEmail,
                                                        String userPassword,
                                                        BankDetails bankdetails) {

        if (Helper.isNullOrEmpty(userName) ||
                Helper.isNullOrEmpty(userSurname) || Helper.isNullOrEmpty(userPhoneNum) ||
                Helper.isNullOrEmpty(userEmail)|| Helper.isNullOrEmpty(userPassword)) {
            throw new IllegalArgumentException("Error: All user fields are required.");

        }

        if (!Helper.isValidEmail(userEmail)) {
            throw new IllegalArgumentException("Error: Invalid email.");
        }


        return new User.UserBuilder()
                .setUserName(userName)
                .setUserSurname(userSurname)
                .setUserPhoneNum(userPhoneNum)
                .setUserEmail(userEmail)
                .setUserPassword(userPassword)
                .setBankdetails(bankdetails)
                .build();

    }

}
