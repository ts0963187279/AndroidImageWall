package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by waltonmis on 2017/8/1.
 */

public class PhotoWallItemView extends PhotoWallCellItemView {
    public SimpleDraweeView showImage;
    public CheckBox selectChecker;
    public PhotoWallItemView(Context context, View itemView) {
        super(context,itemView);
        showImage = (SimpleDraweeView)itemView.findViewById(start.android.library.R.id.frescoImg);
        selectChecker = (CheckBox)itemView.findViewById(start.android.library.R.id.select);
    }
}