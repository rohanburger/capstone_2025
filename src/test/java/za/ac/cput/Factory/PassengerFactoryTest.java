package za.ac.cput.Factory;

/*  PassengerFactoryTest.java
    Passenger factory test class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 17/05/2025
*/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.domain.Passenger;

class PassengerFactoryTest {
        private BankDetails bankdetails; //holds bank details for passenger object

    //setup bank details before each test case
        @BeforeEach
        void setUp() {
            bankdetails = new BankDetails();
        }

        //creates passenger object with all attributes test case
        @Test
        void testCreatePassengerWithAllAttributes() {
            Passenger p1 = PassengerFactory.createPassengerWithAllAttributes("P002", "Ruben", "Newman",
                    "0629348182", "rnewman@gmail.com", bankdetails);

            assertNotNull(p1); //checks if p1 object is not null
            //validates to ensure all attributes have the expected values
            assertEquals("P002", p1.getPassId());
            assertEquals("Ruben", p1.getPassName());
            assertEquals("Newman", p1.getPassSurname());
            assertEquals("0629348182", p1.getPassPhoneNum());
            assertEquals("rnewman@gmail.com", p1.getPassEmail());

            //print out passenger object
            System.out.println(p1.toString());
        }

        //create passenger object with no passName to test the handling of invalid input
        @Test
        void testCreateFailedPassenger() {
            Passenger p2 = PassengerFactory.createPassengerWithAllAttributes("P003", "", "White",
                    "0827948102", "dwhite2002@gmail.com", bankdetails);

            assertNotNull(p2); //checks if p2 object is not null
            assertEquals("P003", p2.getPassId());
            assertEquals("Dora", p2.getPassName()); //checks if passName is assigned
            assertEquals("White", p2.getPassSurname());
            assertEquals("0827948102", p2.getPassPhoneNum());
            assertEquals("dwhite2002gmail.com", p2.getPassEmail());

            System.out.println(p2.toString());
        }

        //test case to create passenger object with invalid email input
        @Test
        void testPassengerWithInvalidEmail() {
            Passenger p3 = PassengerFactory.createPassengerWithAllAttributes("P004", "Ryan", "Posnik",
                    "0823392824", "rposnik-@gmail.com", bankdetails);

            assertNotNull(p3);
            //checks if email is correct
            assertEquals("rposnik@outlook.com", p3.getPassEmail());
        }

        //tests to create passenger object with only passId, passName, and passSurname
        @Test
        void testCreatePassenger() {
            Passenger p4 = PassengerFactory.createPassenger("P001", "John", "Malan");
            assertNotNull(p4); //checking if object p4 is not null
            assertEquals("P001", p4.getPassId());
            assertEquals("John", p4.getPassName());
            assertEquals("Malan", p4.getPassSurname());

            System.out.println(p4.toString());
        }

    }
