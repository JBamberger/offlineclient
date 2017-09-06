package de.jbamberger.offlinefetcher.di.reddit.stream;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import de.jbamberger.offlinefetcher.ui.reddit.RedditStreamFragment;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditStreamScope
@Subcomponent(modules = RedditStreamModule.class)
public interface RedditStreamSubcomponent extends AndroidInjector<RedditStreamFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RedditStreamFragment> {}
}
