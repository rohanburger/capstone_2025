package za.ac.cput.Factory;
import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.Pickup;

/*
    LocationFactory.java
    Location Factory
    Author:Sharief Abdul
    Date:10/05/2025
*/

public class LocationFactory {
    private Pickup pickup;
    private Dropoff dropoff;

    public static Location createLocation( Dropoff dropoff,  Pickup pickup){
        if(Helper.isEqual(pickup.getPickupStreet(), dropoff.getDropoffStreet())&&Helper.isEqual(pickup.getPickupSuburb(), dropoff.getDropoffSuburb())&&Helper.isEqual(pickup.getPickupCity(), dropoff.getDropoffCity())){
            throw new IllegalArgumentException("Error:Pickup Location cannot be the same as Dropoff Location");
        }

        return new Location.LocationBuilder()
                .setDropoff(dropoff)
                .setPickup(pickup).build();

    }
}
