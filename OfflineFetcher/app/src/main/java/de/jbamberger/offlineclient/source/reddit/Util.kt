package de.jbamberger.offlineclient.source.reddit

import de.jbamberger.offlineclient.util.Strings

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