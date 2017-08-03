package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class PhotoWallCellItemView extends RelativeLayout{
    private ArrayList<Uri> uriList;
    private int position;
    private int absolutePosition;
    private int section;
    public PhotoWallCellItemView(Context context) {
        super(context);
    }
    public abstract PhotoWallCellItemView getNew();
    public void setAbsolutePosition(int absolutePosition){
        this.absolutePosition = absolutePosition;
    }
    public void setPosition(int position){this.position = position;
    }
    public void setSection(int section){ this.section = section; }
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
    public abstract boolean isChecked();
    public abstract void setImage(Uri uri);
    public abstract void setPadding(int left, int top, int right, int bottom);
    public abstract void setChecked(boolean isCheck);
    public abstract void setCheckBoxVisible(int isVisible);
}
