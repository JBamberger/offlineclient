package de.jbamberger.offlinefetcher.ui.hackernews;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.jbamberger.offlinefetcher.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class HackerNewsActivityFragment extends Fragment {

    public HackerNewsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hacker_news, container, false);
    }
}