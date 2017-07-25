package com.walton.android.photowall.processer;

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

import java.io.File;
import java.util.List;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder>{
    private Context context;
    private List<Uri> ImageUriList;
    private RecyclerView.LayoutManager layoutManager;
    public GalleryAdapter(Context context , List<Uri> ImageUriList, RecyclerView.LayoutManager layoutManager){
        this.context = context;
        this.ImageUriList = ImageUriList;
        this.layoutManager = layoutManager;
    }
    public void UpdataView(RecyclerView.LayoutManager layoutManager, int position){
        this.layoutManager = layoutManager;
        this.layoutManager.scrollToPosition(position);
    }
    public int getPosition(){
        return((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition();
    }
    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final GalleryAdapter.ViewHolder viewHolder, final int position) {
        viewHolder.FullScreenImg.setImageURI(ImageUriList.get(position));
    }

    @Override
    public int getItemCount() {
        return ImageUriList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView FullScreenImg;
        public ViewHolder(View view){
            super(view);
            FullScreenImg = (ImageView)view.findViewById(R.id.FullScreenImg);
        }
    }
}
