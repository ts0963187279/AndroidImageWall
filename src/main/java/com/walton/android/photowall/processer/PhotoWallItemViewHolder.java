package com.walton.android.photowall.processer;

import android.view.View;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallItemViewHolder extends StickyHeaderGridAdapter.ItemViewHolder{
    PhotoWallCellItemView photoWallCellView;
    public PhotoWallItemViewHolder(View itemView,PhotoWallCellItemView photoWallCellView) {
        super(itemView);
        this.photoWallCellView = photoWallCellView;
    }
}
