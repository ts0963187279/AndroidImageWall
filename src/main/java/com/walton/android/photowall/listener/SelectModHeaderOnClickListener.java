package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public abstract class SelectModHeaderOnClickListener implements View.OnClickListener{
    private SelectModData selectModData;
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public void SelectModDataOnChange(View v){
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView)v;
        int section = view.getSection();
        System.out.println(section);
        if(!selectModData.getHeaderCheck(section)){
            for(int i=0;i<selectModData.getPositionCount(section);i++){
                if(!selectModData.isCheck(section,i))
                    selectModData.incCheckCount();
                selectModData.setIsCheck(section,i,true);
            }
            selectModData.setHeaderCheck(section,true);
            selectModData.setIsSelectMod(true);
        }else{
            for(int i=0;i<selectModData.getPositionCount(section);i++){
                if(selectModData.isCheck(section,i))
                    selectModData.decCheckCount();
                selectModData.setIsCheck(section,i,false);
            }
            selectModData.setHeaderCheck(section,false);
            selectModData.setIsSelectMod(false);
        }
        selectModData.adapterNotify();
    }
    @Override
    public abstract void onClick(View v);
}
