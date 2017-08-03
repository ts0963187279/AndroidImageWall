package com.walton.android.photowall.processer;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

/**
 * Created by waltonmis on 2017/8/3.
 */

public class RecyclerViewOnChangeAnimation {
    RecyclerView recyclerView ;
    public RecyclerViewOnChangeAnimation(RecyclerView recyclerView){
        this.recyclerView = recyclerView;
    }
    public void setAnimationEnabled(boolean enabled){
        ((SimpleItemAnimator)recyclerView.getItemAnimator()).setSupportsChangeAnimations(enabled);
    }
}
