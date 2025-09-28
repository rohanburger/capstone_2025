package za.ac.cput.Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    //method checks if given string is null or empty
    public static boolean isNullOrEmpty(String str){
        if(str == null || str.isEmpty()){
            return true;
        }
        return false;
    }

    //check if email is valid
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern p = Pattern.compile(emailRegex);
        Matcher m = p.matcher(email);

        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isZero(int i){
        if(i <= 0){//Checks if int value is less or equal to 0
            return true;//When less or equal to 0
        }
        return false;//When greater or equal to 0
    }


    public static boolean notValidStatus(String s) {
        if (s.equals("Completed") ||s.equals("Pending Response")|| s.equals("Pending") || s.equals("Active")|| s.equals("Cancelled")) {//Checks if the string equals any of these values
            return false;//When not equals to any
        }
        return true;//When equals to any
    }

    public static Boolean isEqual(String a, String b){
        if(a.equals(b)){
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
