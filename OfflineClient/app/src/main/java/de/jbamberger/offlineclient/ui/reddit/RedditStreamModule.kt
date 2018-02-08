package de.jbamberger.offlineclient.ui.reddit

import android.support.v4.app.Fragment

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

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
