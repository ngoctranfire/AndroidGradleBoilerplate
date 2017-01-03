package com.wakeupngoc.boilerplate.domain.service.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.wakeupngoc.boilerplate.domain.model.PhotoResults;
import com.wakeupngoc.boilerplate.domain.model.PhotoSearchResult;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ngoctranfire on 12/18/16.
 */

public interface FlickrService {
    @GET("/services/rest/?method=flickr.photos.getRecent")
    Maybe<PhotoSearchResult> getRecentPhotos(@Nullable @Query("extras") String extras,
                                            @Query("per_page") int perPage,
                                            @Query("page") int page);
    @GET("/services/rest/?method=flickr.photos.search")
    Maybe<PhotoSearchResult> searchFlickrPhotos(@NonNull @Query("tag") String text,
                                                @Nullable @Query("extras") String extras,
                                                @Query("per_page") int perPage,
                                                @Query("page") int page);
}
