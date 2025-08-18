package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Factory.PaymentFactory;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.Interfaces.IPaymentService;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/*
    PaymentServiceTest.java
    Payment Service Test
    Author:Rohan Janzen Burger 230171990
    Date:25/05/2025
*/


@SpringBootTest
class PaymentServiceTest {
    @Autowired
    private PaymentService service;
    private Payment payment;

    @BeforeEach
    void Setup(){
        Payment createpayment = PaymentFactory.createPaymentFactory( 152.0f);
        payment = service.create(createpayment);
        assertNotNull(payment);
    }

    @Test
    void create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void read() {
        Payment paymentread = service.read(payment.getPaymentid());
        assertNotNull(paymentread);
        System.out.println(paymentread);
    }

    @Test
    void update() {
        Payment paymentupdate = new Payment.Builder().copy(payment).setPaymentamount(120.0f).build();
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
        System.out.println(service.getAll());
    }
}