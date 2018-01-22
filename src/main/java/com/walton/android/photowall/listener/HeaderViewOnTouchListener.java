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
