package de.jbamberger.offlinefetcher.ui.reddit;


import android.app.Fragment;
import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.jbamberger.offlinefetcher.R;
import de.jbamberger.offlinefetcher.databinding.FragmentRedditStreamBinding;
import de.jbamberger.offlinefetcher.source.reddit.RedditPost;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedditStreamFragment  extends LifecycleFragment {
    private static final String UID_KEY = "uid";
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
        viewModel = ViewModelProviders.of(this).get(RedditViewModel.class);
        viewModel.init(userId);
        viewModel.getPost().observe(this, new Observer<RedditPost>() {
            @Override
            public void onChanged(@Nullable RedditPost redditPost) {
                Log.d(TAG, "onChanged() called with: redditPost = [" + redditPost + "]");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reddit_stream, container, false);
        return binding.getRoot();
    }
}
