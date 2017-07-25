package com.walton.android.photowall.processer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
    private List<File> ImageList;
    private RecyclerView.LayoutManager layoutManager;
    public GalleryAdapter(Context context , List<File> ImageList, RecyclerView.LayoutManager layoutManager){
        this.context = context;
        this.ImageList = ImageList;
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
        Bitmap bitmap = BitmapFactory.decodeFile(ImageList.get(position).getAbsolutePath());
        viewHolder.FullScreenImg.setImageBitmap(bitmap);
        viewHolder.FullScreenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,ImageList.get(position).toURI().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ImageList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView FullScreenImg;
        public ViewHolder(View view){
            super(view);
            FullScreenImg = (ImageView)view.findViewById(R.id.FullScreenImg);
        }
    }
}
