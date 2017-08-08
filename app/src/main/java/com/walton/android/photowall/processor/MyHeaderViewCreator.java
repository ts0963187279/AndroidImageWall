package com.walton.android.photowall.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.processer.ViewCreator;
import com.walton.android.photowall.view.MyOnSelectHeaderView;
import com.walton.android.photowall.view.MyPhotoWallCellHeaderView;
import com.walton.android.photowall.view.MyStaySelectionHeaderView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyHeaderViewCreator implements ViewCreator {
    Context context;
    public MyHeaderViewCreator(Context context){
        this.context = context;
    }
    @Override
    public View createView(int status) {
        switch(status){
            case 1 :
                return new MyStaySelectionHeaderView(context);
            case 2 :
                return new MyOnSelectHeaderView(context);
            default:
                return new MyPhotoWallCellHeaderView(context);
        }
    }
}
