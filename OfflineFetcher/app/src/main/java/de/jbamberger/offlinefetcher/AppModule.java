package de.jbamberger.offlinefetcher;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;
import de.jbamberger.offlinefetcher.ui.jodel.JodelActivity;
import de.jbamberger.offlinefetcher.ui.main.MainActivity;

/**
 * Dependency injection module to provide application wide dependencies.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
public abstract class AppModule {

    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector
    abstract JodelActivity contributeJodelActivity();

    @Provides
    @Singleton
    Context providesApplicationContext(Application application) {
        return application.getApplicationContext();
    }

}
