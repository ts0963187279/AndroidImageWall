package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class DefaultItemDoubleClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        int section = view.getSection();
        int position = view.getPosition();
        view.setVisibility(View.VISIBLE);
        view.setChecked(!view.isChecked());
        view.getSelectModData().setItemCheck(section,position,true);
        view.getSelectModData().incCheckCount();
        view.getSelectModData().adapterNotify();
    }
}
