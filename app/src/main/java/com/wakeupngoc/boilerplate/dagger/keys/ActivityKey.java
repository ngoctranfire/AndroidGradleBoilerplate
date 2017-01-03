package com.wakeupngoc.boilerplate.dagger.keys;

import android.support.v7.app.AppCompatActivity;

import dagger.MapKey;

/**
 * Created by ngoctranfire on 1/3/17.
 */
@MapKey
public @interface ActivityKey {
    Class<? extends AppCompatActivity> value();
}
