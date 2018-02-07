package de.jbamberger.offlineclient.ui.twitter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.jbamberger.offlineclient.R
import kotlinx.android.synthetic.main.activity_twitter.*

class TwitterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter)
        setSupportActionBar(toolbar)
    }
}
