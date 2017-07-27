package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class SelectAllLongClickListener implements View.OnLongClickListener{
    private boolean selectMod;
    private boolean[] headerCheck;
    private boolean[][] isCheck;
    private int CheckCount;
    private int section;
    private PhotoWallAdapter adapter;
    public SelectAllLongClickListener(boolean selectMod, int CheckCount,boolean[][] isCheck, boolean[] headerCheck, PhotoWallAdapter adapter){
        this.selectMod = selectMod;
        this.CheckCount = CheckCount;
        this.headerCheck = headerCheck;
        this.isCheck = isCheck;
        this.adapter = adapter;
    }
    public void setSection(int section){
        this.section = section;
    }
    @Override
    public boolean onLongClick(View view) {
        for(int i=0;i<isCheck[section].length;i++){
            if(!isCheck[section][i])
                CheckCount++;
            isCheck[section][i] = true;
        }
        headerCheck[section] = true;
        selectMod = true;
        adapter.setSelectModData(selectMod,CheckCount,isCheck);
        adapter.setHeaderCheck(headerCheck);
        adapter.notifyDataSetChanged();
        return true;
    }
}
