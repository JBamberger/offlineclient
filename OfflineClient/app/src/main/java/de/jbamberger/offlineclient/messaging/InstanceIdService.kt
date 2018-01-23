package de.jbamberger.offlineclient.messaging

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import de.jbamberger.offlineclient.source.backend.BackendApi
import timber.log.Timber


class InstanceIdService : FirebaseInstanceIdService() {


//    @Inject
    @JvmField
    var api: BackendApi? = null

    override fun onCreate() {
//        AndroidInjection.inject(this)
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
        if (old.isBlank()) {
            if (!new.isBlank()) {
                api!!.insertToken(new)
            }
        } else {
            if (old.equals(new)) {
                return
            } else {
                api!!.updateToken(old, new)
            }
        }
    }
}
