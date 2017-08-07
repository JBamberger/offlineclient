package de.jbamberger.offlinefetcher;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlinefetcher.ui.jodel.JodelActivity;
import de.jbamberger.offlinefetcher.ui.jodel.JodelSubComponent;
import de.jbamberger.offlinefetcher.ui.main.MainActivity;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */


@Module
public abstract class BuildersModule {
    @Binds
    @IntoMap
    @ActivityKey(JodelActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindJodelActivityInjectorFactory(JodelSubComponent.Builder builder);

    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();

    /*@ContributesAndroidInjector
    abstract JodelActivity contributeJodelActivity();*/
}
