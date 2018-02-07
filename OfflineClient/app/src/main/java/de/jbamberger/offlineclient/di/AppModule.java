package de.jbamberger.offlineclient.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jbamberger.api.Repository;
import de.jbamberger.api.backend.BackendRepository;
import de.jbamberger.api.jodel.JodelRepository;
import de.jbamberger.api.reddit.RedditRepository;
import de.jbamberger.offlineclient.di.jodel.JodelSubComponent;
import de.jbamberger.offlineclient.di.reddit.RedditSubComponent;

/**
 * Dependency injection module to provide application wide dependencies.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module(subcomponents = {JodelSubComponent.class, RedditSubComponent.class},
        includes = {ViewModelModule.class})
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
    Repository providesRepository(Application app) {
        return new Repository(app);
    }

    @Provides
    @Singleton
    BackendRepository providesBackendRepository(Repository repo) {
        return repo.getBackendRepository();
    }

    @Provides
    @Singleton
    JodelRepository providesJodelRepository(Repository repo) {
        return repo.getJodelRepository();
    }

    @Provides
    @Singleton
    RedditRepository providesRedditRepository(Repository repo) {
        return repo.getRedditRepository();
    }
}
