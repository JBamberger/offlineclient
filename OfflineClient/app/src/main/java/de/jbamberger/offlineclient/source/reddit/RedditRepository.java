package de.jbamberger.offlineclient.source.reddit;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.jbamberger.offlineclient.db.dao.RedditPostDao;
import de.jbamberger.offlineclient.db.entity.RedditPost;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Singleton
public class RedditRepository {
    private final RedditApi api;
    private final Executor executor;
    private final RedditPostDao redditPostDao;

    @Inject
    public RedditRepository(RedditApi api, Executor executor, RedditPostDao redditPostDao) {
        this.api = api;
        this.executor = executor;
        this.redditPostDao = redditPostDao;
    }

    public LiveData<RedditPost> getRedditPost(String subreddit) {
        refreshRedditPosts(subreddit);
        return redditPostDao.load(subreddit);
    }

    private void refreshRedditPosts(final String subreddit) {
        executor.execute(() -> {
            boolean postExists = false;//redditPostDao.hasRedditPost(TIMEOUT);
            if (!postExists) {
                api.getPosts(subreddit).enqueue(new Callback<RedditPost>() {
                    @Override
                    public void onResponse(@NonNull Call<RedditPost> call, @NonNull Response<RedditPost> response) {
                        // error case is left out for brevity
                        executor.execute(() -> redditPostDao.save(response.body()));
                    }

                    @Override
                    public void onFailure(@NonNull Call<RedditPost> call, @NonNull Throwable t) {

                    }
                });
            }
        });
    }
}