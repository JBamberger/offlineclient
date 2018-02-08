package de.jbamberger.offlineclient.ui.jodel.feed

import dagger.Subcomponent
import dagger.android.AndroidInjector
import de.jbamberger.offlineclient.ui.jodel.JodelActivity

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@JodelActivityScope
@Subcomponent(modules = [JodelModule::class])
interface JodelSubComponent : AndroidInjector<JodelActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<JodelActivity>()
}
