package com.wakeupngoc.boilerplate.dagger.component.activity;

import com.wakeupngoc.boilerplate.dagger.scope.ActScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ngoctranfire on 1/3/17.
 */

@Module
public abstract class ActivityModule<T> {
    protected final T activity;

    public ActivityModule(T activity) {
        this.activity = activity;
    }

    @Provides
    @ActScope
    public T provideActivity() {
        return activity;
    }
}