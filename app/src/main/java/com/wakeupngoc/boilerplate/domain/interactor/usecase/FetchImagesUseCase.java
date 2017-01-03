package com.wakeupngoc.boilerplate.domain.interactor.usecase;

/**
 * Created by ngoctranfire on 1/3/17.
 */

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wakeupngoc.boilerplate.presentation.images.list.FetchImageListener;

/**
 * I plan to use this later, but actually right now, I don't need to use this because my logic doesn't get that complicated at all.
 */
public interface FetchImagesUseCase {
    void getRecentPhotos(final @Nullable String extras, final int itemsPerPage,
                         final int pageNumber, final @NonNull FetchImageListener fetchListener);
    void searchImages(final @Nullable String text, @NonNull String extras, final int itemsPerPage,
                      final int pageNumber, final @NonNull FetchImageListener fetchListener);
}
