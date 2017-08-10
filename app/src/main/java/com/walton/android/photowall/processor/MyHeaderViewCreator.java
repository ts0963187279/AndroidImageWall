package com.walton.android.photowall.processor;

import android.content.Context;

import com.walton.android.photowall.processer.LabelViewCreator;
import com.walton.android.photowall.view.HeaderView;
import com.walton.android.photowall.view.MyHeaderView;
import com.walton.android.photowall.view.MyOnSelectHeaderView;
import com.walton.android.photowall.view.MyStaySelectionHeaderView;

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
                return new MyStaySelectionHeaderView(context);
            case 2 :
                return new MyOnSelectHeaderView(context);
            default:
                return new MyHeaderView(context);
        }
    }
}
