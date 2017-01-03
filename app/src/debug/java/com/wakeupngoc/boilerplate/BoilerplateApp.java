package com.wakeupngoc.boilerplate;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.facebook.stetho.Stetho;
import com.wakeupngoc.boilerplate.dagger.component.activity.ActivityComponent;
import com.wakeupngoc.boilerplate.dagger.component.activity.ActivityComponentBuilder;
import com.wakeupngoc.boilerplate.dagger.component.app.AppComponent;
import com.wakeupngoc.boilerplate.dagger.component.DaggerAppComponent;
import com.wakeupngoc.boilerplate.dagger.module.AppModule;
import com.wakeupngoc.boilerplate.dagger.module.RemoteModule;
import com.wakeupngoc.boilerplate.logs.LogTree;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by ngoctranfire on 12/18/16.
 */

public class BoilerplateApp extends Application {

    private static AppComponent appComponent;
    @Inject Map<Class<? extends Activity>, Provider<ActivityComponentBuilder>> activityComponentBuilders;
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        Timber.plant(new LogTree());
        Timber.i("Boilerplate App started!");
        initAppComponents();
    }

    public static BoilerplateApp get(Context context) {
        return (BoilerplateApp) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public void initAppComponents() {
        Timber.i("Dagger Graph Created!");
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        appComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .remoteModule(new RemoteModule(loggingInterceptor))
            .build();
        appComponent.inject(this);

    }

    /**
     * Visible only for testing purposes.
     */
    @VisibleForTesting
    public void setTestComponent(AppComponent testingComponent) {
        appComponent = testingComponent;
    }
}