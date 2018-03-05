package de.jbamberger.offlineclient.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import de.jbamberger.offlineclient.messaging.InstanceIdService
import de.jbamberger.offlineclient.ui.main.MainActivity
import de.jbamberger.offlineclient.ui.main.MainActivityModule
import de.jbamberger.offlineclient.ui.main.MainActivityScope

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */


@Module
internal abstract class BuildersModule {

    @MainActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeInstanceIdService(): InstanceIdService
}
