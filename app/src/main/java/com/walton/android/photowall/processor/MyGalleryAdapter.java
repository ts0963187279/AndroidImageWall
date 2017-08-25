package com.walton.android.photowall.processor;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.walton.android.photowall.processer.GalleryItemViewHolder;
import com.walton.android.photowall.view.GalleryView;

import java.util.List;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class MyGalleryAdapter extends RecyclerView.Adapter<MyGalleryItemViewHolder>{
    private Context context;
    private List<String> ImageUriList;
    public MyGalleryAdapter(Context context , List<String> ImageUriList){
        this.context = context;
        this.ImageUriList = ImageUriList;
    }
    @Override
    public MyGalleryItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        GalleryView view = new GalleryView(context);
        return new MyGalleryItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyGalleryItemViewHolder viewHolder, final int position) {
        viewHolder.galleryView.setImagePath(ImageUriList.get(position));
    }
    @Override
    public int getItemCount() {
        return ImageUriList.size();
    }
}
