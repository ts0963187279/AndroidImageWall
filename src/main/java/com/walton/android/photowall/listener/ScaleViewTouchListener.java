package com.walton.android.photowall.listener;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

import com.walton.android.photowall.processer.RecyclerViewAdapter;
import com.walton.android.photowall.processer.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.view.MyAnimation;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class ScaleViewTouchListener implements RecyclerView.OnItemTouchListener {
    private boolean isPointerDown = false;
    private int[] TitlePosition;
    private PointF SecondPointF = new PointF();
    private float Distance =1f;
    private static final int STATE_NONE = 0;
    private static final int STATE_ZOOM =1;
    private int State = STATE_NONE;
    private float NewScale;
    private Context context;
    private int row = 4;
    private RecyclerViewAdapter adapter;
    public ScaleViewTouchListener(Context context, RecyclerViewAdapter adapter){
        this.context = context;
        this.adapter = adapter;
    }
    public void setTitlePosition(int[] TitlePosition){
        this.TitlePosition = TitlePosition;
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
                Log.d("Intercept","STATE_ZOOM");
                State = STATE_ZOOM;
            }
            isPointerDown = false;
        }
        switch(motionEvent.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_POINTER_UP:
                if(State == STATE_ZOOM) {
                    MyAnimation myAnimation = new MyAnimation(1f, 1f, 1f, 1f);
                    myAnimation.StartScaleAnimation(recyclerView);
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
                    int scrollPosition = adapter.getScrollPosition();
                    StickyHeaderGridLayoutManager layoutManager = new StickyHeaderGridLayoutManager(row);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter.UpdateView(row,scrollPosition,layoutManager);
                    adapter.notifyDataSetChanged();
                    State = STATE_NONE;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("Intercept","Action_move onTouch");
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
