package de.jbamberger.offlineclient.ui.jodel.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;

import javax.inject.Inject;

import de.jbamberger.offlineclient.databinding.FragmentJodelFeedBinding;
import de.jbamberger.offlineclient.di.Injectable;
import de.jbamberger.offlineclient.source.jodel.JodelApi;
import de.jbamberger.offlineclient.util.AutoClearedValue;
import de.jbamberger.offlineclient.util.Status;
import timber.log.Timber;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class JodelFeedFragment extends Fragment implements Injectable {

    @Inject
    JodelApi api;

    @Inject
    Context context;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private JodelFeedViewModel feedViewModel;

    private AutoClearedValue<FragmentJodelFeedBinding> binding;
    private AutoClearedValue<JodelPostsAdapter> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentJodelFeedBinding dataBinding = FragmentJodelFeedBinding.inflate(inflater, container, false);
        binding = new AutoClearedValue<>(this, dataBinding);
        return dataBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        feedViewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(JodelFeedViewModel.class);
        binding.get().setListener(feedViewModel);

        adapter = new AutoClearedValue<>(this, new JodelPostsAdapter());
        binding.get().list.setLayoutManager(new LinearLayoutManager(context));
        binding.get().list.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        binding.get().list.setAdapter(adapter.get());

        feedViewModel.getPosts().observe(this, listResource -> {
            Timber.d("" + listResource);
            if (listResource != null) {
                if (listResource.status == Status.SUCCESS && listResource.data != null) {
                    adapter.get().setItems(listResource.data);
                    binding.get().swipeRefreshLayout.setRefreshing(false);
                    return;
                }
                if (listResource.status == Status.LOADING) {
                    adapter.get().setItems(Collections.emptyList());
                    binding.get().swipeRefreshLayout.setRefreshing(true);
                    return;
                }

            }
            adapter.get().setItems(Collections.emptyList());
            Snackbar.make(binding.get().getRoot(), "loading error.", Snackbar.LENGTH_LONG).show();
            binding.get().swipeRefreshLayout.setRefreshing(false);
        });
    }
}
