package de.jbamberger.offlinefetcher;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.LocalDateTime;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jbamberger.offlinefetcher.source.jodel.JodelApi;
import de.jbamberger.offlinefetcher.util.LocalDateTimeDeSerializer;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeSerializer());
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (cache != null) {
            builder.cache(cache);
        }
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("User-Agent", "Jodel/4.47.0 Dalvik/2.1.0 (Linux; U; Android 7.1.1; GT-I9295 Build/NOF27B)")
                        .header("Authorization", "Bearer 59374521-a79c9e81-614da76f-f171-4783-8063-ef955ef3972f")
                        //.header("X-Client-Type", "android_4.47.0")
                        //.header("X-Api-Version", "0.2")
                        //.header("X-Timestamp", "2017-06-11T20:33:44Z")
                        //.header("X-Authorization", "HMAC 4A49F88A4B3E11A6FE2C559FF7228DF0917D1CB9")

                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
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
    JodelApi provideFhgApiInterface(Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder.baseUrl(JodelApi.BASE_URL).build().create(JodelApi.class);
    }
}
