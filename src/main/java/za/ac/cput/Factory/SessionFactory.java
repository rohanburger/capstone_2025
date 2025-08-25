package za.ac.cput.Factory;

import za.ac.cput.Helper.Helper;
import za.ac.cput.domain.*;

/*
    SessionFactory.java
    Session factory Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
public class SessionFactory {
    public static Session createSessionFactory(User user, Driver driver, Location location, int passengerCount, String sessionStatus, Payment payment){
        if (Helper.isZero(passengerCount)){//call the methods , check if value is equal to zero
            throw new IllegalArgumentException("Error:Passenger Count is Zero");//Output message if the if is true
        }

        if (Helper.isNullOrEmpty(sessionStatus)) {//calls the String null or empty methods and assigned sessionStatus to the paremete of the methods
            throw new IllegalArgumentException("Error:Session Status is null or empty");//Output message if the if is true
        }else {
            if (Helper.notValidStatus(sessionStatus)) {//Check if the status is a valid status
                throw new IllegalArgumentException("Error:Session Status is not valid");//Output message if the if is true
            }
        }

        return new Session.Builder()
                .setUser(user)
                .setDriver(driver)
                .setLocation(location)
                .setPassengerCount(passengerCount)
                .setSessionStatus(sessionStatus)
                .setPayment(payment)
                .build();

    }
}
