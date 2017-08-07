package com.walton.android.photowall.listener;

import android.view.View;
import android.widget.Toast;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWallCellItemView;

/**
 * Created by waltonmis on 2017/7/27.
 */

public class DefaultSelectModItemOnClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        int section = view.getSection();
        int position = view.getPosition();
        view.setChecked(!view.isChecked());
        if(view.isChecked()) {
            view.getSelectModData().setIsCheck(section,position,true);
            view.getSelectModData().incCheckCount();
        }else{
            view.getSelectModData().setIsCheck(section,position,false);
            view.getSelectModData().decCheckCount();
        }
        view.getSelectModData().adapterNotify();
    }
}
