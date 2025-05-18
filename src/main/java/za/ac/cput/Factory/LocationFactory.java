package za.ac.cput.Factory;
import za.ac.cput.Helper.LocationHelper;
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

    public static Location createLocation(  String locationId, Dropoff dropoff,  Pickup pickup){
        if(LocationHelper.isEmptyOrNull(locationId)){
            System.out.println("locationId is null or empty");
        }
        if(LocationHelper.isNullorEmpty(dropoff)||LocationHelper.isNullorEmpty(pickup)){
            System.out.println("dropoff or pickup location is null or empty");
        }
        if(LocationHelper.isEqual(pickup.getPickupStreet(), dropoff.getDropoffStreet())&&LocationHelper.isEqual(pickup.getPickupSuburb(), dropoff.getDropoffSuburb())&&LocationHelper.isEqual(pickup.getPickupCity(), dropoff.getDropoffCity())){
            System.out.println("Pickup Location cannot be the same as Dropoff Location");
        }



        return new Location.LocationBuilder()
                .setLocationId(locationId)
                .setDropoff(dropoff)
                .setPickup(pickup).build();

    }
}
