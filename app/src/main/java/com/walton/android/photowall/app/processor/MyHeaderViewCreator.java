package com.walton.android.photowall.app.processor;

import android.content.Context;

import com.walton.android.photowall.view.HeaderView;
import com.walton.android.photowall.processor.LabelViewCreator;
import com.walton.android.photowall.app.view.MyHeaderView;
import com.walton.android.photowall.app.view.MyNotSelectedHeaderView;
import com.walton.android.photowall.app.view.MySelectedHeaderView;

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
        switch(status){
            case 1 :
                return new MySelectedHeaderView(context);
            case 2 :
                return new MyNotSelectedHeaderView(context);
            default:
                return new MyHeaderView(context);
        }
    }
}
