package com.walton.android.photowall.listener;

import android.view.KeyEvent;
import android.view.View;

import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class ExitSelectModListener implements View.OnKeyListener{
    private PhotoWallAdapter adapter;
    private boolean selectMod;
    public ExitSelectModListener(PhotoWallAdapter adapter){
        this.adapter = adapter;
    }
    public void setSelectMod(boolean selectMod){
        this.selectMod = selectMod;
    }
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if(selectMod) {
            if (keyCode == event.KEYCODE_BACK) {
                adapter.ViewMode();
                return true;
            }
        }
        return false;
    }
}
