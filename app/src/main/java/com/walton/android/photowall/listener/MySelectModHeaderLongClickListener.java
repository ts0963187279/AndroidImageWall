package com.walton.android.photowall.listener;

import android.view.View;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class MySelectModHeaderLongClickListener extends SelectModHeaderLongClickListener{
    @Override
    public boolean onLongClick(View v) {
        super.SelectModDataOnChange(v);
        return true;
    }
}
