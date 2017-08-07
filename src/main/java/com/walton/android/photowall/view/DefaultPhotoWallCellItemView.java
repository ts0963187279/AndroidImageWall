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
    private CheckBox selectChecker;
    public DefaultPhotoWallCellItemView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        selectChecker = new CheckBox(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        selectChecker.setClickable(false);
        selectChecker.setVisibility(GONE);
        setBackgroundColor(Color.GREEN);
        DefaultImageGalleryOnClickListener defaultImageGalleryOnClickListener = new DefaultImageGalleryOnClickListener();
        setOnClickListener(defaultImageGalleryOnClickListener);
        addView(showImage);
        addView(selectChecker);
    }

    @Override
    public  boolean isChecked(){
        return selectChecker.isChecked();
    }
    public  void setImage(Uri uri){
        showImage.setImageURI(uri);
    }
    public  void setPadding(int left, int top, int right, int bottom){
        showImage.setPadding(left, top, right, bottom);
    }
    public  void setChecked(boolean isCheck){
        selectChecker.setChecked(isCheck);
    }
    public  void setCheckBoxVisible(int isVisible){
        selectChecker.setVisibility(isVisible);
    }
}
