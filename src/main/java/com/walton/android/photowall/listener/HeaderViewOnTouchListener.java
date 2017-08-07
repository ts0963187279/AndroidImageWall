package com.walton.android.photowall.listener;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderViewOnTouchListener implements View.OnTouchListener{
    private GestureDetectorCompat gestureDetector;
    private HeaderViewGestureListener headerViewGestureListener;
    public void setGestureDetector(Context context , HeaderViewGestureListener headerViewGestureListener){
        this.headerViewGestureListener = headerViewGestureListener;
        this.gestureDetector = new GestureDetectorCompat(context,headerViewGestureListener);
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(gestureDetector == null){
            headerViewGestureListener = new HeaderViewGestureListener();
            gestureDetector = new GestureDetectorCompat(view.getContext(),headerViewGestureListener);
        }
        headerViewGestureListener.setView(view);
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }
}
