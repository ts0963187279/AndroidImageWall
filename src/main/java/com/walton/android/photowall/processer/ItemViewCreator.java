package com.walton.android.photowall.processer;

import android.content.Context;

import com.walton.android.photowall.view.DefaultItemView;
import com.walton.android.photowall.view.DefaultOnSelectItemView;
import com.walton.android.photowall.view.DefaultStaySelectionItemView;
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
                return new DefaultStaySelectionItemView(context);
            case 2:
                return new DefaultOnSelectItemView(context);
            default:
                return new DefaultItemView(context);
        }
    }
}
