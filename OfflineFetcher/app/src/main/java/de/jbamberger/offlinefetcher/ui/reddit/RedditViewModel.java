package de.jbamberger.offlinefetcher.ui.reddit;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import de.jbamberger.offlinefetcher.db.entity.RedditPost;
import de.jbamberger.offlinefetcher.source.reddit.RedditRepository;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class RedditViewModel extends ViewModel {
    private LiveData<RedditPost> post;
    private RedditRepository repo;

    @Inject
    public RedditViewModel(RedditRepository repo) {
        this.repo = repo;
    }


    public void init(String subreddit) {
        if (this.post != null) {
            return;
        }
        post = repo.getRedditPost(subreddit);
    }
    public LiveData<RedditPost> getPost() {
        return post;
    }
}
