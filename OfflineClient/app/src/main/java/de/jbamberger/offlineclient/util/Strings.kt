package de.jbamberger.offlineclient.util

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

object Strings {
    /**
     * Checks if a string is empty or null.
     *
     * @param s input
     * @return true, if the string is null or empty
     */
    fun isEmpty(s: String?): Boolean {
        return s == null || s.isEmpty()
    }
}
