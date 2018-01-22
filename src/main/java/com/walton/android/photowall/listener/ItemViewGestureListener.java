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

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class ItemViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    ItemView view;
    View.OnClickListener onDoubleClickListener = new ItemDoubleClickListener();
    View.OnClickListener onClickListener = new ItemViewOnClickListener();
    View.OnClickListener selectModOnClickListener = new SelectModItemOnClickListener();
    View.OnLongClickListener selectModOnLongClickListener = new SelectModItemLongClickListener();
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
