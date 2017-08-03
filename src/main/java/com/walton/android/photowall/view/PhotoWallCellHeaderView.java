package com.walton.android.photowall.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class PhotoWallCellHeaderView extends LinearLayout{
    private int section;
    public PhotoWallCellHeaderView(Context context) {
        super(context);
    }
    public void setSection(int section) {
        this.section = section;
    }
    public int getSection(){
        return section;
    }
    public abstract PhotoWallCellHeaderView getNew();
    public abstract void setText(String title);
    public abstract void setPadding(int left, int top, int right, int bottom);
    public abstract void setChecked(boolean isCheck);
    public abstract void setCheckBoxVisible(int isVisible);
}
