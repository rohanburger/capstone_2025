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
    public static Payment createPaymentFactory( Float paymentamount){

        if(Helper.isZero(paymentamount)){//Call helper method to ensure the the float value isnt null
            System.out.println("Error:Payment Amount is Zero");//Error message if true
        }

        return new Payment.Builder()
            .setPaymentamount(paymentamount)
            .build();

    }

}
