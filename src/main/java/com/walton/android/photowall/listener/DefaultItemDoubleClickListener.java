package com.walton.android.photowall.listener;

import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellItemView;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class DefaultItemDoubleClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().adapterNotify();
    }
}
