package com.wakeupngoc.boilerplate.dagger.component.activity;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by ngoctranfire on 1/3/17.
 */

public interface HasActivitySubcomponentBuilders {
    ActivityComponentBuilder getActivityComponentBuilder(Class<? extends AppCompatActivity> activityClass);
}
