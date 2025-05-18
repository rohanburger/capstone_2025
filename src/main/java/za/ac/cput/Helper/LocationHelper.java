package za.ac.cput.Helper;

/*
    LocationHelper.java
    Location Helper Class
    Author:Sharief Abdul
    Date:08/05/2025
*/

public class LocationHelper {

    public static Boolean isEmptyOrNull(String s){
        if(s.isEmpty()||s.isBlank()||s==null){
            return true;
        }
        return false;
    }

public static Boolean isNullorEmpty(Object o){
        if(o.equals(null)||o==""){
            return true;
        }
        return false;
}



    public static Boolean isEqual(String a, String b){
        if(a.equals(b)){
            return true;
        }
        return false;
    }

}
