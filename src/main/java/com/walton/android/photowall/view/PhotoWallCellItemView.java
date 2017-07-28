package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PhotoWallCellItemView extends LinearLayout{
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    public PhotoWallCellItemView(Context context, View itemView) {
        super(context);
        showImage = (SimpleDraweeView)itemView.findViewById(R.id.frescoImg);
        selectChecker = (CheckBox)itemView.findViewById(R.id.select);
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
    public void setOnClickListener(OnClickListener onClickListener){
        showImage.setOnClickListener(onClickListener);
    }
    public void setOnLongClickListener(OnLongClickListener onLongClickListener){
        showImage.setOnLongClickListener(onLongClickListener);
    }
}
