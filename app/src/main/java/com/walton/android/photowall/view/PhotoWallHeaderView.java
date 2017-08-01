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

public class PhotoWallHeaderView extends PhotoWallCellHeaderView{
    public TextView header;
    public CheckBox selectAllChecker;
    public PhotoWallHeaderView(Context context, View HeaderView) {
        super(context,HeaderView);
        header = (TextView)HeaderView.findViewById(R.id.header);
        selectAllChecker = (CheckBox)HeaderView.findViewById(R.id.select_all);
    }
}
