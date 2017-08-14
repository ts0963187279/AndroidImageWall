package com.walton.android.photowall.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.walton.android.photowall.view.HeaderView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    HeaderView view;
    View.OnClickListener onDoubleClickListener = new DefaultHeaderDoubleClickListener();
    View.OnClickListener selectModOnClickListener = new DefaultSelectModHeaderOnClickListener();
    View.OnLongClickListener selectModOnLongClickListener = new DefaultSelectModHeaderLongClickListener();
    public void setView(View view){
        this.view = (HeaderView)view;
    }
    public void setOnDoubleClickListener(View.OnClickListener onDoubleClickListener){

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
        return false;
    }
    @Override
    public void onLongPress(MotionEvent event){
    }
    @Override
    public boolean onDown(MotionEvent event){
        return true;
    }
}
