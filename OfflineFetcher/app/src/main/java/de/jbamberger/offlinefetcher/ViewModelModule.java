package de.jbamberger.offlinefetcher;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlinefetcher.ui.jodel.feed.JodelFeedViewModel;
import de.jbamberger.offlinefetcher.ui.reddit.RedditViewModel;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RedditViewModel.class)
    abstract ViewModel bindRedditViewModel(RedditViewModel viewModel);

    @Binds
    @IntoMap
    @ViewModelKey(JodelFeedViewModel.class)
    abstract ViewModel bindJodelFeedViewModel(JodelFeedViewModel viewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
