package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.PhotoWallCellView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyItemViewHolder extends StickyHeaderGridAdapter.ItemViewHolder{
    private Context context;
    private PhotoWallCellView photoWallCellView;
    public MyItemViewHolder(View itemView,Context context) {
        super(itemView);
        this.context = context;
        photoWallCellView = new PhotoWallCellView(context);
    }
}
