package com.walton.android.photowall.listener;


import android.support.v7.widget.RecyclerView;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by waltonmis on 2017/7/18.
 */

public class MyOnScrollListener extends RecyclerView.OnScrollListener {
    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        Log.i(TAG, "-----------onScrollStateChanged-----------");
        Log.i(TAG, "newState: " + newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        Log.i(TAG, "-----------onScrolled-----------");
        Log.i(TAG, "dx: " + dx);
        Log.i(TAG, "dy: " + dy);
    }
}
