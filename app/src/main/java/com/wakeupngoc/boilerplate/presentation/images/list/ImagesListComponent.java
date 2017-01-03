package com.wakeupngoc.boilerplate.presentation.images.list;

import com.wakeupngoc.boilerplate.dagger.component.activity.ActivityComponent;
import com.wakeupngoc.boilerplate.dagger.component.activity.ActivityComponentBuilder;
import com.wakeupngoc.boilerplate.dagger.scope.ActScope;

import dagger.Subcomponent;

/**
 * Created by ngoctranfire on 1/3/17.
 */

@ActScope
@Subcomponent(
    modules = {ImagesListModule.class}
)
public interface ImagesListComponent extends ActivityComponent<ImagesListAct> {
    void inject(ImagesListAct imagesListAct);
    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<ImagesListModule, ImagesListComponent> {

    }
}
