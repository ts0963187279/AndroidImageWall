package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.DefaultOnSelectItemView;
import com.walton.android.photowall.view.DefaultPhotoWallCellItemView;
import com.walton.android.photowall.view.DefaultStaySelectionItemView;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class ItemViewCreator implements ViewCreator {
    private Context context;
    public ItemViewCreator(Context context) {
        this.context = context;
    }
    @Override
    public View createView(int status) {
        switch (status){
            case 1:
                return new DefaultStaySelectionItemView(context);
            case 2:
                return new DefaultOnSelectItemView(context);
            default:
                return new DefaultPhotoWallCellItemView(context);
        }
    }
}
