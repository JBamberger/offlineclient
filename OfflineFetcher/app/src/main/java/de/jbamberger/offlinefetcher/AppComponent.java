package de.jbamberger.offlinefetcher;


import javax.inject.Singleton;

import dagger.Component;
import de.jbamberger.offlinefetcher.ui.jodel.JodelActivity;
import de.jbamberger.offlinefetcher.ui.main.MainActivity;

@Singleton
@Component(
        modules = {
                AppModule.class,
                DatabaseModule.class,
                NetModule.class
        }
)
public interface AppComponent {

    void inject(App app);
    void inject(MainActivity mainActivity);
    void inject(JodelActivity jodelActivity);

}