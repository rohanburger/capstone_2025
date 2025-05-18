package za.ac.cput.Factory;

/*  PickupFactory.java
    Pickup Factory class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 17/05/2025
*/

import za.ac.cput.Helper.PickupHelper;
import za.ac.cput.domain.Pickup;

public class PickupFactory {
    //create method with all pickup attributes
    public static Pickup createPickupWithAttributes( String pickupId,
                                                     String pickupStreet,
                                                     String pickupSuburb,
                                                     String pickupCity) {

        //check if fields are null or empty
        if(PickupHelper.isNullOrEmpty(pickupId) || PickupHelper.isNullOrEmpty(pickupStreet)
                || PickupHelper.isNullOrEmpty(pickupSuburb) || PickupHelper.isNullOrEmpty(pickupCity)) {
            System.out.println("Pickup field(s) are empty. Please provide your pickup information");
            return null;
        }

        //create and return new pickup object using Builder pattern to set attributes
        return new Pickup.PickupBuilder()
                .setPickupId(pickupId)
                .setpickupStreet(pickupStreet)
                .setPickupSuburb(pickupSuburb)
                .setPickupCity(pickupCity)
                .build();
    }

}
