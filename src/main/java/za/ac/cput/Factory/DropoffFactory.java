package za.ac.cput.Factory;
import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.Dropoff;

/*
    DropoffFactory.java
    Dropoff Factory
    Author:Sharief Abdul
    Date:10/05/2025
*/

public class DropoffFactory {


    public static Dropoff createDropoff(String dropoffStreet, String dropoffSuburb, String dropoffCity) {

        if(Helper.isNullOrEmpty(dropoffStreet)||Helper.isNullOrEmpty(dropoffSuburb)||Helper.isNullOrEmpty(dropoffCity)){
            throw new IllegalArgumentException("Error:Drop off details are null or empty. ");
        }

        return new Dropoff.DropoffBuilder()
                .setDropoffStreet(dropoffStreet)
                .setDropoffSuburb(dropoffSuburb)
                .setDropoffCity(dropoffCity).build();

    }

}
