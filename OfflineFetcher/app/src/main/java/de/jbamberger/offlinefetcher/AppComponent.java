package de.jbamberger.offlinefetcher;


import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import de.jbamberger.offlinefetcher.ui.jodel.JodelActivity;
import de.jbamberger.offlinefetcher.ui.main.MainActivity;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        DatabaseModule.class,
        NetModule.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);

    void inject(MainActivity mainActivity);

    void inject(JodelActivity jodelActivity);

}