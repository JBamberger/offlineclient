package de.jbamberger.offlineclient.di.reddit.stream

import android.support.v4.app.Fragment

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap
import de.jbamberger.offlineclient.ui.reddit.RedditStreamFragment

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Module
abstract class RedditStreamModule {
    @Binds
    @IntoMap
    @FragmentKey(RedditStreamFragment::class)
    internal abstract fun bindRedditStreamFragmentInjectorFactory(builder: RedditStreamSubcomponent.Builder): AndroidInjector.Factory<out Fragment>
}
