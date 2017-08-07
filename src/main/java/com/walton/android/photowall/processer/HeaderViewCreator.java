package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.DefaultPhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderViewCreator extends ViewCreator {
    private Context context;
    public HeaderViewCreator(Context context){
        this.context = context;
    }
    @Override
    public View createView() {
        return new DefaultPhotoWallCellHeaderView(context);
    }
}
