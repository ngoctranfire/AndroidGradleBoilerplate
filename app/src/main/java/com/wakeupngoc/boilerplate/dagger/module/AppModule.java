package com.wakeupngoc.boilerplate.dagger.module;

import android.content.Context;
import android.content.res.Resources;

import com.wakeupngoc.boilerplate.dagger.scope.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ngoctranfire on 12/18/16.
 */
@Module
public class AppModule {
    private Context app;

    public AppModule(Context application) {
        app = application;
    }

    @Provides
    @AppScope
    Context provideApplication() {
        return app;
    }


    @Provides
    @AppScope
    Resources provideResources() {
        return app.getResources();
    }
}
