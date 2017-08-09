package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class MyItemDoubleClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().incCheckCount();
        view.getSelectModData().adapterNotify();
    }
}
