package de.jbamberger.offlinefetcher.ui.reddit;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditScope
@Subcomponent(modules = {RedditModule.class})
public interface RedditSubcomponent extends AndroidInjector<RedditActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<RedditActivity> {}
}
