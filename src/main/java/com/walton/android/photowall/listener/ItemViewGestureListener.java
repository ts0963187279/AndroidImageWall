package com.walton.android.photowall.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class ItemViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    ItemView view;
    View.OnClickListener onClickListener = new DefaultImageGalleryOnClickListener();
    public void setView(View view){
        this.view = (ItemView)view;
    }
    public void setDoubleOnClickListener(View.OnClickListener onDoubleClickListener){
    }
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    public void setSelectModOnLongClickListener(View.OnLongClickListener selectModOnLongClickListener){
    }
    public void setSelectModOnClickListener(View.OnClickListener selectModOnClickListener){
    }
    @Override
    public boolean onDoubleTap(MotionEvent event){
        return false;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event){
        onClickListener.onClick(view);
        return true;
    }
    @Override
    public void onLongPress(MotionEvent event){
    }
    @Override
    public boolean onDown(MotionEvent event){
        return true;
    }
}
