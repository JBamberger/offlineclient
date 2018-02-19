package de.jbamberger.offlineclient.ui.viewutil

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView

import com.bumptech.glide.load.engine.DiskCacheStrategy

import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.util.Strings

/**
 * Utility class that provides advanced data binding capabilities
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

object BindingUtils {
    /**
     * Load a picture from an url into an image view.
     */
    @JvmStatic
    @BindingAdapter("srcUrl")
    fun loadImageUrl(iv: ImageView, url: String) {
        if (Strings.isEmpty(url)) {
            GlideApp.with(iv).clear(iv)
        } else {
            GlideApp.with(iv)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_dashboard_black_24dp)
                    .fitCenter()
                    .into(iv)
        }
    }

    @JvmStatic
    @BindingAdapter("visIfNN")
    fun visibleIfNotNull(v: View, condition: Any?) {
        if (condition == null) {
            v.visibility = View.GONE
        } else {
            v.visibility = View.VISIBLE
        }
    }
}
