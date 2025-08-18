package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.PickupFactory;
import za.ac.cput.domain.Pickup;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PickupServiceTest {

    @Autowired
    private PickupService service;
    private Pickup pickup ;

    @BeforeEach
    void Setup(){
     Pickup createpickup =PickupFactory.createPickupWithAttributes( "Mackles Rd", "Woodstock", "Cape Town");
     pickup = service.create(createpickup);
     assertNotNull(pickup);
     assertNotNull(pickup.getPickupId());

    }

    @Test
    void a_create() {
        Pickup created = service.create(pickup);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test

    void b_read() {
        Pickup read = service.read(pickup.getPickupId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Pickup newPickup = new Pickup.PickupBuilder().copy(pickup).setPickupSuburb("Plumstead")
                .build();
        Pickup updated = service.update(newPickup);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void d_delete() {
        boolean deleted = service.delete(pickup.getPickupId());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }

}