package com.walton.android.photowall.processer;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.DefaultOnSelectHeaderView;
import com.walton.android.photowall.view.DefaultPhotoWallCellHeaderView;
import com.walton.android.photowall.view.DefaultStaySelectionHeaderView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderViewCreator implements ViewCreator {
    private Context context;
    public HeaderViewCreator(Context context){
        this.context = context;
    }
    @Override
    public View createView(int status) {
        switch(status){
            case 1 :
                return new DefaultStaySelectionHeaderView(context);
            case 2 :
                return new DefaultOnSelectHeaderView(context);
            default:
                return new DefaultPhotoWallCellHeaderView(context);
        }
    }
}
