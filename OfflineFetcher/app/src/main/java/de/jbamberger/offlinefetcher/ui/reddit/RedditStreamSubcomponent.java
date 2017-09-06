package de.jbamberger.offlinefetcher.ui.reddit;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Subcomponent(modules = RedditStreamModule.class)
public interface RedditStreamSubcomponent extends AndroidInjector<RedditStreamFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RedditStreamFragment> {}
}
