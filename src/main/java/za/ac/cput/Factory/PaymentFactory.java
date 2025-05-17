package za.ac.cput.Factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Session;
import za.ac.cput.Helper.*;
/*
    PaymentFactory.java
    Payment factory Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
public class PaymentFactory {
    public static Payment createPaymentFactory(String paymentid, Float paymentamount){
        if (PaymentHelper.isNullOrEmpty(paymentid)){ //Calls helper method to ensure its not null or empty //When Attribute is automated not needed.
            System.out.println("Errror:Payment ID is null or empty");//Error message if true
        }

        if(PaymentHelper.isZero(paymentamount)){//Call helper method to ensure the the float value isnt null
            System.out.println("Error:Payment Amount is Zero");//Error message if true
        }

        return new Payment.Builder()
            .setPaymentid(paymentid)
            .setPaymentamount(paymentamount)
            .build();

    }

}
