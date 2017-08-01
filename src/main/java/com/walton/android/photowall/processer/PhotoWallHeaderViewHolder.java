package com.walton.android.photowall.processer;

import android.view.View;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallHeaderViewHolder extends StickyHeaderGridAdapter.HeaderViewHolder{
    PhotoWallCellHeaderView photoWallCellHeaderView;
    public PhotoWallHeaderViewHolder(View itemView, PhotoWallCellHeaderView photoWallCellHeaderView) {
        super(itemView);
        this.photoWallCellHeaderView = photoWallCellHeaderView;
    }
}
