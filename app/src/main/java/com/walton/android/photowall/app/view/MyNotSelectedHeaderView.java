package com.walton.android.photowall.app.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.walton.android.photowall.view.HeaderView;
/**
 * Created by waltonmis on 2017/8/8.
 */

public class MyNotSelectedHeaderView extends HeaderView {
    private TextView header;
    private CheckBox selectAllChecker;
    public MyNotSelectedHeaderView(Context context) {
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
}
