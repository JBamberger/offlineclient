package de.jbamberger.offlinefetcher;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jbamberger.offlinefetcher.ui.jodel.JodelSubComponent;

/**
 * Dependency injection module to provide application wide dependencies.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module(subcomponents = JodelSubComponent.class)
public abstract class AppModule {

    /*@ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();*/

    /*@ContributesAndroidInjector
    abstract JodelActivity contributeJodelActivity();*/


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
}
