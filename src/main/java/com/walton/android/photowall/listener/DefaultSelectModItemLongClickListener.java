package com.walton.android.photowall.listener;

import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/26.
 */

public class DefaultSelectModItemLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().adapterNotify();
        return true;
    }
}
