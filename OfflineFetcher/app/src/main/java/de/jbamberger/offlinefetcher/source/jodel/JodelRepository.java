package de.jbamberger.offlinefetcher.source.jodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.jbamberger.offlinefetcher.AppExecutors;
import de.jbamberger.offlinefetcher.source.ApiResponse;
import de.jbamberger.offlinefetcher.source.NetworkBoundResource;
import de.jbamberger.offlinefetcher.source.jodel.model.GetPostsComboResponse;
import de.jbamberger.offlinefetcher.source.jodel.model.Post;
import de.jbamberger.offlinefetcher.util.AbsentLiveData;
import de.jbamberger.offlinefetcher.util.Resource;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Singleton
public class JodelRepository {

    private final JodelApi api;
    private final AppExecutors appExecutors;

    @Inject
    public JodelRepository(AppExecutors appExecutors, JodelApi api) {
        this.appExecutors = appExecutors;
        this.api = api;
    }


    private final MutableLiveData<Resource<List<Post>>> posts = new MutableLiveData<>();

    public LiveData<Resource<List<Post>>> getPosts() {
        return new NetworkBoundResource<List<Post>, GetPostsComboResponse>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull GetPostsComboResponse item) {
            }

            @Override
            protected boolean shouldFetch(@Nullable List<Post> data) {
                return data == null;
            }

            @NonNull
            @Override
            protected LiveData<List<Post>> loadFromDb() {
                return AbsentLiveData.create();
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<GetPostsComboResponse>> createCall() {
                return api.getPostsCombo(47.75027847290039D, 8.978754997253418D, true, true, false);
            }
        }.asLiveData();
    }
}
