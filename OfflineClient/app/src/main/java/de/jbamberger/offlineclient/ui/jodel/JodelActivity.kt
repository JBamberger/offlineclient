package de.jbamberger.offlineclient.ui.jodel

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import de.jbamberger.api.provider.jodel.JodelRepository
import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.databinding.ActivityJodelBinding
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedFragment
import javax.inject.Inject

class JodelActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var repo: JodelRepository

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        return@OnNavigationItemSelectedListener when (it.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, JodelFeedFragment())
                        .commit()
                true
            }
            R.id.navigation_dashboard -> true
            R.id.navigation_notifications -> true
            else -> false
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityJodelBinding = DataBindingUtil.setContentView(this, R.layout.activity_jodel)
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun run(v: View) {
        repo.credentials()
    }
}
