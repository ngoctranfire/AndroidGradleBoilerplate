package com.wakeupngoc.boilerplate;

import android.app.Application;
import android.content.Context;

import com.wakeupngoc.boilerplate.dagger.component.AppComponent;
import com.wakeupngoc.boilerplate.dagger.component.DaggerAppComponent;
import com.wakeupngoc.boilerplate.dagger.module.AppModule;
import com.wakeupngoc.boilerplate.dagger.module.RemoteModule;
import com.wakeupngoc.boilerplate.logs.LogTree;

import timber.log.Timber;

/**
 * Created by ngoctranfire on 12/18/16.
 */

public class BoilerplateApp extends Application {

    private static AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
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
        appComponent = DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .remoteModule(new RemoteModule(null))
            .build();

    }

}