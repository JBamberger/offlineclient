package de.jbamberger.offlineclient.ui.components;

import android.support.annotation.LayoutRes;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public interface ListItem {
    Object getListener();

    Object getObject();

    @LayoutRes
    int getLayoutRes();
}