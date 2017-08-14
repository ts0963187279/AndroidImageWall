package com.walton.android.photowall.processor;

import android.content.Context;

import com.walton.android.photowall.processer.LabelViewCreator;
import com.walton.android.photowall.view.HeaderView;
import com.walton.android.photowall.view.MyHeaderView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyHeaderViewCreator implements LabelViewCreator {
    Context context;
    public MyHeaderViewCreator(Context context){
        this.context = context;
    }
    @Override
    public HeaderView createView(int status) {
        return new MyHeaderView(context);
    }
}
