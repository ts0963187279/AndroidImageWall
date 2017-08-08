package com.walton.android.photowall.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellHeaderView;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    PhotoWallCellHeaderView view;
    View.OnClickListener onDoubleClickListener = new DefaultHeaderDoubleClickListener();
    View.OnClickListener selectModOnClickListener = new DefaultSelectModHeaderOnClickListener();
    View.OnLongClickListener selectModOnLongClickListener = new DefaultSelectModHeaderLongClickListener();
    public void setView(View view){
        this.view = (PhotoWallCellHeaderView)view;
    }
    public void setOnDoubleClickListener(View.OnClickListener onDoubleClickListener){
        this.onDoubleClickListener = onDoubleClickListener;
    }
    public void setSelectModOnLongClickListener(View.OnLongClickListener selectModOnLongClickListener){
        this.selectModOnLongClickListener = selectModOnLongClickListener;
    }
    public void setSelectModOnClickListener(View.OnClickListener selectModOnClickListener){
        this.selectModOnClickListener = selectModOnClickListener;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event){
        if(!view.getSelectModData().isSelectMod()) {
            onDoubleClickListener.onClick(view);
            return true;
        }else
            selectModOnClickListener.onClick(view);
            return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event){
        if(view.getSelectModData().isSelectMod())
            selectModOnClickListener.onClick(view);
        return true;
    }
    @Override
    public void onLongPress(MotionEvent event){
        if(!view.getSelectModData().isSelectMod())
            selectModOnLongClickListener.onLongClick(view);
    }
    @Override
    public boolean onDown(MotionEvent event){
        return true;
    }
}