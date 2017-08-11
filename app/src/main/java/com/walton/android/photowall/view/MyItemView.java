package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.listener.DefaultImageGalleryOnClickListener;
import com.walton.android.photowall.listener.ItemViewOnClickListener;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyItemView extends ItemView {
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    public MyItemView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        selectChecker = new CheckBox(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        selectChecker.setClickable(false);
        selectChecker.setVisibility(GONE);
        setBackgroundColor(Color.BLACK);
        addView(showImage);
        addView(selectChecker);
    }
    @Override
    public void setImageUri(Uri uri) {
        showImage.setImageURI(uri);
    }
}