package de.jbamberger.offlineclient.ui.reddit


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.databinding.FragmentRedditStreamBinding
import de.jbamberger.offlineclient.di.AppInjector
import timber.log.Timber
import javax.inject.Inject

class RedditStreamFragment : Fragment(), AppInjector.Injectable {

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: RedditViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userId = arguments!!.getString(UID_KEY)
        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(RedditViewModel::class.java)
        viewModel.init(userId)
        viewModel.post!!.observe(this,
                Observer { Timber.d("onChanged() called with: redditPost = [$it]") })
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentRedditStreamBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_reddit_stream, container, false)
        return binding.root
    }

    companion object {
        private val UID_KEY = "uid"

        fun newInstance(subreddit: String): RedditStreamFragment {
            val args = Bundle()
            args.putString(UID_KEY, subreddit)
            val fragment = RedditStreamFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
