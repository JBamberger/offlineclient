package de.jbamberger.offlinefetcher.di.reddit;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlinefetcher.ui.reddit.RedditActivity;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
public abstract class RedditModule {

    @Binds
    @IntoMap
    @ActivityKey(RedditActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindRedditActivityInjectorFactory(RedditSubComponent.Builder builder);
}
