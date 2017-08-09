package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.widget.RelativeLayout;

import com.walton.android.photowall.model.SelectModData;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class PhotoWallCellItemView extends RelativeLayout{
    private ArrayList<Uri> uriList;
    private int position;
    private int absolutePosition;
    private int section;
    private SelectModData selectModData;
    public PhotoWallCellItemView(Context context) {
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
    public Uri getUri(){
        return uriList.get(absolutePosition);
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
    public void setUriList(ArrayList<Uri> uriList){
        this.uriList = uriList;
    }
    public ArrayList<Uri> getUriList(){
        return uriList;
    }
    public boolean isChecked(){return selectModData.isItemCheck(section,position);}
    public void setChecked(boolean isCheck){selectModData.setItemCheck(section,position,isCheck);}
    public abstract void setImageUri(Uri uri);
}
