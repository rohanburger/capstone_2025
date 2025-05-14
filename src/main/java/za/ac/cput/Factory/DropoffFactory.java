package za.ac.cput.Factory;
import za.ac.cput.Helper.LocationHelper;
import za.ac.cput.domain.Dropoff;

public class DropoffFactory {

    public static Dropoff createDropoff(  String dropoffId, String dropoffStreet, String dropoffSuburb, String dropoffCity) {
        if(LocationHelper.isEmptyOrNull(dropoffId)){
            System.out.println("dropoffId is empty");
        }if(LocationHelper.isEmptyOrNull(dropoffStreet)||LocationHelper.isEmptyOrNull(dropoffSuburb)||LocationHelper.isEmptyOrNull(dropoffCity)){
            System.out.println("Drop off Information is not fully filled");
        }

        return new Dropoff.DropoffBuilder()
                .setDropoffId(dropoffId)
                .setDropoffStreet(dropoffStreet)
                .setDropoffSuburb(dropoffSuburb)
                .setDropoffCity(dropoffCity).build();

    }

}
