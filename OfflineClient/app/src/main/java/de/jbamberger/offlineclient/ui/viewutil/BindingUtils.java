package de.jbamberger.offlineclient.ui.viewutil;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

import de.jbamberger.offlineclient.R;
import de.jbamberger.offlineclient.util.Strings;

/**
 * Utility class that provides advanced data binding capabilities
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class BindingUtils {

    /**
     * prevent instantiation
     */
    private BindingUtils() {
    }


    /**
     * Load a picture from an url into an image view.
     */
    @BindingAdapter("srcUrl")
    public static void loadImageUrl(ImageView iv, String url) {
        if (Strings.isEmpty(url)) {
            GlideApp.with(iv).clear(iv);
        } else {
            GlideApp.with(iv)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_dashboard_black_24dp)
                    .fitCenter()
                    .into(iv);
        }
    }

    /**
     * Load an image from an Image instance. Therefore either a resource drawable or a file path.
     */
    @BindingAdapter("srcImg")
    public static void loadImagePath(ImageView iv, Image image) {
        if (Strings.isEmpty(image.src)) {
            GlideApp.with(iv).clear(iv);
            iv.setImageResource(image.drawable);
        } else {
            GlideApp.with(iv)
                    .load(image.src)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.ic_dashboard_black_24dp)
                    .fitCenter()
                    .into(iv);
        }
    }

    @BindingAdapter("visIfNN")
    public static void visibleIfNotNull(View v, Object condition) {
        if (condition == null) {
            v.setVisibility(View.GONE);
        } else {
            v.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Utility class the contains either a path or a resource drawable.
     */
    public static class Image {
        String src;
        int drawable = -1;

        public Image(String src) {
            this.src = src;
        }

        public Image(int drawable) {
            this.drawable = drawable;
        }
    }
}
