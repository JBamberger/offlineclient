package de.jbamberger.offlineclient.ui.reddit


import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.jbamberger.offlineclient.ui.reddit.stream.RedditStreamFragment
import de.jbamberger.offlineclient.ui.reddit.stream.RedditStreamScope

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
abstract class RedditModule {

    @RedditStreamScope
    @ContributesAndroidInjector
    internal abstract fun contributeRedditStreamFragment(): RedditStreamFragment
}
