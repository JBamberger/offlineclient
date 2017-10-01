package de.jbamberger.offlineclient.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jbamberger.offlineclient.di.jodel.JodelSubComponent;
import de.jbamberger.offlineclient.di.reddit.RedditSubComponent;

/**
 * Dependency injection module to provide application wide dependencies.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module(subcomponents = {JodelSubComponent.class, RedditSubComponent.class},
        includes = {ViewModelModule.class, NetModule.class})
class AppModule {

    @Provides
    @Singleton
    Context providesApplicationContext(Application application) {
        return application.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    Executor providesWorkExecutor(Context context) {
        //TODO: fix
        return new ScheduledThreadPoolExecutor(4);
    }
}
