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
    View.OnClickListener onDoubleClickListener = new HeaderDoubleClickListener();
    View.OnClickListener selectModOnClickListener = new SelectModHeaderOnClickListener();
    View.OnLongClickListener selectModOnLongClickListener = new SelectModHeaderLongClickListener();
    public void setView(View view){
        this.view = (HeaderView)view;
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
        if(view.getSelectModData().getPositionCount(view.getSection()) != 0) {
                onDoubleClickListener.onClick(view);
        }
        return false;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event){
        if(view.getSelectModData().getPositionCount(view.getSection()) != 0) {
            if (view.getSelectModData().isSelectMod())
                selectModOnClickListener.onClick(view);
            return true;
        }
        return false;
    }
    @Override
    public void onLongPress(MotionEvent event){
        if(view.getSelectModData().getPositionCount(view.getSection()) != 0) {
            if (!view.getSelectModData().isSelectMod())
                selectModOnLongClickListener.onLongClick(view);
        }
    }
    @Override
    public boolean onDown(MotionEvent event){
        return true;
    }
}
