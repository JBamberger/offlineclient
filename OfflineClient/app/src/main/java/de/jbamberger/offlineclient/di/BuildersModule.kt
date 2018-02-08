package de.jbamberger.offlineclient.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.jbamberger.offlineclient.messaging.InstanceIdService
import de.jbamberger.offlineclient.ui.jodel.JodelActivity
import de.jbamberger.offlineclient.ui.jodel.JodelActivityScope
import de.jbamberger.offlineclient.ui.jodel.JodelModule
import de.jbamberger.offlineclient.ui.main.MainActivity
import de.jbamberger.offlineclient.ui.reddit.RedditActivity
import de.jbamberger.offlineclient.ui.reddit.RedditActivityScope
import de.jbamberger.offlineclient.ui.reddit.RedditModule

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */


@Module
internal abstract class BuildersModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @JodelActivityScope
    @ContributesAndroidInjector(modules = [JodelModule::class])
    internal abstract fun contributeJodelActivity(): JodelActivity

    @RedditActivityScope
    @ContributesAndroidInjector(modules = [RedditModule::class])
    internal abstract fun contributeRedditActivity(): RedditActivity

    @ContributesAndroidInjector
    internal abstract fun contributeInstanceIdService(): InstanceIdService
}
