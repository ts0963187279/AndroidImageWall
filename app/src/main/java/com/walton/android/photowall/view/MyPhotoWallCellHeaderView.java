package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyPhotoWallCellHeaderView extends PhotoWallCellHeaderView{
    private TextView header;
    private CheckBox selectAllChecker;
    public MyPhotoWallCellHeaderView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header = new TextView(context);
        header.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        selectAllChecker = new CheckBox(context);
        selectAllChecker.setClickable(false);
        setBackgroundColor(Color.RED);
        addView(selectAllChecker);
        addView(header);
    }

    @Override
    public void setText(String title){
        header.setText(title);
    }
    public void setPadding(int left,int top,int right,int bottom){
        header.setPadding(left,top,right,bottom);
    }
    public boolean isChecked(){return selectAllChecker.isChecked();}
    public void setChecked(boolean isCheck){
        selectAllChecker.setChecked(isCheck);
    }
    public void setCheckBoxVisible(int isVisible){
        selectAllChecker.setVisibility(isVisible);
    }
}
