package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class DefaultSelectModHeaderOnClickListener extends SelectModHeaderOnClickListener{
    @Override
    public void onClick(View v) {
        super.SelectModDataOnChange(v);
    }
}