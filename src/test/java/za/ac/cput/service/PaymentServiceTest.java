package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import za.ac.cput.Factory.PaymentFactory;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Session;
import java.util.List;
/*
    PaymentServiceTest.java
    Payment Service Test
    Author:Rohan Janzen Burger 230171990
    Date:25/05/2025
*/

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentServiceTest {
    @Autowired
    private static PaymentService service;
    private Payment payment = PaymentFactory.createPaymentFactory("123", 150.0f);

    @Test
    void create() {
        Payment payment1 = PaymentFactory.createPaymentFactory("124", 152.0f);
        assertNotNull(payment1);
        System.out.println(payment1);
    }

    @Test
    void read() {
        Payment paymentread = service.read(payment.getPaymentid());
        assertNotNull(paymentread);
        System.out.println(paymentread);
    }

    @Test
    void update() {
        Payment paymentupdate = new Payment.Builder().setPaymentamount(120.0f).build();
        assertNotNull(paymentupdate);
        Payment updated = service.update(paymentupdate);
        assertNotNull(updated);
        System.out.println(paymentupdate);

    }

    @Test
    void delete() {
        boolean deleted = service.delete(payment.getPaymentid());
        assertTrue(deleted);
    }

    @Test
    void getAll() {
        List<Payment> sessions = service.getAll();
        assertFalse(sessions.isEmpty());
    }
}