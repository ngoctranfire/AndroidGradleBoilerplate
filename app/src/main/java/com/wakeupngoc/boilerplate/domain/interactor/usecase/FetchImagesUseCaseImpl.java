package com.wakeupngoc.boilerplate.domain.interactor.usecase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;

import com.wakeupngoc.boilerplate.domain.model.PhotoSearchResult;
import com.wakeupngoc.boilerplate.domain.service.remote.FlickrService;
import com.wakeupngoc.boilerplate.presentation.images.list.FetchImageListener;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by ngoctranfire on 1/3/17.
 */

public class FetchImagesUseCaseImpl implements FetchImagesUseCase{
    private FlickrService flickrService;

    @Inject
    public FetchImagesUseCaseImpl(@NonNull FlickrService flickrService) {
        this.flickrService = flickrService;
    }

    @Override
    public void getRecentPhotos(final @Nullable String extras, final int itemsPerPage,
                                final int pageNumber,
                                final @NonNull FetchImageListener fetchListener) {
        flickrService.getRecentPhotos(extras, itemsPerPage, pageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<PhotoSearchResult>() {
                @Override
                public void onSubscribe(Subscription s) {
                    Timber.i("Started flickr.photos.recent, with extras=%s, itemsPerPage=%d, pageNumber=%d", extras, itemsPerPage, pageNumber);
                }

                @Override
                public void onNext(PhotoSearchResult photoSearchResult) {
                    fetchListener.onImagesFetchSuccess(photoSearchResult.photoResults.photos);
                }

                @Override
                public void onError(Throwable t) {
                    Timber.e(t);
                    fetchListener.onImagesFetchError(t.getMessage());
                }

                @Override
                public void onComplete() {
                    Timber.i("Finished flickr.photos.recent, with extras=%s, itemsPerPage=%d, pageNumber=%d", extras, itemsPerPage, pageNumber);
                }
            });
    }

    @Override
    public void searchImages(final @Nullable String text, final @NonNull String extras,
                             final int itemsPerPage, final int pageNumber,
                             final @NonNull FetchImageListener fetchListener) {
        flickrService.getRecentPhotos(extras, itemsPerPage, pageNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<PhotoSearchResult>() {
                @Override
                public void onSubscribe(Subscription s) {
                    Timber.i("Started flickr.photos.search, with searchText=%s, extras=%s, itemsPerPage=%d, pageNumber=%d",  text, extras, itemsPerPage, pageNumber);
                }

                @Override
                public void onNext(PhotoSearchResult photoSearchResult) {
                    fetchListener.onImagesFetchSuccess(photoSearchResult.photoResults.photos);
                }

                @Override
                public void onError(Throwable t) {
                    Timber.e(t);
                    fetchListener.onImagesFetchError(t.getMessage());
                }

                @Override
                public void onComplete() {
                    Timber.i("Finished flickr.photos.search, with extras=%s, itemsPerPage=%d, pageNumber=%d", extras, itemsPerPage, pageNumber);
                }
            });
    }
}
