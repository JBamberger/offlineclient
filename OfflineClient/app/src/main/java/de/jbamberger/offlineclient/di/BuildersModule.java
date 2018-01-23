package de.jbamberger.offlineclient.di;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlineclient.di.jodel.JodelActivityScope;
import de.jbamberger.offlineclient.di.jodel.JodelModule;
import de.jbamberger.offlineclient.di.jodel.JodelSubComponent;
import de.jbamberger.offlineclient.di.reddit.RedditScope;
import de.jbamberger.offlineclient.di.reddit.stream.RedditStreamModule;
import de.jbamberger.offlineclient.di.reddit.stream.RedditStreamScope;
import de.jbamberger.offlineclient.ui.jodel.JodelActivity;
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedFragment;
import de.jbamberger.offlineclient.ui.main.MainActivity;
import de.jbamberger.offlineclient.ui.reddit.RedditActivity;
import de.jbamberger.offlineclient.ui.reddit.RedditStreamFragment;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */


@Module
public abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(JodelActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindJodelActivityInjectorFactory(JodelSubComponent.Builder builder);

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    @RedditScope
    @ContributesAndroidInjector
    abstract RedditActivity contributeRedditActivity();

    @RedditStreamScope
    @ContributesAndroidInjector(modules = {RedditStreamModule.class})
    abstract RedditStreamFragment contributesRedditStreamFragment();

    @JodelActivityScope
    @ContributesAndroidInjector(modules = {JodelModule.class/*, NetModule.class*/})
    abstract JodelFeedFragment contributeJodelFeedFragment();
//
//    @ContributesAndroidInjector
//    abstract InstanceIdService contibutesInstanceIdService();
}
