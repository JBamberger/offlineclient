package de.jbamberger.offlinefetcher.source.reddit

import de.jbamberger.offlinefetcher.util.Strings

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class Util {
    fun hello(string : String?): Unit {
        if (Strings.isEmpty(string))
            println("Go away!")
        else
            println("Hello, $string.")
    }
}