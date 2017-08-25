package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/8/1.
 */

public class GalleryCellItemView extends LinearLayout {
    private SimpleDraweeView FullScreenImg;
    public GalleryCellItemView(Context context, View itemView) {
        super(context);
        FullScreenImg = (SimpleDraweeView)itemView.findViewById(R.id.FullScreenImg);
    }
    public void setImagePath(String str){
        Uri uri = Uri.parse(str);
        FullScreenImg.setImageURI(uri);
    }
}
