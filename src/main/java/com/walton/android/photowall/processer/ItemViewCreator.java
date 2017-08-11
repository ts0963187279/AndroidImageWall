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
    public ItemView createView(Status status) {
        switch (status){
            case STAYSELECT:
                return new DefaultStaySelectionItemView(context);
            case ONSELECT:
                return new DefaultOnSelectItemView(context);
            case VIEW:
                return new DefaultItemView(context);
        }
        return new DefaultItemView(context);
    }
}
