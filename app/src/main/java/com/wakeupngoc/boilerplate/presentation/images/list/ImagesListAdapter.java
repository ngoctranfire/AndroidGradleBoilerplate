package com.wakeupngoc.boilerplate.presentation.images.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wakeupngoc.boilerplate.R;
import com.wakeupngoc.boilerplate.domain.model.Photo;

import java.util.ArrayList;
import java.util.List;

class ImagesListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    @NonNull private List<Photo> photos;
    @NonNull private Context context;

    public ImagesListAdapter(@NonNull Context context) {
        this.photos = new ArrayList<>();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder itemHolder = (ItemViewHolder) holder;
        Photo photo = photos.get(position);
        itemHolder.bindViewHolder(photo.createPhotoURL("q"), context);
    }

    public void updatePhotos(@NonNull List<Photo> photos) {
        this.photos.addAll(photos);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    private static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ItemViewHolder(@NonNull View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.flickr_image);
        }

        void bindViewHolder(@NonNull String imageUrl, @NonNull Context context) {
            Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_crop_original_black_24dp)
                .error(R.drawable.ic_crop_original_black_24dp)
                .into(imageView);
        }

    }
}
