package com.walton.android.photowall.listener;

import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.PhotoWallCellItemView;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class DefaultItemDoubleClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        PhotoWallCellItemView view = (PhotoWallCellItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().incCheckCount();
//        ArrayList<Uri> uriList = view.getUriList();
//        boolean[][] isCheck = view.getSelectModData().getIsCheck();
//        int k = 0;
//        for(int i=0;i<isCheck.length;i++){
//            for(int j=0;j<isCheck[i].length;j++){
//                if(uriList.get(k++).toString().indexOf(".jpg") != -1){
//                    System.out.println(i + " " + j +" "+"is jpg");
//                    view.getSelectModData().setItemCheck(i,j,true);
//                    view.getSelectModData().incCheckCount();
//                }
//            }
//        }
        view.getSelectModData().adapterNotify();
    }
}
