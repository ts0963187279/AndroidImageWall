package com.walton.android.photowall.listener;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class ItemViewOnTouchListener implements View.OnTouchListener {
    private GestureDetectorCompat gestureDetector;
    private ItemViewGestureListener itemViewGestureListener;
    public void setGestureDetector(Context context ,ItemViewGestureListener itemViewGestureListener){
        this.itemViewGestureListener = itemViewGestureListener;
        this.gestureDetector = new GestureDetectorCompat(context,itemViewGestureListener);
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(gestureDetector == null){
            itemViewGestureListener = new ItemViewGestureListener();
            gestureDetector = new GestureDetectorCompat(view.getContext(),itemViewGestureListener);
        }
        itemViewGestureListener.setView(view);
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
