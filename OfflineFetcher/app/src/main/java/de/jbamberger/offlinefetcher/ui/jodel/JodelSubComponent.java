package de.jbamberger.offlinefetcher.ui.jodel;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import de.jbamberger.offlinefetcher.NetModule;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Subcomponent(modules = {JodelModule.class, NetModule.class})
public interface JodelSubComponent extends AndroidInjector<JodelActivity> {

    @Subcomponent.Builder
    abstract class Builder extends  AndroidInjector.Builder<JodelActivity> {

    }
}
