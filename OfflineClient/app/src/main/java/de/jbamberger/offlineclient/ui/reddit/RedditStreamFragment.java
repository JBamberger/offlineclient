package de.jbamberger.offlineclient.ui.reddit;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import de.jbamberger.offlineclient.R;
import de.jbamberger.offlineclient.databinding.FragmentRedditStreamBinding;
import de.jbamberger.offlineclient.di.Injectable;
import timber.log.Timber;

public class RedditStreamFragment extends Fragment implements Injectable {
    private static final String UID_KEY = "uid";

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private RedditViewModel viewModel;
    private FragmentRedditStreamBinding binding;

    public static RedditStreamFragment newInstance(String subreddit) {

        Bundle args = new Bundle();
        args.putString(UID_KEY, subreddit);
        RedditStreamFragment fragment = new RedditStreamFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RedditViewModel.class);
        viewModel.init(userId);
        viewModel.getPost().observe(this, redditPost -> Timber.d("onChanged() called with: redditPost = [" + redditPost + "]"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reddit_stream, container, false);
        return binding.getRoot();
    }
}
