package de.jbamberger.offlineclient.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedViewModel;
import de.jbamberger.offlineclient.ui.reddit.RedditViewModel;
import de.jbamberger.offlineclient.ui.viewutil.AppViewModelFactory;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RedditViewModel.class)
    abstract ViewModel bindRedditViewModel(RedditViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(JodelFeedViewModel.class)
    abstract ViewModel bindJodelFeedViewModel(JodelFeedViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
