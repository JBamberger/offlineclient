package de.jbamberger.offlinefetcher;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dependency injection module to provide application wide dependencies.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context providesApplicationContext(Application application) {
        return application.getApplicationContext();
    }

}
