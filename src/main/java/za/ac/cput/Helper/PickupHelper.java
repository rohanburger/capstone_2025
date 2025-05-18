package za.ac.cput.Helper;

/*  PickupHelper.java
    Pickup Helper class
    Author: Kelsey-Jane Fabe (220328293)
    Date: 17/05/2025
*/

public class PickupHelper {
    //method check if given string is null or empty
    public static boolean  isNullOrEmpty(String str){
        if(str == null || str.isEmpty())
            return true; //return true if null or empty
        return false; //returns false if not null nor empty
    }
}
