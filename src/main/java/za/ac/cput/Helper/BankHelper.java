/*
BankHelper.java
Bank helper class.
Author: RD Christians (230588204)
Date: 16 May 2025
*/

package za.ac.cput.Helper;

import java.util.UUID;

public class BankHelper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
