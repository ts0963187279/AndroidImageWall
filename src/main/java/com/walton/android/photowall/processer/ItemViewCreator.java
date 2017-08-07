package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.DefaultPhotoWallCellItemView;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class ItemViewCreator extends ViewCreator {
    private Context context;
    public ItemViewCreator(Context context) {
        this.context = context;
    }
    @Override
    public View createView() {
        return new DefaultPhotoWallCellItemView(context);
    }
}
