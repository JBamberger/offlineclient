package de.jbamberger.offlinefetcher.ui.reddit;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Module//(subcomponents = RedditStreamSubcomponent.class)
public abstract class RedditStreamModule {
    @Binds
    @IntoMap
    @FragmentKey(RedditStreamFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindRedditStreamFragmentInjectorFactory(RedditStreamSubcomponent.Builder builder);
}
