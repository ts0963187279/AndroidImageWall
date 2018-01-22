package com.walton.android.photowall.processor;

import android.content.Context;

import com.walton.android.photowall.view.DefaultItemView;
import com.walton.android.photowall.view.NotSelectedItemView;
import com.walton.android.photowall.view.SelectedItemView;
import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class ItemViewCreator implements CellViewCreator {
    private Context context;
    public ItemViewCreator(Context context) {
        this.context = context;
    }
    @Override
    public ItemView createView(int status) {
        switch (status){
            case 1:
                return new SelectedItemView(context);
            case 2:
                return new NotSelectedItemView(context);
            default:
                return new DefaultItemView(context);
        }
    }
}
