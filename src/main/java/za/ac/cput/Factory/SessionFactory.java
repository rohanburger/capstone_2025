package za.ac.cput.Factory;

import za.ac.cput.domain.*;
import za.ac.cput.Helper.SessionHelper;
/*
    SessionFactory.java
    Session factory Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
public class SessionFactory {
    public static Session createSessionFactory(String sessionID, Passenger passenger, Driver driver, Location location, int passengerCount, String sessionStatus, Payment payment){
        if (SessionHelper.isNullOrEmpty(sessionID)){//calls the String null or empty methods and assigned SessionId to the paremete of the methods
            System.out.println("Error:Session ID is null or empty");//Output message if the if statement is true
        }
        if (SessionHelper.isZero(passengerCount)){//call the methods , check if value is equal to zero
            System.out.println( "Error:Passenger Count is Zero");//Output message if the if is true
        }

        if (SessionHelper.isNullOrEmpty(sessionStatus)) {//calls the String null or empty methods and assigned sessionStatus to the paremete of the methods
            System.out.println("Error:Session Status is null or empty");//Output message if the if is true
        }else {
            if (SessionHelper.notValidStatus(sessionStatus)) {//Check if the status is a valid status
                System.out.println("Error:Session Status is not valid");//Output message if the if is true
            }
        }

        return new Session.Builder()
                .setSessionid(sessionID)//Chains muliple setter methods togther
                .setPassenger(passenger)
                .setDriver(driver)
                .setLocation(location)
                .setPassengerCount(passengerCount)
                .setSessionStatus(sessionStatus)
                .setPayment(payment)
                .build();

    }
}
