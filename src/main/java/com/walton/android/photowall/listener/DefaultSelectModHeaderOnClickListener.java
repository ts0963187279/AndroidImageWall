package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class DefaultSelectModHeaderOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView)v;
        int section = view.getSection();
        view.getSelectModData().headerOnChecked(section,!view.isChecked());
        view.getSelectModData().adapterNotify();
    }
}
