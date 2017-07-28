package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyHeaderViewHolder extends StickyHeaderGridAdapter.HeaderViewHolder{
    PhotoWallCellHeaderView photoWallCellHeaderView;
    public MyHeaderViewHolder(View itemView,Context context) {
        super(itemView);
        photoWallCellHeaderView = new PhotoWallCellHeaderView(context,itemView);
    }
}
