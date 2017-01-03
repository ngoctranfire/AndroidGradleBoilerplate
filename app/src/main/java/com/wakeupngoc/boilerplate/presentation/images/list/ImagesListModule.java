package com.wakeupngoc.boilerplate.presentation.images.list;

import com.wakeupngoc.boilerplate.dagger.component.activity.ActivityModule;
import com.wakeupngoc.boilerplate.dagger.scope.ActScope;
import com.wakeupngoc.boilerplate.domain.interactor.usecase.FetchImagesUseCase;
import com.wakeupngoc.boilerplate.domain.interactor.usecase.FetchImagesUseCaseImpl;
import com.wakeupngoc.boilerplate.domain.service.remote.FlickrService;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ngoctranfire on 1/3/17.
 */

@Module
public class ImagesListModule extends ActivityModule<ImagesListAct> {

    ImagesListModule(ImagesListAct act) {
        super(act);
    }

    @Provides @ActScope
    FetchImagesUseCase provideFetchImagesUseCase(FlickrService flickrService) {
        return new FetchImagesUseCaseImpl(flickrService);
    }
}
