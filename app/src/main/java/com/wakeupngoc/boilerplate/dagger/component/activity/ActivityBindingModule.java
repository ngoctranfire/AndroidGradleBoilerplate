package com.wakeupngoc.boilerplate.dagger.component.activity;

import com.wakeupngoc.boilerplate.dagger.keys.ActivityKey;
import com.wakeupngoc.boilerplate.presentation.images.list.ImagesListAct;
import com.wakeupngoc.boilerplate.presentation.images.list.ImagesListComponent;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by ngoctranfire on 1/3/17.
 */
@Module(
    subcomponents = {
        ImagesListComponent.class
    }
)
public abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(ImagesListAct.class)
    public abstract ActivityComponentBuilder imagesListActComponentBuilder(ImagesListComponent.Builder impl);
}
