package com.walton.android.photowall.listener;

import android.view.View;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class MySelectModItemOnClickListener extends SelectModItemOnClickListener {
    @Override
    public void onClick(View v) {
        super.SelectModDataOnChange(v);
    }
}
