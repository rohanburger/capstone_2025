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
    private Dropoff dropoff;
    private Pickup pickup;

    @BeforeEach
    public void setUp(){
        dropoff=DropoffFactory.createDropoff("35 Hoodwink","Claremont","Cape Town");
        pickup =PickupFactory.createPickupWithAttributes("35 Hoodwink","Claremont","Cape Town");
    }

    @Test
     void createLocation_PickupEqualsDropoff(){
        Location location=LocationFactory.createLocation(dropoff,pickup);
        assertNotNull(location);
        assertEquals(dropoff.getDropoffStreet(),pickup.getPickupStreet());
        assertEquals(dropoff.getDropoffSuburb(),pickup.getPickupSuburb());
        assertEquals(dropoff.getDropoffCity(),pickup.getPickupCity());
    }



}
