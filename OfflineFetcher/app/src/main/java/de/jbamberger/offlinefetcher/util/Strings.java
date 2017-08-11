package de.jbamberger.offlinefetcher.util;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class Strings {

    /**
     * Checks if a string is empty or null.
     *
     * @param s input
     * @return true, if the string is null or empty
     */
    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    private Strings() {}
}
