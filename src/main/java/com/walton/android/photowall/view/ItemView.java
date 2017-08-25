package com.walton.android.photowall.view;

import android.content.Context;
import android.widget.RelativeLayout;

import com.walton.android.photowall.model.SelectModData;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/28.
 */

public abstract class ItemView extends RelativeLayout{
    private ArrayList<String> pathList;
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
    public String getPath(){
        return pathList.get(absolutePosition);
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
    public void setPathList(ArrayList<String> pathList){
        this.pathList = pathList;
    }
    public ArrayList<String> getPathList(){
        return pathList;
    }
    public boolean isChecked(){return selectModData.isItemCheck(section,position);}
    public void setChecked(boolean isCheck){selectModData.setItemCheck(section,position,isCheck);}
    public abstract void setImagePath(String string);
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec),
                getDefaultSize(0, heightMeasureSpec));

        int childWidthSize = getMeasuredWidth();
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
