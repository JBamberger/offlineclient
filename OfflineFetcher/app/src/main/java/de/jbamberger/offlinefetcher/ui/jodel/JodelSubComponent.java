package de.jbamberger.offlinefetcher.ui.jodel;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@JodelActivityScope
@Subcomponent(modules = {JodelModule.class/*, NetModule.class*/})
public interface JodelSubComponent extends AndroidInjector<JodelActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<JodelActivity> {
    }
}
