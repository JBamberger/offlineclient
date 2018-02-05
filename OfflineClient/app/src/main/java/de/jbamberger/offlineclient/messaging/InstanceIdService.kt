package de.jbamberger.offlineclient.messaging

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import dagger.android.AndroidInjection
import de.jbamberger.offlineclient.source.backend.BackendApi
import timber.log.Timber
import javax.inject.Inject


class InstanceIdService : FirebaseInstanceIdService() {


    @Inject
    @JvmField
    var api: BackendApi? = null

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onTokenRefresh() {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val oldToken: String = prefs.getString("token", "")
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Timber.e( "Refreshed token: " + refreshedToken!!)

        updateToken(oldToken, refreshedToken)
    }

    fun updateToken(old: String, new: String) {
        Timber.d("updateToken %s\n%s", old, new)
        if (old.isBlank()) {
            if (!new.isBlank()) {
                api!!.insertToken(new).observeForever {
                    if (it != null) {
                        Timber.d("%b %s %s", it.isSuccessful, it.body, it.errorMessage)
                    }
                }
            }
        } else {
            if (old.equals(new)) {
                return
            } else {
                api!!.updateToken(old, new).observeForever {
                    if (it != null) {
                        Timber.d("%b %s %s", it.isSuccessful, it.body, it.errorMessage)
                    }
                }
            }
        }
    }
}
