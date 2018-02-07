package de.jbamberger.offlineclient.ui.hackernews

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import de.jbamberger.offlineclient.R

/**
 * A placeholder fragment containing a simple view.
 */
class HackerNewsActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_hacker_news, container, false)
    }
}
