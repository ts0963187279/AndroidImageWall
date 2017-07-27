package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class SelectAllOnClickListener implements View.OnClickListener{
    private boolean selectMod;
    private boolean[] headerCheck;
    private boolean[][] isCheck;
    private int CheckCount;
    private int position;
    private int section;
    private PhotoWallAdapter adapter;
    public SelectAllOnClickListener(boolean selectMod, int CheckCount,boolean[][] isCheck, boolean headerCheck[], PhotoWallAdapter adapter){
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
    public void onClick(View view) {
        if(!headerCheck[section]){
            for(int i=0;i<isCheck[section].length;i++){
                if(!isCheck[section][i])
                    CheckCount++;
                isCheck[section][i] = true;
            }
            headerCheck[section] = true;
            selectMod = true;
        }else{
            for(int i=0;i<isCheck[section].length;i++){
                if(isCheck[section][i])
                    CheckCount--;
                isCheck[section][i] = false;
            }
            headerCheck[section] = false;
            selectMod = false;
        }
        adapter.setSelectModData(selectMod,CheckCount,isCheck);
        adapter.setHeaderCheck(headerCheck);
        adapter.notifyDataSetChanged();
    }
}
