package com.wakeupngoc.boilerplate.presentation.images.list;

import android.support.annotation.NonNull;

import com.wakeupngoc.boilerplate.dagger.scope.ActScope;
import com.wakeupngoc.boilerplate.domain.interactor.usecase.FetchImagesUseCase;
import com.wakeupngoc.boilerplate.domain.model.Photo;

import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

@ActScope
public class ImagesListPresenter implements ImagesListContract.Presenter, FetchImageListener {
    private ImagesListContract.View view;
    private FetchImagesUseCase fetchImagesUseCase;

    @Inject
    public ImagesListPresenter(@NonNull ImagesListContract.View view, @NonNull FetchImagesUseCase fetchImagesUseCase) {
        Timber.i(" I can't believe this is being recreated!");
        this.view = view;
        this.fetchImagesUseCase = fetchImagesUseCase;
    }


    @Override
    public void subscribe() {
        view.setLoadingIndicator(true);
        fetchRecentImages(100, 1);
    }

    @Override
    public void unsubscribe() {
        this.view = null;
    }

    @Override
    public void onImagesFetchSuccess(@NonNull List<Photo> photoList) {
        view.showImagesList(photoList);
        this.view.setLoadingIndicator(false);
    }

    @Override
    public void onImagesFetchError(@NonNull String error) {
        Timber.e("Error trying to fetch images!");
    }

    @Override
    public void fetchRecentImages(int itemsPerPage, int pageNumber) {
        this.fetchImagesUseCase.getRecentPhotos(null, itemsPerPage, pageNumber, this);
    }

    //TODO: Add search support... Most likely won't be in this activity, but just put as placeholder
    @Override
    public void searchImages(@NonNull String text, int itemsPerPage, int pageNumber) {

    }
}
