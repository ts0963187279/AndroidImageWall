package com.walton.android.photowall.app.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.processor.CellViewCreator;
import com.walton.android.photowall.app.view.MyNotSelectedItemView;
import com.walton.android.photowall.app.view.MyItemView;
import com.walton.android.photowall.app.view.MySelectedItemView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyItemViewCreator implements CellViewCreator {
    Context context;
    public MyItemViewCreator(Context context){
        this.context = context;
    }
    @Override
    public ItemView createView(int status) {
        switch (status){
            case 1:
                return new MySelectedItemView(context);
            case 2:
                return new MyNotSelectedItemView(context);
            default:
                return new MyItemView(context);
        }
    }
}
