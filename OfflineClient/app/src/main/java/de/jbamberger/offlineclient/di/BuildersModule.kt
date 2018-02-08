package de.jbamberger.offlineclient.di

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import de.jbamberger.offlineclient.messaging.InstanceIdService
import de.jbamberger.offlineclient.ui.jodel.JodelActivity
import de.jbamberger.offlineclient.ui.jodel.feed.JodelActivityScope
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedFragment
import de.jbamberger.offlineclient.ui.jodel.feed.JodelModule
import de.jbamberger.offlineclient.ui.jodel.feed.JodelSubComponent
import de.jbamberger.offlineclient.ui.main.MainActivity
import de.jbamberger.offlineclient.ui.reddit.*

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */


@Module
internal abstract class BuildersModule {

    @Binds
    @IntoMap
    @ActivityKey(JodelActivity::class)
    internal abstract fun bindJodelActivityInjectorFactory(builder: JodelSubComponent.Builder): AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @RedditScope
    @ContributesAndroidInjector
    internal abstract fun contributeRedditActivity(): RedditActivity

    @RedditStreamScope
    @ContributesAndroidInjector(modules = [RedditStreamModule::class])
    internal abstract fun contributesRedditStreamFragment(): RedditStreamFragment

    @JodelActivityScope
    @ContributesAndroidInjector(modules = [JodelModule::class])
    internal abstract fun contributeJodelFeedFragment(): JodelFeedFragment

    @ContributesAndroidInjector
    internal abstract fun contributesInstanceIdService(): InstanceIdService
}
