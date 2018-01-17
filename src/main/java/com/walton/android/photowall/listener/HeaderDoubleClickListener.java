package com.walton.android.photowall.listener;

import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.HeaderView;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class HeaderDoubleClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        HeaderView view = (HeaderView)v;
        int section = view.getSection();
        ArrayList<Uri> uriList = view.getSelectModData().getUriList();
        ArrayList<ArrayList<Boolean>> isCheck = view.getSelectModData().getIsCheck();
        int k = 0;
        for(int i=0;i<section;i++){
            k += view.getSelectModData().getPositionCount(i);
        }
        for (int j = 0; j < isCheck.get(section).size(); j++) {
            if (uriList.get(k++).toString().indexOf(".jpg") != -1) {
                if(!view.getSelectModData().isItemCheck(section,j))
                    view.getSelectModData().setItemCheck(section, j, true);
            }else {
                if(view.getSelectModData().isItemCheck(section,j))
                    view.getSelectModData().setItemCheck(section, j, false);
            }
        }
        view.getSelectModData().adapterNotify();
    }
}
