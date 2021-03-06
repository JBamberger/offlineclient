package de.jbamberger.api.provider.jodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences
import de.jbamberger.api.*
import de.jbamberger.api.provider.jodel.model.GetPostsComboResponse
import de.jbamberger.api.provider.jodel.model.Post
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Singleton
class JodelRepository @Inject
internal constructor(private val appExecutors: AppExecutors, private val api: JodelApi, private val app: Application, private val prefs: SharedPreferences) {
    private val posts = MutableLiveData<Resource<List<Post>>>()

    fun getPosts(): LiveData<Resource<List<Post>>> {
        return NetworkBoundResource(appExecutors, object : NetworkBoundResource.Source<List<Post>, GetPostsComboResponse> {
            override fun saveCallResult(item: GetPostsComboResponse) {}

            override fun shouldFetch(data: List<Post>?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<List<Post>?> {
                return AbsentLiveData.create()
            }

            override fun createCall(): LiveData<ApiResponse<GetPostsComboResponse>> {
                val responseStream = api.getPostsCombo(
                        47.75027, 8.97875, true, true, false)
                        .map<ApiResponse<GetPostsComboResponse>> { ApiResponse.Success(it) }
                        .onErrorReturn { ApiResponse.Error(it) }
                return LiveDataReactiveStreams.fromPublisher(responseStream)
            }
        }).asLiveData()
    }


    fun credentials() {
        try {
            val jodelPath = "/data/data/com.tellm.android.app"
            val commands = listOf(
                    "[ -f $jodelPath/files/INSTALLATION ] && cp $jodelPath/files/INSTALLATION ${app.filesDir} && chmod 755 ${app.filesDir.absolutePath}/INSTALLATION",
                    "[ -f $jodelPath/shared_prefs/tellm.xml ] && cp $jodelPath/shared_prefs/tellm.xml ${app.applicationInfo.dataDir}/shared_prefs/tellm.xml" + "&& chmod 755 ${app.applicationInfo.dataDir}/shared_prefs/tellm.xml")
            ExecuteAsRoot.execute(commands)
            val p = app.getSharedPreferences("tellm", Context.MODE_PRIVATE)
            val pref = PreferenceCodec(app.applicationContext)
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
