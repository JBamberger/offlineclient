package de.jbamberger.offlineclient

import android.app.Activity
import android.app.Application
import android.app.Service
import android.util.Log
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import de.jbamberger.offlineclient.di.AppInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class App : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    @JvmField
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    @Inject
    @JvmField
    internal var serviceInjector: DispatchingAndroidInjector<Service>? = null

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
        AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): AndroidInjector<Service>? {
        return serviceInjector
    }

    /**
     * A tree which logs important information for crash reporting.
     */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String, message: String, t: Throwable) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
            //FIXME: use reporting library
            Log.e(tag, message, t)
        }
    }
}
