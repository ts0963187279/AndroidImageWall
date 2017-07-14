package com.walton.android.photowall.processer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.walton.android.photowall.listener.ZoomImgOnClickListener;

import java.io.File;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/11.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private File[] ImageList;
    private Context context;
    private FragmentManager fragmentManager;
    private RecyclerView recyclerView;
    public MyAdapter(Context context, File[] ImageList, FragmentManager fragmentManager,RecyclerView recyclerView){
        this.context = context;
        this.ImageList = ImageList;
        this.fragmentManager = fragmentManager;
        this.recyclerView = recyclerView;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, int position) {
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Bitmap bitmap = BitmapFactory.decodeFile(ImageList[position].getAbsolutePath());
        viewHolder.img.setImageBitmap(bitmap);
        ZoomImgOnClickListener zoomImgOnClickListener = new ZoomImgOnClickListener(context,recyclerView,fragmentManager);
        //viewHolder.img.setOnClickListener(zoomImgOnClickListener);
    }

    @Override
    public int getItemCount() {
        return ImageList.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ViewHolder(View view){
            super(view);
            img = (ImageView)view.findViewById(R.id.img);
        }
    }
}
