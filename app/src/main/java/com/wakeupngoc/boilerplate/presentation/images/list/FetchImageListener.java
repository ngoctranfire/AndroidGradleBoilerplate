package com.wakeupngoc.boilerplate.presentation.images.list;

import android.support.annotation.NonNull;

import com.wakeupngoc.boilerplate.domain.model.Photo;

import java.util.List;

/**
 * Created by ngoctranfire on 1/3/17.
 */

public interface FetchImageListener {
    void onImagesFetchSuccess(@NonNull List<Photo> photoList);
    void onImagesFetchError(String error);
}
