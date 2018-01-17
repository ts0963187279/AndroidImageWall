package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.view.HeaderView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class SelectModHeaderLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {
        HeaderView view = (HeaderView)v;
        int section = view.getSection();
        view.getSelectModData().headerOnChecked(section,true);
        view.getSelectModData().adapterNotify();
        return true;
    }
}
