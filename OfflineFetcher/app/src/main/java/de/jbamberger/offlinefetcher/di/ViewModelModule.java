package de.jbamberger.offlinefetcher.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlinefetcher.ui.jodel.feed.JodelFeedViewModel;
import de.jbamberger.offlinefetcher.ui.viewutil.AppViewModelFactory;

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(JodelFeedViewModel.class)
    abstract ViewModel bindJodelFeedViewModel(JodelFeedViewModel userViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
