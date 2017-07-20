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
