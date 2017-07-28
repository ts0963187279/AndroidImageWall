package com.walton.android.photowall.view;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallCellHeaderView extends LinearLayout{
    private TextView header;
    private CheckBox selectAllChecker;
    public PhotoWallCellHeaderView(Context context,View HeaderView) {
        super(context);
        header = (TextView)HeaderView.findViewById(R.id.header);
        selectAllChecker = (CheckBox)HeaderView.findViewById(R.id.select_all);
    }
    public void setText(String title){
        header.setText(title);
    }
    public void setPadding(int left,int top,int right,int bottom){
        header.setPadding(left,top,right,bottom);
    }
    public void setChecked(boolean isCheck){
        selectAllChecker.setChecked(isCheck);
    }
    public void setCheckBoxVisible(int isVisible){
        selectAllChecker.setVisibility(isVisible);
    }
    public void setOnClickListener(OnClickListener onClickListener){
        header.setOnClickListener(onClickListener);
    }
    public void setOnLongClickListener(OnLongClickListener onLongClickListener){
        header.setOnLongClickListener(onLongClickListener);
    }
}
