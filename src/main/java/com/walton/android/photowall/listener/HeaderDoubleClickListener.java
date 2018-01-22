/*
 * Copyright (C) 2017 RS Wong <ts0963187279@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
