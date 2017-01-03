package com.wakeupngoc.boilerplate.presentation.images.list;

import android.support.annotation.NonNull;

import com.wakeupngoc.boilerplate.domain.interactor.usecase.FetchImagesUseCase;
import com.wakeupngoc.boilerplate.domain.model.Photo;

import java.util.List;

/**
 * Created by ngoctranfire on 12/18/16.
 */

public class ImagesListPresenter implements ImagesListContract.Presenter, FetchImageListener {
    private ImagesListContract.View view;
    private FetchImagesUseCase fetchImagesUseCase;

    public ImagesListPresenter(@NonNull ImagesListContract.View view, @NonNull FetchImagesUseCase fetchImagesUseCase) {
        this.view = view;
        this.fetchImagesUseCase = fetchImagesUseCase;
    }


    @Override
    public void subscribe() {
        view.setLoadingIndicator(true);
    }

    @Override
    public void unsubscribe() {
        this.view = null;
    }

    @Override
    public void onImagesFetchSuccess(@NonNull List<Photo> photoList) {

    }

    @Override
    public void onImagesFetchError(@NonNull String error) {

    }

    @Override
    public void fetchRecentImages(int itemsPerPage, int pageNumber) {

    }

    @Override
    public void searchImages(@NonNull String text, int itemsPerPage, int pageNumber) {

    }
}
