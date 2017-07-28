package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallCellView extends LinearLayout{
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    public PhotoWallCellView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.cell_item_layout,this);
        showImage = (SimpleDraweeView)findViewById(R.id.frescoImg);
        selectChecker = (CheckBox)findViewById(R.id.select);
    }
    public void setImage(Uri uri){
        showImage.setImageURI(uri);
        showImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }
    public void setPadding(int left,int top,int right,int bottom){
        showImage.setPadding(left,top,right,bottom);
    }
    public void setCheck(boolean isCheck){
        selectChecker.setChecked(isCheck);
    }
    public void setOnClickListener(OnClickListener onClickListener){
        showImage.setOnClickListener(onClickListener);
    }
    public void setOnLongClickListener(OnLongClickListener onLongClickListener){
        showImage.setOnLongClickListener(onLongClickListener);
    }
}
