package za.ac.cput.Helper;
/*
    SessionHelper.java
    Session Helper Class
    Author:Rohan Janzen Burger 230171990
    Date:17/05/2025
*/
public class SessionHelper {
    public static boolean isNullOrEmpty(String s){
        if(s.isEmpty() || s==null){//String validation Empty or Null
            return true;//When Empty or null
        }
        return false;//When not empty or equal to null
    }
    public static boolean isZero(int s){
        if(s <= 0){//Checks if int value is less or equal to 0
            return true;//When less or equal to 0
        }
        return false;//When greater or equal to 0
    }


    public static boolean notValidStatus(String s) {
        if (s.equals("Expired") || s.equals("Pending") || s.equals("Active")) {//Checks if the string equals any of these values
            return false;//When not equals to any
        }
        return true;//When equals to any
    }
}
