package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public abstract class SelectModItemOnClickListener implements View.OnClickListener {
    private SelectModData selectModData;
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public void SelectModDataOnChange(View v){
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        int section = view.getSection();
        int position = view.getPosition();
        view.setChecked(!view.isChecked());
        if(view.isChecked()) {
            selectModData.setIsCheck(section,position,true);
            selectModData.incCheckCount();
        }else{
            selectModData.setIsCheck(section,position,false);
            selectModData.decCheckCount();
        }
        selectModData.adapterNotify();
    }
    @Override
    public abstract void onClick(View v);
}
