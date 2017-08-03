package com.walton.android.photowall.model;

import android.net.Uri;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.walton.android.photowall.processer.PhotoWallAdapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/8/3.
 */

public class SelectModData {
    private boolean[][] isCheck;
    private boolean[] headerCheck;
    private boolean isSelectMod;
    private int checkCount;
    private PhotoWallAdapter photoWallAdapter;
    public SelectModData(TreeMap<String,ArrayList<Uri>> uriTreeMap,PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
        Iterator iterator;
        Object key;
        isCheck = new boolean[uriTreeMap.size()][];
        headerCheck = new boolean[uriTreeMap.size()];
        iterator = uriTreeMap.descendingKeySet().iterator();
        for(int i=0;i<uriTreeMap.size();i++) {
            key = iterator.next();
            isCheck[i] = new boolean[uriTreeMap.get(key).size()];
        }
    }
    public void adapterNotify(){
        photoWallAdapter.TitleOnChange("已選取 "+String.valueOf(checkCount));
    }
    public void clearChecked(){
        for(int i=0;i<isCheck.length;i++){
            headerCheck[i] = false;
            for(int j=0;j<isCheck[i].length;j++){
                isCheck[i][j] = false;
            }
        }
        checkCount = 0;
        isSelectMod = false;
    }
    public boolean isCheck(int section,int position){
        return isCheck[section][position];
    }
    public void setIsCheck(int section,int position,boolean isCheck){
        this.isCheck[section][position] = isCheck;
    }
    public void setHeaderCheck(int section,boolean isCheck){
        this.headerCheck[section] = isCheck;
    }
    public boolean getHeaderCheck(int section){
        return headerCheck[section];
    }
    public void incCheckCount(){
        checkCount++;
    }
    public void decCheckCount(){
        checkCount--;
    }
    public int getCheckCount(){
        return checkCount;
    }
    public void setIsSelectMod(boolean isSelectMod){
        this.isSelectMod = isSelectMod;
    }
    public boolean isSelectMod(){
        return isSelectMod;
    }
    public int getSectionCount(){
        return isCheck.length;
    }
    public int getPositionCount(int section){
        return isCheck[section].length;
    }
}
