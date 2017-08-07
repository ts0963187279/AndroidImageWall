package com.walton.android.photowall.processer;

import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public abstract class ViewCreator {
    public View getView(){
        return createView();
    }
    public abstract View createView();
}
