package de.jbamberger.offlineclient.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedViewModel
import de.jbamberger.offlineclient.ui.main.MainActivityViewModel
import de.jbamberger.offlineclient.ui.reddit.RedditViewModel
import de.jbamberger.offlineclient.ui.viewutil.AppViewModelFactory

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RedditViewModel::class)
    internal abstract fun bindRedditViewModel(viewModel: RedditViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(JodelFeedViewModel::class)
    internal abstract fun bindJodelFeedViewModel(userViewModel: JodelFeedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(viewModel: MainActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}
