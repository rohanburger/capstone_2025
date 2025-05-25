package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.PickupFactory;
import za.ac.cput.domain.Pickup;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PickupServiceTest {

    @Autowired
    private static PickupService service;

    private Pickup pickup = PickupFactory.createPickupWithAttributes("PU123", "Mackles Rd", "Woodstock", "Cape Town");

    @Test
    @Order(1)
    void a_create() {
        Pickup created = service.create(pickup);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void b_read() {
        Pickup read = service.read(pickup.getPickupId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void c_update() {
        Pickup newPickup = new Pickup.PickupBuilder().copy(pickup).setPickupSuburb("Plumstead")
                .build();
        Pickup updated = service.update(newPickup);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void d_delete() {
        boolean deleted = service.delete(pickup.getPickupId());
        assertTrue(deleted);
        System.out.println(deleted);
    }

    @Test
    @Order(5)
    void e_getAll() {
        System.out.println(service.getAll());
    }

}