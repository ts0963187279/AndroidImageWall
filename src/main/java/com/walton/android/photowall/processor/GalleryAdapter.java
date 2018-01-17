package com.walton.android.photowall.processor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.view.GalleryCellItemView;

import java.io.File;
import java.util.List;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryItemViewHolder>{
    private Context context;
    private List<Uri> ImageUriList;
    public GalleryAdapter(Context context , List<Uri> ImageUriList){
        this.context = context;
        this.ImageUriList = ImageUriList;
    }
    @Override
    public GalleryItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_layout,viewGroup,false);
        return new GalleryItemViewHolder(view,context);
    }
    @Override
    public void onBindViewHolder(final GalleryItemViewHolder viewHolder, final int position) {
        viewHolder.galleryCellItemView.setImageURI(ImageUriList.get(position));
    }
    @Override
    public int getItemCount() {
        return ImageUriList.size();
    }
}
