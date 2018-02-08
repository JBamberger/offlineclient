package de.jbamberger.offlineclient.ui.reddit

import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditStreamScope
@Subcomponent(modules = [RedditStreamModule::class])
interface RedditStreamSubcomponent : AndroidInjector<RedditStreamFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<RedditStreamFragment>()
}
