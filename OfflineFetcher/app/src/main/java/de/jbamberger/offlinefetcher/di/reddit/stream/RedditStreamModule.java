package de.jbamberger.offlinefetcher.di.reddit.stream;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;
import de.jbamberger.offlinefetcher.db.OfflineDatabase;
import de.jbamberger.offlinefetcher.db.dao.RedditPostDao;
import de.jbamberger.offlinefetcher.ui.reddit.RedditStreamFragment;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Module
public abstract class RedditStreamModule {
    @Binds
    @IntoMap
    @FragmentKey(RedditStreamFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindRedditStreamFragmentInjectorFactory(RedditStreamSubcomponent.Builder builder);

    RedditPostDao providesRedditPostDao(OfflineDatabase db) {
        return db.redditPostDao();
    }
}
