package de.jbamberger.offlineclient.ui.hackernews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.jbamberger.offlineclient.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class HackerNewsActivityFragment extends Fragment {

    public HackerNewsActivityFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hacker_news, container, false);
    }
}
