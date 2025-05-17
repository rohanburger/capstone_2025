package za.ac.cput.Helper;
/*
    PaymentHelper.java
    Payment Helper Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
public class PaymentHelper {
    public static boolean isNullOrEmpty(String s){
        if(s.isEmpty()||s.isBlank()||s==null){
            return true;
        }
        return false;
    }
    public static boolean isZero(float s){
        if(s <= 0){//Checks if float value is less or equal to 0
            return true;//When less or equal to 0
        }
        return false;//When greater or equal to 0
    }
}
