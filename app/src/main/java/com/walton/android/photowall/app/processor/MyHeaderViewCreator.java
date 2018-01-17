package com.walton.android.photowall.app.processor;

import android.content.Context;

import com.walton.android.photowall.view.HeaderView;
import com.walton.android.photowall.processor.LabelViewCreator;
import com.walton.android.photowall.app.view.MyHeaderView;
import com.walton.android.photowall.app.view.MyOnSelectHeaderView;
import com.walton.android.photowall.app.view.MyStaySelectionHeaderView;

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
