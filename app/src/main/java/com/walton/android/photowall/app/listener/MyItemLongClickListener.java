package com.walton.android.photowall.app.listener;

import android.view.View;

import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/7/26.
 */

public class MyItemLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        ItemView view = (ItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().adapterNotify();
        return true;
    }
}
