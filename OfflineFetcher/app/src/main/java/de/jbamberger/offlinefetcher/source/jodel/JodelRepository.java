package de.jbamberger.offlinefetcher.source.jodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.jbamberger.offlinefetcher.source.jodel.model.GetPostsComboResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.Post;
import de.jbamberger.offlinefetcher.ui.viewutil.Resource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Singleton
public class JodelRepository {

    private JodelApi api;

    @Inject
    public JodelRepository(JodelApi api) {
        this.api = api;
    }


    private final MutableLiveData<Resource<List<Post>>> posts = new MutableLiveData<>();

    public LiveData<Resource<List<Post>>> getPosts() {
        posts.setValue(Resource.loading(null));
        api.getPostsCombo(47.75027847290039D, 8.978754997253418D, true, true, false).enqueue(new Callback<GetPostsComboResponse>() {
            @Override
            public void onResponse(@NonNull Call<GetPostsComboResponse> call, @NonNull Response<GetPostsComboResponse> response) {
                GetPostsComboResponse r = response.body();
                if (r != null) {
                    List<Post> postsList = r.getRecent();
                    if (postsList != null) {
                        posts.setValue(Resource.success(postsList));
                        return;
                    }
                }
                posts.setValue(Resource.error("Invalid response.", null));
            }

            @Override
            public void onFailure(@NonNull Call<GetPostsComboResponse> call, @NonNull Throwable t) {
                posts.setValue(Resource.error(t.toString(), null));
            }
        });

        return posts;
    }

    public LiveData<Resource<List<Post>>> getPosts(String after) {
        posts.setValue(Resource.loading(null));
        api.getPostsCombo(
                47.75027847290039D,
                8.978754997253418D,
                true,
                true,
                false)
                .enqueue(new Callback<GetPostsComboResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<GetPostsComboResponse> call, @NonNull Response<GetPostsComboResponse> response) {
                        GetPostsComboResponse r = response.body();
                        if (r != null) {
                            List<Post> postsList = r.getRecent();
                            if (postsList != null) {
                                posts.setValue(Resource.success(postsList));
                                return;
                            }
                        }
                        posts.setValue(Resource.error("Invalid response.", null));
                    }

                    @Override
                    public void onFailure(@NonNull Call<GetPostsComboResponse> call, @NonNull Throwable t) {
                        posts.setValue(Resource.error(t.toString(), null));
                    }
                });

        return posts;
    }
}
