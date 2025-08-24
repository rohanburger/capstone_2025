package za.ac.cput.Factory;

/*  PickupFactory.java
    Pickup Factory class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 17/05/2025
*/

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.Pickup;

public class PickupFactory {
    //create method with all pickup attributes
    public static Pickup createPickupWithAttributes(
                                                     String pickupStreet,
                                                     String pickupSuburb,
                                                     String pickupCity) {

        //check if fields are null or empty
        if( Helper.isNullOrEmpty(pickupStreet)
                || Helper.isNullOrEmpty(pickupSuburb) || Helper.isNullOrEmpty(pickupCity)) {
            throw new IllegalArgumentException("Error:Pickup field(s) are empty.");

        }

        //create and return new pickup object using Builder pattern to set attributes
        return new Pickup.PickupBuilder()
                .setpickupStreet(pickupStreet)
                .setPickupSuburb(pickupSuburb)
                .setPickupCity(pickupCity)
                .build();
    }

}
