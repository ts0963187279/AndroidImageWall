package com.walton.android.photowall.listener;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import com.walton.android.photowall.view.MyScaleAnimation;
/**
 * Created by waltonmis on 2017/7/12.
 */

public class ZoomOnTouchListener implements View.OnTouchListener{
    private RecyclerView recyclerView;
    private PointF SecondPointF = new PointF();
    private float Distance =1f;
    private static final int STATE_NONE = 0;
    private static final int STATE_ZOOM =1;
    private int State = STATE_NONE;
    private float NewScale;
    private Context context;
    private int row = 4;
    public ZoomOnTouchListener(Context context, RecyclerView recyclerView){
        this.recyclerView = recyclerView;
        this.context = context;
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
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_POINTER_DOWN:
                Distance = Spacing(motionEvent);
                if(Distance > 20f){
                    MidPoint(SecondPointF,motionEvent);
                    State = STATE_ZOOM;
                    switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
                        case  MotionEvent.ACTION_MOVE:
                    }
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                State = STATE_NONE;
                if(State == STATE_NONE) {
                    MyScaleAnimation myScaleAnimation = new MyScaleAnimation(1f, 1f, 1f, 1f);
                    myScaleAnimation.StartAnimation(recyclerView);
                    if (row < 4) {
                        if(NewScale < 1 && row < 4)
                            row++;
                        if(NewScale < 0.5 && row < 4)
                            row++;
                    }
                    if (row > 2) {
                        if(NewScale > 1 && row > 2)
                            row--;
                        if(NewScale > 1.8 && row > 2)
                            row--;
                    }
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context,row);
                    recyclerView.setLayoutManager(layoutManager);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(State == STATE_ZOOM){
                    float NewDistance = Spacing(motionEvent);
                    if(NewDistance > 20f){
                        NewScale = NewDistance/Distance;
                        MyScaleAnimation myScaleAnimation = new MyScaleAnimation(NewScale,NewScale,NewScale,NewScale);
                        myScaleAnimation.StartAnimation(recyclerView);
                    }
                }
                break;
        }
        return false;
    }
}
