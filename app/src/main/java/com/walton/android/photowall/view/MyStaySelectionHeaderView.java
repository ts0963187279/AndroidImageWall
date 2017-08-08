package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by waltonmis on 2017/8/8.
 */

public class MyStaySelectionHeaderView extends PhotoWallCellHeaderView{
    private TextView header;
    private CheckBox selectAllChecker;
    public MyStaySelectionHeaderView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header = new TextView(context);
        header.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        selectAllChecker = new CheckBox(context);
        selectAllChecker.setClickable(false);
        setBackgroundColor(Color.BLUE);
        addView(selectAllChecker);
        addView(header);
        selectAllChecker.setChecked(false);
    }
    @Override
    public void setText(String title) {
        header.setText(title);
    }
}
