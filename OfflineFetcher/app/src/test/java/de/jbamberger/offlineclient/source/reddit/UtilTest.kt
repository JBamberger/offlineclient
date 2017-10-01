package de.jbamberger.offlineclient.source.reddit

import de.jbamberger.offlineclient.util.Strings
import org.junit.Test

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
class UtilTest {

    @Test
    fun test1(): Unit {
        Util().hello("Karl")
        Util().hello("")
        Util().hello(Strings.getNull())

    }
}