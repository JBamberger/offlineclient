package de.jbamberger.offlineclient.ui.reddit

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditScope
@Subcomponent(modules = [RedditModule::class])
interface RedditSubComponent : AndroidInjector<RedditActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<RedditActivity>()
}
