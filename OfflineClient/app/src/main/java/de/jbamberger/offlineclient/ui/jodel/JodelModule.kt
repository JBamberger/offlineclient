package de.jbamberger.offlineclient.ui.jodel

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedFragment

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
abstract class JodelModule {

    @ContributesAndroidInjector
    internal abstract fun contributeJodelFeedFragment(): JodelFeedFragment
}
