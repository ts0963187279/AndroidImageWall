package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyHeaderView extends HeaderView {
    private TextView header;
    public MyHeaderView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header = new TextView(context);
        header.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header.setTextColor(Color.BLACK);
        setBackgroundColor(Color.WHITE);
        addView(header);
    }

    @Override
    public void setText(String title){
        header.setText(title);
    }
}
