package de.jbamberger.offlineclient.ui.main

import android.app.Activity
import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.google.firebase.iid.FirebaseInstanceId
import de.jbamberger.api.Status
import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.databinding.ActivityMainBinding
import de.jbamberger.offlineclient.ui.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModelClass = MainActivityViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = StreamAdapter()

        Timber.d("InstanceId: %s", FirebaseInstanceId.getInstance().token)

        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        binding.list.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        viewModel.posts.observe(this, Observer {
            if (it != null) {
                when(it.status) {
                    Status.SUCCESS -> {
                        adapter.setItems(it.data!!)
                    }
                    Status.ERROR -> TODO()
                    Status.LOADING -> TODO()
                }
            }
        })

/*      val items = listOf<ListItem>(
                TwoLineItem("Jodel", "anonymous location based chat",
                        View.OnClickListener { start( JodelActivity::class.java) }),
                TwoLineItem("Reddit", "front page of the internet",
                        View.OnClickListener { start( RedditActivity::class.java) }),
                TwoLineItem("HackerNews", "y-combinator hacker news",
                        View.OnClickListener { start( HackerNewsActivity::class.java) }),
                TwoLineItem("Twitter", "birds..?!",
                        View.OnClickListener { start( TwitterActivity::class.java) }))
        adapter.setItems(items)*/
    }

    private fun start(clazz: Class<out Activity>) {
        startActivity(Intent(this, clazz))
    }
}
