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
    void InvalidPickupStreet() {
        Pickup pickup = PickupFactory.createPickupWithAttributes( "", "Woodstock", "Cape Town");
        assertNotNull(pickup); //checks if pickupInfo is not null
        //validates to ensure all attributes have the expected values
        assertEquals("",pickup.getPickupStreet() );

    }

    //tests pickup object wih an empty suburb input to ensure check handling of invalid input
    @Test
    void InvalidPickupSuburb() {
        Pickup pickupInfo = PickupFactory.createPickupWithAttributes( "Mackles Rd", "", "Cape Town");
        assertNotNull(pickupInfo);
        assertEquals("", pickupInfo.getPickupSuburb());
    }

    @Test
    void InvalidPickupCity() {
        Pickup pickupInfo = PickupFactory.createPickupWithAttributes( "Mackles Rd", "Woodstock", "");
        assertNotNull(pickupInfo);
        assertEquals("", pickupInfo.getPickupCity());
    }

}
