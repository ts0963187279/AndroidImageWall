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
package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.model.HeaderViewData;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class HeaderView extends LinearLayout{
    private int section;
    private SelectModData selectModData;
    public HeaderView(Context context) {
        super(context);
    }
    public void setSection(int section) {
        this.section = section;
    }
    public int getSection(){
        return section;
    }
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public SelectModData getSelectModData(){
        return selectModData;
    }
    public void setChecked(boolean isCheck){selectModData.setHeaderCheck(section,isCheck);}
    public boolean isChecked(){return selectModData.isHeaderCheck(section);}
    public abstract void setData(HeaderViewData headerViewData);
}
