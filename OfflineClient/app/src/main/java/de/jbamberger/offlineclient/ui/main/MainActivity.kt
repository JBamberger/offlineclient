package de.jbamberger.offlineclient.ui.main

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.firebase.iid.FirebaseInstanceId
import dagger.android.AndroidInjection
import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.databinding.ActivityMainBinding
import de.jbamberger.offlineclient.ui.components.DataBindingAdapter
import de.jbamberger.offlineclient.ui.components.ListItem
import de.jbamberger.offlineclient.ui.components.TwoLineItem
import de.jbamberger.offlineclient.ui.hackernews.HackerNewsActivity
import de.jbamberger.offlineclient.ui.jodel.JodelActivity
import de.jbamberger.offlineclient.ui.reddit.RedditActivity
import de.jbamberger.offlineclient.ui.twitter.TwitterActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)
        val adapter = DataBindingAdapter()

        Timber.d("InstanceId: %s", FirebaseInstanceId.getInstance().token)

        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        binding.list.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val items = listOf<ListItem>(
                TwoLineItem("Jodel", "anonymous location based chat",
                        View.OnClickListener { start( JodelActivity::class.java) }),
                TwoLineItem("Reddit", "front page of the internet",
                        View.OnClickListener { start( RedditActivity::class.java) }),
                TwoLineItem("HackerNews", "y-combinator hacker news",
                        View.OnClickListener { start( HackerNewsActivity::class.java) }),
                TwoLineItem("Twitter", "birds..?!",
                        View.OnClickListener { start( TwitterActivity::class.java) }))

        adapter.setItems(items)
    }

    private fun start(clazz: Class<out Activity>) {
        startActivity(Intent(this, clazz))
    }
}
