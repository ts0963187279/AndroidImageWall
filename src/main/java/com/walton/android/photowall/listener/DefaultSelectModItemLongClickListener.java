package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/26.
 */

public class DefaultSelectModItemLongClickListener extends SelectModItemLongClickListener{
    @Override
    public boolean onLongClick(View v) {
        super.SelectModDataOnChange(v);
        return true;
    }
}
