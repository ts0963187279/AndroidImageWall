/*
 * Copyright (C) 2017 RS Wong <ts0963187279@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.android.photowall.listener;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.processor.PhotoWallAdapter;
import com.walton.android.photowall.view.MyAnimation;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class ScaleViewTouchListener implements RecyclerView.OnItemTouchListener {
    private boolean isPointerDown = false;
    private PointF SecondPointF = new PointF();
    private float Distance =1f;
    private static final int STATE_NONE = 0;
    private static final int STATE_ZOOM =1;
    private int State = STATE_NONE;
    private float NewScale;
    private int row = 4;
    private int maxRow = 4;
    private int minRow = 2;
    public void setMaxRow(int maxRow){
        this.maxRow = maxRow;
    }
    public void setMinRow(int minRow){
        this.minRow = minRow;
    }
    private float Spacing(MotionEvent motionEvent){
        double x = motionEvent.getX(0) - motionEvent.getX(1);
        double y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float)Math.sqrt(x * x + y * y);
    }
    private void MidPoint(PointF point,MotionEvent motionEvent){
        float x = motionEvent.getX(0) + motionEvent.getX(1);
        float y = motionEvent.getY(0) + motionEvent.getY(1);
        point.set(x/2,y/2);
    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        float DownX = 0;
        float DownY = 0;
        switch(e.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                isPointerDown = false;
                DownX = e.getX();
                DownY = e.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float x = e.getX();
                float y = e.getY();
                float xDelta = Math.abs(x - DownX);
                float yDelta = Math.abs(y - DownY);
                if(xDelta > 20 || yDelta >20)
                    isPointerDown = false;
                else
                    isPointerDown = true;
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                isPointerDown = true;
                break;
            case MotionEvent.ACTION_POINTER_UP:
                isPointerDown = false;
                break;
        }
        return isPointerDown;
    }

    @Override
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if(isPointerDown){
            Distance = Spacing(motionEvent);
            if(Distance > 20f){
                MidPoint(SecondPointF,motionEvent);
                State = STATE_ZOOM;
            }
            isPointerDown = false;
        }
        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_POINTER_UP:
                if(State == STATE_ZOOM) {
                    MyAnimation myAnimation = new MyAnimation(1f, 1f, 1f, 1f);
                    myAnimation.StartScaleAnimation(recyclerView);
                    if(NewScale < 1 && row < maxRow)
                        row++;
                    if(NewScale < 0.5 && row < maxRow)
                        row++;
                    if(NewScale > 1 && row > minRow)
                        row--;
                    if(NewScale > 1.8 && row > minRow)
                        row--;
                    StickyHeaderGridLayoutManager layoutManager = new StickyHeaderGridLayoutManager(row);
                    recyclerView.setLayoutManager(layoutManager);
                    State = STATE_NONE;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(State == STATE_ZOOM){
                    float NewDistance = Spacing(motionEvent);
                    if(NewDistance > 20f){
                        NewScale = NewDistance/Distance;
                        MyAnimation myAnimation = new MyAnimation(NewScale,NewScale,NewScale,NewScale);
                        myAnimation.StartScaleAnimation(recyclerView);
                    }
                }
                break;
        }
    }
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
