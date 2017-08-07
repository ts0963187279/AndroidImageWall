package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class DefaultHeaderDoubleClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView)v;
        int section = view.getSection();
        System.out.println(section);
        view.getSelectModData().isHeaderChecked(section,!view.isChecked());
        view.getSelectModData().adapterNotify();
    }
}
