package de.jbamberger.offlineclient.util;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class Strings {

    private Strings() {
    }

    /**
     * Checks if a string is empty or null.
     *
     * @param s input
     * @return true, if the string is null or empty
     */
    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public static String getNull() {
        return null;
    }
}
