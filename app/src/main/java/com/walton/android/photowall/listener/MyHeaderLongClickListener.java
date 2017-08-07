package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class MyHeaderLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView)v;
        int section = view.getSection();
        view.getSelectModData().isHeaderChecked(section,!view.isChecked());
        view.getSelectModData().adapterNotify();
        return true;
    }
}
