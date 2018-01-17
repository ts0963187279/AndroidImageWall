package com.walton.android.photowall.processor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.walton.android.photowall.view.GalleryCellItemView;

/**
 * Created by waltonmis on 2017/8/1.
 */

public class GalleryItemViewHolder extends RecyclerView.ViewHolder{
    GalleryCellItemView galleryCellItemView;
    public GalleryItemViewHolder(View itemView, Context context) {
        super(itemView);
        galleryCellItemView = new GalleryCellItemView(context,itemView);
    }

}
