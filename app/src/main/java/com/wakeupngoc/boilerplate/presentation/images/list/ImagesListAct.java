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

    private ImagesListAdapter imagesListAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AppCompatTextView loadingText;

    @Inject ImagesListContract.Presenter presenter;

    @Override
    protected void injectComponent() {
        BoilerplateApp.get(this)
            .getAppComponent()
            .plus(new ImagesListModule(this))
            .inject(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_list);
        injectComponent();

        this.imagesListAdapter = new ImagesListAdapter(this);
        this.progressBar = (ProgressBar) findViewById(R.id.progress_loading);
        this.loadingText = (AppCompatTextView) findViewById(R.id.text_loading);
        this.recyclerView = (RecyclerView) findViewById(R.id.images_listing_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(imagesListAdapter);
        presenter.subscribe();
    }

    // TODO: Currently we are actually recreating the presenter every single time. This is unnecessary. This can be solved by retaining an instance of the presenter
    // To avoid doing unnecessary work.... FIXME
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
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            progressBar.setVisibility(View.VISIBLE);
            loadingText.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            loadingText.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
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
