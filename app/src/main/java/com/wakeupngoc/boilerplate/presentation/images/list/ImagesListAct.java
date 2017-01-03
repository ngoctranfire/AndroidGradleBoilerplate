package com.wakeupngoc.boilerplate.presentation.images.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.wakeupngoc.boilerplate.BoilerplateApp;
import com.wakeupngoc.boilerplate.R;
import com.wakeupngoc.boilerplate.domain.interactor.usecase.FetchImagesUseCase;
import com.wakeupngoc.boilerplate.domain.model.Photo;
import com.wakeupngoc.boilerplate.domain.service.remote.FlickrService;
import com.wakeupngoc.boilerplate.presentation.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class ImagesListAct extends BaseActivity implements ImagesListContract.View {

    private ImagesListContract.Presenter presenter;
    private ImagesListAdapter imagesListAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AppCompatTextView loadingText;
    private FetchImagesUseCase useCase;
    @Inject FlickrService flickrService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_list);

//        DaggerImagesListComponent;
        ImagesListPresenter imagesListPresenter = new ImagesListPresenter(this, useCase);
        this.imagesListAdapter = new ImagesListAdapter(this);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_loading);
        this.loadingText = (AppCompatTextView) findViewById(R.id.text_loading);
        this.recyclerView = (RecyclerView) findViewById(R.id.images_listing_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(imagesListAdapter);
        imagesListPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.presenter.unsubscribe();
        this.useCase = null;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            progressBar.setVisibility(View.VISIBLE);
            loadingText.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            loadingText.setVisibility(View.GONE);
        }
    }

    @Override
    public void showImagesList(List<Photo> photos) {
        imagesListAdapter.updatePhotos(photos);
    }

    @Override
    public void setPresenter(ImagesListContract.Presenter presenter) {
        this.presenter = presenter;
    }


}
