package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class SelectModItemOnClickListener implements View.OnClickListener {
    private boolean selectMod;
    private boolean isCheck[][];
    private int CheckCount;
    private int position;
    private int section;
    private PhotoWallAdapter adapter;
    public SelectModItemOnClickListener(boolean selectMod, int CheckCount, boolean[][] isCheck, PhotoWallAdapter adapter){
        this.selectMod = selectMod;
        this.CheckCount = CheckCount;
        this.isCheck = isCheck;
        this.adapter = adapter;
    }
    public void setSectionPosition(int section , int position){
        this.section = section;
        this.position = position;
    }
    @Override
    public void onClick(View v) {
        if(!isCheck[section][position]) {
            selectMod = true;
            isCheck[section][position] = true;
            CheckCount++;
        }else{
            isCheck[section][position] = false;
            CheckCount--;
        }
        adapter.TitleOnChange("已選取 "+String.valueOf(CheckCount));
        adapter.setSelectModData(selectMod,CheckCount,isCheck);
    }
}
