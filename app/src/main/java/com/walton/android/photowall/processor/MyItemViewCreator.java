package com.walton.android.photowall.processor;

import android.content.Context;

import com.walton.android.photowall.processer.CellViewCreator;
import com.walton.android.photowall.processer.Status;
import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.MyMusicView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyItemViewCreator implements CellViewCreator {
    Context context;
    public MyItemViewCreator(Context context){
        this.context = context;
    }
    @Override
    public ItemView createView(Status status) {
        return new MyMusicView(context);
    }
}
