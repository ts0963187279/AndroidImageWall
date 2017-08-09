package com.walton.android.photowall.view;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

/**
 * Created by waltonmis on 2017/8/9.
 */

public class SelectModToolBar extends Toolbar{
    public SelectModToolBar(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setTitle("this is select mod");
    }
}
