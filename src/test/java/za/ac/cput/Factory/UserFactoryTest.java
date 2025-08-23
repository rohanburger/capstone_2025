package za.ac.cput.Factory;

/*  UserFactoryTest.java
    Passenger factory test class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 17/05/2025
*/

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BankBranch;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.User;

import java.util.HashSet;
import java.util.Set;

class UserFactoryTest {//holds bank details for passenger object

        private User users;
        private BankBranch bankbranches;
        private Set<BankDetails> bankdetails;

        @BeforeEach
        void setUp() {
            bankdetails = new HashSet<>();
           bankbranches=BankBranchFactory.createBankBranch("ABSA","1001111");
           bankdetails.add(BankDetailsFactory.createBankDetails("1241424","12/4","857",bankbranches));
            bankdetails.add(BankDetailsFactory.createBankDetails("0900909","16/4","811",bankbranches));
        }

        @Test
        void InvalidUserName() {
            User user = UserFactory.createUserWithAllAttributes( "", "Newman",
                    "0629348182", "john.doe@gmail.com","12414",bankdetails);
            assertNotNull(user);
            assertEquals("", user.getUserName());
        }

        @Test
        void InvalidSurname() {
            User user = UserFactory.createUserWithAllAttributes( "Ruben", "",
                    "0629348182", "john.doe@gmail.com","12414",bankdetails);
            assertNotNull(user);
            assertEquals("", user.getUserSurname()); //checks if passName is assigned

        }


        @Test
        void InvalidEmail() {
            User user = UserFactory.createUserWithAllAttributes("Ryan", "Posnik",
                    "0823392824", "rposnikgmail.com","12414", bankdetails);
            assertNotNull(user);
            //checks if email is correct
            assertEquals("rposnikgmail.com", user.getUserEmail());
        }

        @Test
        void InvalidPhoneNumber() {
            User user = UserFactory.createUserWithAllAttributes("Ryan", "Posnik",
                    "", "john.doe@gmail.com","12414", bankdetails);
        }

    }
