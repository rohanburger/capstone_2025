package za.ac.cput.Factory;

/*  PickupFactoryTest.java
    Passenger Factory Test class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 17/05/2025
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Pickup;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PickupFactoryTest {

    //check pickup object with all attributes test case
    @Test
    void createPickupWithAttributes() {
        Pickup pickupInfo = PickupFactory.createPickupWithAttributes("PU123", "Mackles Rd", "Woodstock", "Cape Town");

        assertNotNull(pickupInfo); //checks if pickupInfo is not null
        //validates to ensure all attributes have the expected values
        assertEquals("PU123", pickupInfo.getPickupId());
        assertEquals("Mackles Rd", pickupInfo.getPickupStreet());
        assertEquals("Woodstock", pickupInfo.getPickupSuburb());
        assertEquals("Cape Town", pickupInfo.getPickupCity());

        //prints out pickup object
        System.out.println(pickupInfo.toString());
    }

    //tests pickup object wih an empty suburb input to ensure check handling of invalid input
    @Test
    void createFailedPickup() {
        Pickup pickupInfo = PickupFactory.createPickupWithAttributes("PU123", "Mackles Rd", "", "Cape Town");

        assertNotNull(pickupInfo);
        assertEquals("", pickupInfo.getPickupSuburb());
    }

}
