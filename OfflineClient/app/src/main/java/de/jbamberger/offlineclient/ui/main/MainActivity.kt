package de.jbamberger.offlineclient.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import de.jbamberger.api.Status
import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : BaseActivity<MainActivityViewModel>() {

    override val viewModelClass = MainActivityViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = StreamAdapter()

        Timber.d("InstanceId: %s", FirebaseInstanceId.getInstance().token)

        swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(this, "Refresh not impl", Toast.LENGTH_LONG).show()
            swipeRefreshLayout.isRefreshing = false
        }

        streamContainer.layoutManager = LinearLayoutManager(this)
        streamContainer.adapter = adapter
        streamContainer.addItemDecoration(
                DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        viewModel.posts.observe(this, Observer {
            if (it != null) {
                when (it.status) {
                    Status.SUCCESS -> {
                        it.data?.let { it1 -> adapter.setItems(it1) }
                        swipeRefreshLayout.isRefreshing = false
                    }
                    Status.ERROR -> {
                        Toast.makeText(this, "Loading error!", Toast.LENGTH_LONG).show()
                        swipeRefreshLayout.isRefreshing = false
                    }
                    Status.LOADING -> {
                        Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show()
                        swipeRefreshLayout.isRefreshing = true
                    }
                }
            }
        })
    }
}
