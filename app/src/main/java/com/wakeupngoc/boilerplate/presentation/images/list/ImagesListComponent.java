package com.wakeupngoc.boilerplate.presentation.images.list;

import com.wakeupngoc.boilerplate.dagger.scope.ActScope;

import dagger.Subcomponent;

/**
 * Created by ngoctranfire on 1/3/17.
 */

@ActScope
@Subcomponent(
    modules = {ImagesListModule.class}
)
public interface ImagesListComponent{
    void inject(ImagesListAct imagesListAct);
}
