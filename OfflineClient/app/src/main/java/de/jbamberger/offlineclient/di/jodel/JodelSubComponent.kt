package de.jbamberger.offlineclient.di.jodel

import dagger.Subcomponent
import dagger.android.AndroidInjector
import de.jbamberger.offlineclient.ui.jodel.JodelActivity

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@JodelActivityScope
@Subcomponent(modules = arrayOf(JodelModule::class/*, NetModule.class*/))
interface JodelSubComponent : AndroidInjector<JodelActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<JodelActivity>()
}
