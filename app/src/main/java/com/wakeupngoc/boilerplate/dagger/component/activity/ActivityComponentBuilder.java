package com.wakeupngoc.boilerplate.dagger.component.activity;

/**
 * Created by ngoctranfire on 1/3/17.
 */

public interface ActivityComponentBuilder<M extends ActivityModule, C extends ActivityComponent> {
    ActivityComponentBuilder<M, C> activityModule(M activityModule);
    C build();
}