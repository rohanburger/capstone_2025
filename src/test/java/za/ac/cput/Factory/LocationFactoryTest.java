package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Dropoff;
import za.ac.cput.domain.Location;
import za.ac.cput.domain.Pickup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/*
    LocationFactoryTest.java
    Location Factory Testing
    Author:Sharief Abdul
    Date:10/05/2025
*/

public class LocationFactoryTest {

    private String locationId;
    private Dropoff dropoff,dropoff2;
    private Pickup pickup,pickup2;

    @BeforeEach
    public void setUp(){
        dropoff=new Dropoff();
        pickup=new Pickup();

        dropoff2=DropoffFactory.createDropoff("001","35 Hoodwink","Claremont","Cape Town");
        pickup2=new Pickup.PickupBuilder()
                .setPickupId("001")
                .setpickupStreet("35 Hoodwink")
                .setPickupSuburb("Claremont")
                .setPickupCity("Cape Town").build();
    }

    @Test
    public void createLocation_LocationIdNullOrEmpty(){
        Location location=LocationFactory.createLocation("",dropoff,pickup);
        assertNotNull(location);
        assertEquals("",location.getLocationId());

    }

    @Test
    public void createLocation_PickupEqualsDropoff(){
        Location location=LocationFactory.createLocation("001",dropoff2,pickup2);
        assertNotNull(location);
        assertEquals(dropoff2.getDropoffStreet(),pickup2.getPickupStreet());
        assertEquals(dropoff2.getDropoffSuburb(),pickup2.getPickupSuburb());
        assertEquals(dropoff2.getDropoffCity(),pickup2.getPickupCity());

    }



}
