package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.listener.DefaultImageGalleryOnClickListener;

/**
 * Created by waltonmis on 2017/7/28.
 */

public  class DefaultPhotoWallCellItemView extends PhotoWallCellItemView{
    private SimpleDraweeView showImage;
    public DefaultPhotoWallCellItemView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        setBackgroundColor(Color.GREEN);
        addView(showImage);
    }
    @Override
    public void setImageUri(Uri uri) {
        showImage.setImageURI(uri);
    }
}
