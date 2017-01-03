package com.wakeupngoc.boilerplate.dagger.component.activity;

import android.support.v7.app.AppCompatActivity;

import dagger.MembersInjector;

/**
 * Created by ngoctranfire on 1/3/17.
 */

public interface ActivityComponent<A extends AppCompatActivity> extends MembersInjector<A> {
}
