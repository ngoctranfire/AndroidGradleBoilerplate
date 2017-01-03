package com.wakeupngoc.boilerplate.dagger.module;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wakeupngoc.boilerplate.constants.AppConstants;
import com.wakeupngoc.boilerplate.dagger.qualifier.FlickrApi;
import com.wakeupngoc.boilerplate.dagger.scope.AppScope;
import com.wakeupngoc.boilerplate.domain.service.remote.FlickrService;
import com.wakeupngoc.boilerplate.presentation.images.list.ImagesListComponent;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module (
    subcomponents = {
        ImagesListComponent.class
    }
)
public class RemoteModule {
    @Nullable private final Interceptor interceptor1; // Okhttp Interceptor, either Stetho or OkHttpLoggingOne
    public RemoteModule(@Nullable Interceptor interceptor1) {
        this.interceptor1 = interceptor1;
    }

    @NonNull @Provides @AppScope
    Cache provideDefaultHttpCache(@NonNull Context context) {
        long cacheSize = AppConstants.cacheSize;
        return new Cache(context.getCacheDir(), cacheSize);
    }

    @NonNull @Provides @AppScope
    OkHttpClient provideDefaultHttpClient(@NonNull Cache cache) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(this.interceptor1)
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key", AppConstants.FLICKR_API_KEY)
                        .addQueryParameter("format", "json")
                        .addQueryParameter("nojsoncallback", Integer.toString(1))
                        .build();
                    request = request.newBuilder().url(url).build();
                    return chain.proceed(request);
                }
            })
            .cache(cache);
        return httpClient.build();
    }

    @NonNull @Provides @AppScope
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @NonNull @Provides @AppScope @FlickrApi
    FlickrService provideFlickrRetrofitApi(@NonNull Gson gson, @NonNull OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .baseUrl(AppConstants.FLICKR_API_URL);

        Retrofit retrofit = builder.build();
        return retrofit.create(FlickrService.class);
    }

}
