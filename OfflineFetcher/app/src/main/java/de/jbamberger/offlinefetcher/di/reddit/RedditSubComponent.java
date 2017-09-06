package de.jbamberger.offlinefetcher.di.reddit;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import de.jbamberger.offlinefetcher.ui.reddit.RedditActivity;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditScope
@Subcomponent(modules = {RedditModule.class})
public interface RedditSubComponent extends AndroidInjector<RedditActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RedditActivity> {}
}
