package com.walton.android.photowall.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.walton.android.photowall.model.SelectModData;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class PhotoWallCellHeaderView extends LinearLayout{
    private int section;
    private SelectModData selectModData;
    public PhotoWallCellHeaderView(Context context) {
        super(context);
    }
    public void setSection(int section) {
        this.section = section;
    }
    public int getSection(){
        return section;
    }
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public SelectModData getSelectModData(){
        return selectModData;
    }
    public abstract void setText(String title);
    public abstract void setPadding(int left, int top, int right, int bottom);
    public abstract void setChecked(boolean isCheck);
    public abstract boolean isChecked();
    public abstract void setCheckBoxVisible(int isVisible);
}
