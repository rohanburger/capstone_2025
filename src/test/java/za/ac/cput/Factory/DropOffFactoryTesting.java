package za.ac.cput.Factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Dropoff;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
    DropoffFactoryTest.java
    Dropoff Factory Testing
    Author:Sharief Abdul
    Date:10/05/2025

*/
public class DropOffFactoryTesting {
    @Test
    public void InvalidDropoffStreet() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("","Claremont","Cape Town");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffStreet());
    }

    @Test
    public void InvalidDropoffSuburb() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("35 Hoodwink","","Cape Town");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffSuburb());
    }

    @Test
    public void InvalidDropOffCity() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("35 Hoodwink","Claremont","");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffCity());
    }


}
