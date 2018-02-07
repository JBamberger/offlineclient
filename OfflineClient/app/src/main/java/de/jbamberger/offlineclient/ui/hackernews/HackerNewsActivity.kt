package de.jbamberger.offlineclient.ui.hackernews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.jbamberger.offlineclient.R
import kotlinx.android.synthetic.main.activity_hacker_news.*

class HackerNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacker_news)
        setSupportActionBar(toolbar)
    }

}
