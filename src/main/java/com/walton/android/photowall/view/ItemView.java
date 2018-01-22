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
import android.widget.RelativeLayout;

import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.model.ItemViewData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class ItemView extends RelativeLayout{
    private List<ItemViewData> itemViewDataList;
    private int position;
    private int absolutePosition;
    private int section;
    private SelectModData selectModData;
    public ItemView(Context context) {
        super(context);
    }
    public void setAbsolutePosition(int absolutePosition){
        this.absolutePosition = absolutePosition;
    }
    public void setPosition(int position){this.position = position;
    }
    public void setSection(int section){ this.section = section; }
    public void setSelectModData(SelectModData selectModData){
        this.selectModData = selectModData;
    }
    public SelectModData getSelectModData(){
        return selectModData;
    }
    public int getSection(){
        return section;
    }
    public int getAbsolutePosition(){
        return absolutePosition;
    }
    public int getPosition(){
        return position;
    }
    public void setItemViewDataList(List<ItemViewData> itemViewDataList){
    	this.itemViewDataList = itemViewDataList;
    }
    public List<ItemViewData> getItemViewDataList(){
		return itemViewDataList;
    }
    public boolean isChecked(){return selectModData.isItemCheck(section,position);}
    public void setChecked(boolean isCheck){selectModData.setItemCheck(section,position,isCheck);}
    public abstract void setData(ItemViewData itemViewData);
}
