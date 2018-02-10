package de.jbamberger.api.net

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import de.jbamberger.api.BuildConfig
import de.jbamberger.api.provider.jodel.typeadapter.ByteArrayTypeAdapter
import de.jbamberger.api.provider.jodel.typeadapter.DateTimeTypeAdapter
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Module
class NetModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        //gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeSerializer());
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeTypeAdapter())
        gsonBuilder.registerTypeAdapter(ByteArray::class.java, ByteArrayTypeAdapter())
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(cache: Cache?, sharedPreferences: SharedPreferences): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (cache != null) {
            builder.cache(cache)
        }
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(httpLoggingInterceptor)
        }

        builder.addInterceptor { chain ->
            val original = chain.request()

            val accessToken = sharedPreferences.getString("accessToken", "63792751-28cccc12-21c5d3d5-5087-40f6-a1ca-aaf58555da91")

            val request = original.newBuilder()
                    .header("User-Agent", "Jodel/4.56.1 Dalvik/2.1.0 (Linux; U; Android 7.1.1; GT-I9295 Build/NOF27B)")//version 4.47.0
                    .header("Authorization", "Bearer " + accessToken!!)//59374521-a79c9e81-614da76f-f171-4783-8063-ef955ef3972f")
                    //.header("X-Client-Type", "android_4.47.0")
                    //.header("X-Api-Version", "0.2")
                    //.header("X-Timestamp", "2017-06-11T20:33:44Z")
                    //.header("X-Authorization", "HMAC 4A49F88A4B3E11A6FE2C559FF7228DF0917D1CB9")

                    .method(original.method(), original.body())
                    .build()

            chain.proceed(request)
        }

        return builder.build()


    }

    @Provides
    @Singleton
    internal fun provideRetrofitAPI(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
                .addCallAdapterFactory(LiveDataCallAdapterFactory())
                //.addConverterFactory(SimpleXmlConverterFactory.create())//TODO produces errors, different handling necessary
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
    }
}
