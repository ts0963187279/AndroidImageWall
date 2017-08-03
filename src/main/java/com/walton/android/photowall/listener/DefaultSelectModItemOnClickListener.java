package com.walton.android.photowall.listener;

import android.view.View;
import android.widget.Toast;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class DefaultSelectModItemOnClickListener extends SelectModItemOnClickListener {
    @Override
    public void onClick(View v) {
        super.SelectModDataOnChange(v);
    }
}
