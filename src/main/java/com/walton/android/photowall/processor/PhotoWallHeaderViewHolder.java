package com.walton.android.photowall.processer;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.view.HeaderView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallHeaderViewHolder extends StickyHeaderGridAdapter.HeaderViewHolder{
    HeaderView headerView;
    public PhotoWallHeaderViewHolder(HeaderView itemView) {
        super(itemView);
        this.headerView = itemView;
    }
}
