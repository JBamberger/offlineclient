package de.jbamberger.offlineclient.ui.reddit


import android.app.Activity

import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
abstract class RedditModule {

    @Binds
    @IntoMap
    @ActivityKey(RedditActivity::class)
    internal abstract fun bindRedditActivityInjectorFactory(builder: RedditSubComponent.Builder): AndroidInjector.Factory<out Activity>
}
