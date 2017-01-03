package com.wakeupngoc.boilerplate.domain.service.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wakeupngoc.boilerplate.domain.model.PhotoSearchResult;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ngoctranfire on 12/18/16.
 */

public interface FlickrService {
    @GET("flickr.photos.getRecent")
    Flowable<PhotoSearchResult> getRecentPhotos(@Nullable @Query("extras") String extras,
                                                @Query("per_page") int perPage,
                                                @Query("page") int page);
    @GET("flickr.photos.search")
    Flowable<PhotoSearchResult> searchFlickrPhotos(@NonNull @Query("text") String text,
                                                    @Nullable @Query("extras") String extras,
                                                    @Query("per_page") int perPage,
                                                    @Query("page") int page);
}
