package com.walton.android.photowall.processor;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.walton.android.photowall.R;
import com.walton.android.photowall.processer.PhotoWallHeaderViewHolder;
import com.walton.android.photowall.processer.PhotoWallItemViewHolder;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;
import com.walton.android.photowall.view.PhotoWallHeaderView;
import com.walton.android.photowall.view.PhotoWallItemView;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/8/1.
 */

public class MyPhotoWallAdapter extends com.walton.android.photowall.processer.PhotoWallAdapter{
    private Context context;
    public MyPhotoWallAdapter(Context context, TreeMap<String, ArrayList<Uri>> UriTreeMap, RecyclerView recyclerView, int row, AppCompatActivity appCompatActivity) {
        super(context, UriTreeMap, recyclerView, row, appCompatActivity);
        this.context = context;
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photowall_header_layout,parent,false);
        PhotoWallHeaderView photoWallHeaderView = new PhotoWallHeaderView(context,view);
        return new PhotoWallHeaderViewHolder(view,photoWallHeaderView);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        Fresco.initialize(context);
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photowall_item_layout,parent,false);
        PhotoWallItemView photoWallItemView = new PhotoWallItemView(context,view);
        return new PhotoWallItemViewHolder(view,photoWallItemView);
    }
}
