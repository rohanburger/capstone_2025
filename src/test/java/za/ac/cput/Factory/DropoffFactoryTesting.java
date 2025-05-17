package za.ac.cput.Factory;
import org.junit.jupiter.api.BeforeEach;
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


public class DropoffFactoryTesting {

    private String dropoffId;
    private String dropoffStreet;
    private String dropoffSuburb;
    private String dropoffCity;

    @Test
    public void createDropoff_NoEDropoffId() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("","35 Hoodwink","Claremont","Cape Town");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffId());
    }

    @Test
    public void createDropoff_NoEDropStreet() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("001"," ","Claremont","Cape Town");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffStreet());
    }

    @Test
    public void createDropoff_NoEDropoffSuburb() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("001","35 Hoodwink","","Cape Town");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffSuburb());
    }

    @Test
    public void createDropoff_NoEDropoffCity() { //NoE->Null or Empty
        Dropoff dropoff = DropoffFactory.createDropoff("001","35 Hoodwink","Claremont","Cape Town");
        assertNotNull(dropoff);
        assertEquals("", dropoff.getDropoffCity());
    }
}
