package za.ac.cput.Factory;
import za.ac.cput.Helper.LocationHelper;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.Pickup;

public class LocationFactory {

    public static Location createLocation(  String locationId, Dropoff dropoff,  Pickup pickup){
        if(LocationHelper.isEmptyOrNull(locationId)){
            System.out.println("locationId is null or empty");
        }
        if(LocationHelper.isNullorEmpty(dropoff)||LocationHelper.isNullorEmpty(pickup)){
            System.out.println("dropoff or pickup location is null or empty");
        }
        if(LocationHelper.isEqual(dropoff,pickup)){
            System.out.println("Dropoff location cannot be the same as pickup location");
        }


        return new Location.LocationBuilder()
                .setLocationId(locationId)
                .setDropoff(dropoff)
                .setPickup(pickup).build();

    }
}
