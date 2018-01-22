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
