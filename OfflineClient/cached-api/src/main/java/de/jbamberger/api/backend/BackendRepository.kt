package de.jbamberger.api.backend

import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Singleton
class BackendRepository @Inject internal constructor(val api: BackendApi) {

    fun updateToken(old: String, new: String) {
        Timber.d("updateToken %s\n%s", old, new)
        if (old.isBlank()) {
            if (!new.isBlank()) {
                api.insertToken(new).subscribe(
                        { Timber.d("Status: ", it) },
                        { Timber.e(it, "Could not send token to backend!") })
            }
        } else {
            if (old.equals(new)) {
                return
            } else {
                api.updateToken(old, new)
                        .subscribe(
                                { Timber.d("Status: ", it) },
                                { Timber.e(it, "Could not send token to backend!") })
            }
        }
    }
}