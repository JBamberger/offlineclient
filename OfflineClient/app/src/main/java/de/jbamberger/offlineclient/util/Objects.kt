package de.jbamberger.offlineclient.util

object Objects {

    fun equals(o1: Any?, o2: Any?): Boolean {
        return if (o1 == null) {
            o2 == null
        } else o2 != null && o1 == o2
    }
}
