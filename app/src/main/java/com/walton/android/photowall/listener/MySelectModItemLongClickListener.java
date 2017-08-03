package com.walton.android.photowall.listener;

import android.view.View;

/**
 * Created by waltonmis on 2017/7/26.
 */

public class MySelectModItemLongClickListener extends SelectModItemLongClickListener{
    @Override
    public boolean onLongClick(View v) {
        super.SelectModDataOnChange(v);
        return true;
    }
}
