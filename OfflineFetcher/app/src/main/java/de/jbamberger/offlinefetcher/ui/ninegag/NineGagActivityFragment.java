package de.jbamberger.offlinefetcher.ui.ninegag;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.jbamberger.offlinefetcher.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class NineGagActivityFragment extends Fragment {

    public NineGagActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nine_gag, container, false);
    }
}
