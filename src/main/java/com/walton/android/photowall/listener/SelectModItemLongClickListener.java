package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/7/26.
 */

public class SelectModItemLongClickListener implements View.OnLongClickListener{
    private boolean selectMod;
    private boolean isCheck[][];
    private int CheckCount;
    private int position;
    private int section;
    private PhotoWallAdapter adapter;
    public SelectModItemLongClickListener(boolean selectMod, int CheckCount, boolean isCheck[][], PhotoWallAdapter adapter){
        this.selectMod = selectMod;
        this.CheckCount = CheckCount;
        this.isCheck = isCheck;
        this.adapter = adapter;
    }
    public void setSectionPosition(int section,int position){
        this.section = section;
        this.position = position;
    }
    @Override
    public boolean onLongClick(View view) {
        selectMod = true;
        isCheck[section][position] = true;
        CheckCount ++;
        adapter.TitleOnChange("已選取 "+String.valueOf(CheckCount));
        adapter.setSelectModData(selectMod,CheckCount,isCheck);
        return true;
    }
}
