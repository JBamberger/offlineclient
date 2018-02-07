package de.jbamberger.offlineclient.ui.components

import android.support.annotation.LayoutRes

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

interface ListItem {
    val listener: Any?

    val obj: Any?

    @get:LayoutRes
    val layoutRes: Int
}