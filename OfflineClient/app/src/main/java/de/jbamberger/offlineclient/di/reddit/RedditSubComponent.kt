package de.jbamberger.offlineclient.di.reddit

import dagger.Subcomponent
import dagger.android.AndroidInjector
import de.jbamberger.offlineclient.ui.reddit.RedditActivity

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditScope
@Subcomponent(modules = [RedditModule::class])
interface RedditSubComponent : AndroidInjector<RedditActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<RedditActivity>()
}
