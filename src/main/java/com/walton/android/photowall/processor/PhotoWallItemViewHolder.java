package com.walton.android.photowall.processor;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallItemViewHolder extends StickyHeaderGridAdapter.ItemViewHolder{
    ItemView photoWallCellView;
    public PhotoWallItemViewHolder(ItemView itemView) {
        super(itemView);
        this.photoWallCellView = itemView;
    }
    
}
