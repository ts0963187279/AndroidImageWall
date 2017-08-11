package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.DefaultOnSelectHeaderView;
import com.walton.android.photowall.view.DefaultHeaderView;
import com.walton.android.photowall.view.DefaultStaySelectionHeaderView;
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
    public HeaderView createView(Status status) {
        switch(status){
            case STAYSELECT:
                return new DefaultStaySelectionHeaderView(context);
            case ONSELECT:
                return new DefaultOnSelectHeaderView(context);
            case VIEW:
                return new DefaultHeaderView(context);
        }
        return new DefaultHeaderView(context);
    }
}
