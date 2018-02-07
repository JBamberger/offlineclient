package de.jbamberger.offlineclient.ui.jodel

import android.content.Context
import android.content.SharedPreferences
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import de.jbamberger.offlineclient.R
import de.jbamberger.offlineclient.databinding.ActivityJodelBinding
import de.jbamberger.offlineclient.source.jodel.SecurePreferences
import de.jbamberger.offlineclient.ui.jodel.feed.JodelFeedFragment
import de.jbamberger.offlineclient.util.ExecuteAsRootBase
import timber.log.Timber
import javax.inject.Inject

class JodelActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    internal lateinit var prefs: SharedPreferences

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
        try {
            val jodelPath = "/data/data/com.tellm.android.app"
            val cmd = object : ExecuteAsRootBase() {
                override val commandsToExecute: List<String>
                    get() = listOf<String>(
                            "[ -f $jodelPath/files/INSTALLATION ] && cp $jodelPath/files/INSTALLATION $filesDir && chmod 755 ${filesDir.absolutePath}/INSTALLATION",
                            "[ -f $jodelPath/shared_prefs/tellm.xml ] && cp $jodelPath/shared_prefs/tellm.xml ${applicationInfo.dataDir}/shared_prefs/tellm.xml" + "&& chmod 755 ${applicationInfo.dataDir}/shared_prefs/tellm.xml")
            }
            cmd.execute()
            val p = getSharedPreferences("tellm", Context.MODE_PRIVATE)
            val pref = SecurePreferences(applicationContext)
            val m = p.all
            for (k in m.keys) {
                try {
                    val key = pref.decryptString(k)
                    val value = pref.decryptString(m[k] as String)
                    Timber.d("run: key: [$key], val: [$value]")

                    if (key == "accessToken") {
                        prefs.edit().putString("accessToken", value).apply()
                    }
                } catch (e: ClassCastException) {
                    Timber.e(e)
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
