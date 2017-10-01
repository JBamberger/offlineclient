package de.jbamberger.offlineclient.ui.jodel.feed;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import de.jbamberger.offlineclient.source.jodel.JodelRepository;
import de.jbamberger.offlineclient.source.jodel.model.Post;
import de.jbamberger.offlineclient.util.Resource;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public class JodelFeedViewModel extends ViewModel {

    private final LiveData<Resource<List<Post>>> posts;
    private JodelRepository repository;

    @Inject
    public JodelFeedViewModel(JodelRepository repository) {
        this.repository = repository;
        posts = repository.getPosts();
    }

    public LiveData<Resource<List<Post>>> getPosts() {
        return posts;
    }

    public void refresh() {
        repository.getPosts();
    }
}
