package com.walton.android.photowall.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.processer.ViewCreator;
import com.walton.android.photowall.view.MyPhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyItemViewCreator implements ViewCreator {
    Context context;
    public MyItemViewCreator(Context context){
        this.context = context;
    }
    @Override
    public View createView() {
        return new MyPhotoWallCellItemView(context);
    }
}
