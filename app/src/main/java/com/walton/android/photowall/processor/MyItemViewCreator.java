package com.walton.android.photowall.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.processer.CellViewCreator;
import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.MyOnSelectItemView;
import com.walton.android.photowall.view.MyItemView;
import com.walton.android.photowall.view.MyStaySelectionItemView;

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
                return new MyStaySelectionItemView(context);
            case 2:
                return new MyOnSelectItemView(context);
            default:
                return new MyItemView(context);
        }
    }
}
