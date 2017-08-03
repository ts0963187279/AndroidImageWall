package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.listener.GoToImageGalleryOnClickListener;
import com.walton.android.photowall.processer.PhotoWallHeaderViewHolder;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class MyPhotoWallCellItemView extends PhotoWallCellItemView{
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    private Context context;
    public MyPhotoWallCellItemView(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        selectChecker = new CheckBox(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        selectChecker.setClickable(false);
        selectChecker.setVisibility(GONE);
        setBackgroundColor(Color.BLACK);
        GoToImageGalleryOnClickListener goToImageGalleryOnClickListener = new GoToImageGalleryOnClickListener();
        setOnClickListener(goToImageGalleryOnClickListener);
        addView(showImage);
        addView(selectChecker);
    }

    @Override
    public PhotoWallCellItemView getNew() {
        return new MyPhotoWallCellItemView(context);
    }
    public boolean isChecked(){
        return selectChecker.isChecked();
    }
    public void setImage(Uri uri){
        showImage.setImageURI(uri);
        showImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    public void setPadding(int left,int top,int right,int bottom){
        showImage.setPadding(left,top,right,bottom);
    }
    public void setChecked(boolean isCheck){
        selectChecker.setChecked(isCheck);
    }
    public void setCheckBoxVisible(int isVisible){
        selectChecker.setVisibility(isVisible);
    }
}