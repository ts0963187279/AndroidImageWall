package com.walton.android.photowall.listener;

import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellHeaderView;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class MyHeaderDoubleClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView)v;
        int section = view.getSection();
        ArrayList<Uri> uriList = view.getSelectModData().getUriList();
        ArrayList<ArrayList<Boolean>> isCheck = view.getSelectModData().getIsCheck();
        int k = 0;
        for(int i=0;i<section;i++){
            k += view.getSelectModData().getPositionCount(i);
        }
        for (int j = 0; j < isCheck.get(section).size(); j++) {
            if (uriList.get(k++).toString().indexOf(".jpg") != -1) {
                view.getSelectModData().setItemCheck(section, j, true);
                view.getSelectModData().incCheckCount();
            }
        }
        view.getSelectModData().adapterNotify();
    }
}
