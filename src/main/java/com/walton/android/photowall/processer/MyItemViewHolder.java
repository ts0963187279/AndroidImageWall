package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyItemViewHolder extends StickyHeaderGridAdapter.ItemViewHolder{
    PhotoWallCellItemView photoWallCellView;
    public MyItemViewHolder(View itemView,Context context) {
        super(itemView);
        photoWallCellView = new PhotoWallCellItemView(context,itemView);
    }
}
