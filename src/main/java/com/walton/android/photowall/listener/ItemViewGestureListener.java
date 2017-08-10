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
    View.OnClickListener onDoubleClickListener = new DefaultItemDoubleClickListener();
    View.OnClickListener onClickListener = new DefaultImageGalleryOnClickListener();
    View.OnClickListener selectModOnClickListener = new DefaultSelectModItemOnClickListener();
    View.OnLongClickListener selectModOnLongClickListener = new DefaultSelectModItemLongClickListener();
    public void setView(View view){
        this.view = (ItemView)view;
    }
    public void setDoubleOnClickListener(View.OnClickListener onDoubleClickListener){
        this.onDoubleClickListener =onDoubleClickListener;
    }
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
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
        if(!view.getSelectModData().isSelectMod())
            onClickListener.onClick(view);
        else
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
