package de.jbamberger.offlineclient.di.reddit.stream

import dagger.Subcomponent
import dagger.android.AndroidInjector
import de.jbamberger.offlineclient.ui.reddit.RedditStreamFragment

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@RedditStreamScope
@Subcomponent(modules = arrayOf(RedditStreamModule::class))
interface RedditStreamSubcomponent : AndroidInjector<RedditStreamFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<RedditStreamFragment>()
}
