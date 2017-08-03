package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/26.
 */

public abstract class SelectModItemLongClickListener implements View.OnLongClickListener{
    private SelectModData selectModData;
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public void SelectModDataOnChange(View v){
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        int section = view.getSection();
        int position = view.getPosition();
        view.setVisibility(View.VISIBLE);
        view.setChecked(!view.isChecked());
        selectModData.setIsCheck(section,position,true);
        selectModData.incCheckCount();
        selectModData.adapterNotify();
    }
    @Override
    public abstract boolean onLongClick(View v);
}
