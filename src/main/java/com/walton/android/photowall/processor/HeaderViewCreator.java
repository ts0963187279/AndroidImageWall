package com.walton.android.photowall.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.NotSelectedHeaderView;
import com.walton.android.photowall.view.DefaultHeaderView;
import com.walton.android.photowall.view.SelectedHeaderView;
import com.walton.android.photowall.view.HeaderView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderViewCreator implements LabelViewCreator {
    private Context context;
    public HeaderViewCreator(Context context){
        this.context = context;
    }
    @Override
    public HeaderView createView(int status) {
        switch(status){
            case 1 :
                return new SelectedHeaderView(context);
            case 2 :
                return new NotSelectedHeaderView(context);
            default:
                return new DefaultHeaderView(context);
        }
    }
}
