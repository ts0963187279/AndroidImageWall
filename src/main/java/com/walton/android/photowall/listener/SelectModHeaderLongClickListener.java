package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public abstract class SelectModHeaderLongClickListener implements View.OnLongClickListener{
    private SelectModData selectModData;
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public void SelectModDataOnChange(View v){
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView)v;
        int section = view.getSection();
        System.out.println(section);
        for(int i=0;i<selectModData.getPositionCount(section);i++){
            if(!selectModData.isCheck(section,i))
                selectModData.incCheckCount();
            selectModData.setIsCheck(section,i,true);
        }
        selectModData.setHeaderCheck(section,true);
        selectModData.setIsSelectMod(true);
        selectModData.adapterNotify();
    }
    @Override
    public abstract boolean onLongClick(View v);
}
