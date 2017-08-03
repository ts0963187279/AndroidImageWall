package com.walton.android.photowall.listener;

import android.view.KeyEvent;
import android.view.View;

import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class ExitSelectModOnKeyListener implements View.OnKeyListener{
    private PhotoWallAdapter adapter;
    public ExitSelectModOnKeyListener(PhotoWallAdapter adapter){
        this.adapter = adapter;
    }
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(adapter.isSelectMod()) {
            if (keyCode == event.KEYCODE_BACK) {
                adapter.ViewMod();
                return true;
            }
        }
        return false;
    }
}
