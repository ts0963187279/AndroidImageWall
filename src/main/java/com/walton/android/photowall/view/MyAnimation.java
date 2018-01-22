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
package com.walton.android.photowall.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by waltonmis on 2017/7/12.
 */

public class MyAnimation {
    private Animation am;
    private float fromX,toX,fromY,toY;
    public MyAnimation(float fromX, float toX, float fromY, float toY) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
    }
    public void StartScaleAnimation(View view){
        am = new ScaleAnimation(fromX,toX,fromY,toY);
        am.setDuration(9000000);
        view.startAnimation(am);
    }public void StartTranslateAnimation(View view){
        am = new TranslateAnimation(fromX,toX,fromY,toY);
        am.setDuration(9000000);
        view.startAnimation(am);
    }

}
