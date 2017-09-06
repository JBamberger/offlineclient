package de.jbamberger.offlinefetcher.di;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jbamberger.offlinefetcher.BuildConfig;
import de.jbamberger.offlinefetcher.source.jodel.JodelApi;
import de.jbamberger.offlinefetcher.source.jodel.typeadapter.ByteArrayTypeAdapter;
import de.jbamberger.offlinefetcher.source.jodel.typeadapter.DateTimeTypeAdapter;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        //gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeSerializer());
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter());
        gsonBuilder.registerTypeAdapter(byte[].class, new ByteArrayTypeAdapter());
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, SharedPreferences sharedPreferences) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (cache != null) {
            builder.cache(cache);
        }
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        builder.addInterceptor(chain -> {
            Request original = chain.request();

            String accessToken = sharedPreferences.getString("accessToken", "63792751-28cccc12-21c5d3d5-5087-40f6-a1ca-aaf58555da91");

            Request request = original.newBuilder()
                    .header("User-Agent", "Jodel/4.56.1 Dalvik/2.1.0 (Linux; U; Android 7.1.1; GT-I9295 Build/NOF27B)")//version 4.47.0
                    .header("Authorization", "Bearer " + accessToken)//59374521-a79c9e81-614da76f-f171-4783-8063-ef955ef3972f")
                    //.header("X-Client-Type", "android_4.47.0")
                    //.header("X-Api-Version", "0.2")
                    //.header("X-Timestamp", "2017-06-11T20:33:44Z")
                    //.header("X-Authorization", "HMAC 4A49F88A4B3E11A6FE2C559FF7228DF0917D1CB9")

                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        return builder.build();


    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitAPI(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                //.addConverterFactory(SimpleXmlConverterFactory.create())//TODO produces errors, different handling necessary
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient);
    }

    @Provides
    @Singleton
    JodelApi provideJodelApiInterface(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(JodelApi.BASE_URL).build().create(JodelApi.class);
    }
}
