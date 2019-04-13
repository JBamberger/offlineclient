package de.jbamberger.offlineclient.messaging

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import dagger.android.AndroidInjection
import de.jbamberger.api.provider.backend.BackendRepository
import timber.log.Timber
import javax.inject.Inject


class InstanceIdService : FirebaseInstanceIdService() {


    @Inject
    internal lateinit var repo: BackendRepository

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onTokenRefresh() {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val oldToken: String = prefs.getString("token", "")
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Timber.e( "Refreshed token: " + refreshedToken!!)

        repo.updateToken(oldToken, refreshedToken)
    }
}
