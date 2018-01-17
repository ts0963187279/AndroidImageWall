package com.walton.android.photowall.app.listener;

import android.view.View;

import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class MyItemSelectModOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        ItemView view = (ItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().adapterNotify();
    }
}