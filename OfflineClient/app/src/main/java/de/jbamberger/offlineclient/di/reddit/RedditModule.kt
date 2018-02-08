package de.jbamberger.offlineclient.di.reddit


import android.app.Activity

import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import de.jbamberger.offlineclient.ui.reddit.RedditActivity

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
