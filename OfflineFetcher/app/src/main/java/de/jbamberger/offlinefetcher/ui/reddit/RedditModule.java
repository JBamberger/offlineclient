package de.jbamberger.offlinefetcher.ui.reddit;


import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module//(subcomponents = RedditSubcomponent.class)
public abstract class RedditModule {

    @Binds
    @IntoMap
    @ActivityKey(RedditActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindRedditActivityInjectorFactory(RedditSubcomponent.Builder builder);
}
