package de.jbamberger.offlineclient.ui.jodel.feed

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.jbamberger.api.Status
import de.jbamberger.offlineclient.databinding.FragmentJodelFeedBinding
import de.jbamberger.offlineclient.di.Injectable
import de.jbamberger.offlineclient.util.AutoClearedValue
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class JodelFeedFragment : Fragment(), Injectable {

    @Inject
    internal lateinit var context: Context

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    private var feedViewModel: JodelFeedViewModel? = null

    private var binding: AutoClearedValue<FragmentJodelFeedBinding>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val dataBinding = FragmentJodelFeedBinding.inflate(inflater, container, false)
        binding = AutoClearedValue(this, dataBinding)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        feedViewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(JodelFeedViewModel::class.java)
        val binding = this.binding!!.get() ?: throw IllegalStateException("Binding not initialized")
        binding.listener = feedViewModel

        val adapter = JodelPostsAdapter()
        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        binding.list.adapter = adapter

        feedViewModel!!.posts.observe(this, Observer {
            Timber.d("" + it)
            if (it != null) {
                val data = it.data
                if (it.status == Status.SUCCESS && data != null) {
                    adapter.setItems(data)
                    binding.swipeRefreshLayout.isRefreshing = false
                    return@Observer
                }
                if (it.status == Status.LOADING) {
                    adapter.setItems(emptyList())
                    binding.swipeRefreshLayout.isRefreshing = true
                    return@Observer
                }
            }

            adapter.setItems(emptyList())
            Snackbar.make(binding.root, "loading error.", Snackbar.LENGTH_LONG).show()
            binding.swipeRefreshLayout.isRefreshing = false
        })
    }
}
