package com.wakeupngoc.boilerplate.presentation.images.list;

import android.support.annotation.NonNull;

import com.wakeupngoc.boilerplate.domain.model.Photo;
import com.wakeupngoc.boilerplate.presentation.BasePresenter;
import com.wakeupngoc.boilerplate.presentation.BaseView;

import java.util.List;

/**
 * Created by ngoctranfire on 12/18/16.
 */

class ImagesListContract {

    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);
        void showImagesList(List<Photo> photos);
    }

    interface Presenter extends BasePresenter {
        void fetchRecentImages(final int itemsPerPage, final int pageNumber);
        void searchImages(@NonNull String text, final int itemsPerPage, int pageNumber);
    }
}
