package de.jbamberger.offlineclient.di.jodel;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import de.jbamberger.offlineclient.ui.jodel.JodelActivity;

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
