package com.walton.android.photowall.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

/**
 * Created by waltonmis on 2017/7/12.
 */

public class MyScaleAnimation{
    private Animation am;
    public MyScaleAnimation(float fromX, float toX, float fromY, float toY) {
        am = new ScaleAnimation(fromX,toX,fromY,toY);
        am.setDuration(9000000);
    }
    public void StartAnimation(View view){
        view.startAnimation(am);
    }
}
