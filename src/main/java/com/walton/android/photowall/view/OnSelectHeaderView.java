package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class OnSelectHeaderView extends PhotoWallCellHeaderView{
    private TextView header;
    private CheckBox selectAllChecker;
    public OnSelectHeaderView(Context context) {
        super(context);
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header = new TextView(context);
        header.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        selectAllChecker = new CheckBox(context);
        selectAllChecker.setClickable(false);
        setBackgroundColor(Color.GRAY);
        addView(selectAllChecker);
        addView(header);
        selectAllChecker.setChecked(true);
    }

    @Override
    public void setText(String title) {
        header.setText(title);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {

    }

    @Override
    public void setChecked(boolean isCheck) {
    }

    @Override
    public boolean isChecked() {
        return selectAllChecker.isChecked();
    }

    @Override
    public void setCheckBoxVisible(int isVisible) {

    }
}
