package de.jbamberger.offlinefetcher.ui.jodel.feed;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.jbamberger.offlinefetcher.R;
import de.jbamberger.offlinefetcher.databinding.FragmentJodelFeedBinding;
import de.jbamberger.offlinefetcher.di.Injectable;
import de.jbamberger.offlinefetcher.source.jodel.GetPostsComboResponse;
import de.jbamberger.offlinefetcher.source.jodel.JodelApi;
import de.jbamberger.offlinefetcher.source.jodel.Post;
import de.jbamberger.offlinefetcher.ui.components.DataBindingBaseAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class JodelFeedFragment extends Fragment implements Injectable {

    @Inject
    JodelApi api;

    @Inject
    Context context;

    private FragmentJodelFeedBinding binding;
    private Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentJodelFeedBinding.inflate(inflater, container, false);

        adapter = new Adapter();

        binding.list.setLayoutManager(new LinearLayoutManager(context));
        binding.list.setAdapter(adapter);
        binding.list.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        binding.swipeRefreshLayout.setOnRefreshListener(this::runApi);

        runApi();

        return binding.getRoot();
    }

    public void runApi() {
        binding.swipeRefreshLayout.setRefreshing(true);
        api.getPostsCombo(47.75027847290039D, 8.978754997253418D, true, true, false).enqueue(new Callback<GetPostsComboResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetPostsComboResponse> call, @NonNull Response<GetPostsComboResponse> response) {
                GetPostsComboResponse r = response.body();
                if (r != null) {
                    List<Post> posts = r.getRecent();
                    if (posts != null) {
                        adapter.setItems(posts);
                    }
                }
                binding.swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(@NonNull Call<GetPostsComboResponse> call, @NonNull Throwable t) {
                Snackbar.make(binding.getRoot(), "loading error.", Snackbar.LENGTH_LONG).show();
                binding.swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private class Adapter extends DataBindingBaseAdapter {

        private List<Post> items = new ArrayList<>();

        public void setItems(List<Post> items) {
            this.items = items;
            notifyDataSetChanged();
        }

        @Override
        protected Object getListenerForPosition(int position) {
            return null;
        }

        @Override
        protected Object getObjForPosition(int position) {
            return items.get(position);
        }

        @Override
        protected int getLayoutIdForPosition(int position) {
            return R.layout.post;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
