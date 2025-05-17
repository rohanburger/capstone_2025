package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;

import static org.junit.jupiter.api.Assertions.*;
/*
    PaymentFactoryTest.java
    Payment Factory Test Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
class PaymentFactoryTest {

    @Test
    void createPaymentFactory_paymentIDNullOrEmpty() {
        Payment payment = PaymentFactory.createPaymentFactory("", 150.0f);
        assertNotNull(payment);
        assertEquals("", payment.getPaymentid());
    }

    @Test
    void createPaymentFactory_paymentisZero() {
        Payment payment = PaymentFactory.createPaymentFactory("123", 0.0f);
        assertNotNull(payment);
        assertEquals(0.0f, payment.getPaymentamount());
    }


}