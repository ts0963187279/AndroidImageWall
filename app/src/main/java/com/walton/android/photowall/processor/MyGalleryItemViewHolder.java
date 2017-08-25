package com.walton.android.photowall.processor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.walton.android.photowall.view.GalleryCellItemView;
import com.walton.android.photowall.view.GalleryView;

/**
 * Created by waltonmis on 2017/8/1.
 */

public class MyGalleryItemViewHolder extends RecyclerView.ViewHolder{
    GalleryView galleryView;
    public MyGalleryItemViewHolder(GalleryView itemView) {
        super(itemView);
        galleryView = itemView;
    }

}
