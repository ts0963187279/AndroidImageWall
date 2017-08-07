package com.walton.android.photowall.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.processer.ViewCreator;
import com.walton.android.photowall.view.MyPhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyHeaderViewCreator extends ViewCreator {
    Context context;
    public MyHeaderViewCreator(Context context){
        this.context = context;
    }
    @Override
    public View createView() {
        return new MyPhotoWallCellHeaderView(context);
    }
}
