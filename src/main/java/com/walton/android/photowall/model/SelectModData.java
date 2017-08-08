package com.walton.android.photowall.model;

import android.net.Uri;

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
    private int[] itemCheckCount;
    private boolean isSelectMod;
    private int checkCount;
    private PhotoWallAdapter photoWallAdapter;
    public SelectModData(TreeMap<String,ArrayList<Uri>> uriTreeMap,PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
        Iterator iterator;
        Object key;
        isCheck = new boolean[uriTreeMap.size()][];
        headerCheck = new boolean[uriTreeMap.size()];
        itemCheckCount = new int[uriTreeMap.size()];
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
            itemCheckCount[i] = 0;
            for(int j=0;j<isCheck[i].length;j++){
                isCheck[i][j] = false;
            }
        }
        checkCount = 0;
        isSelectMod = false;
    }
    public void headerOnChecked(int section,boolean checked){
        if(checked){
            for(int i=0;i<getPositionCount(section);i++){
                if(!isItemCheck(section,i)) {
                    incCheckCount();
                    itemCheckCount[section]++;
                }
                setItemCheck(section,i,true);
            }
            setHeaderCheck(section,checked);
            setSelectMod(true);
        }else{
            for(int i=0;i<getPositionCount(section);i++){
                if(isItemCheck(section,i)) {
                    decCheckCount();
                    itemCheckCount[section]--;
                }
                setItemCheck(section,i,false);
            }
            setHeaderCheck(section,checked);
            setSelectMod(false);
        }
    }
    public void setHeaderCheck(int section,boolean checked){
        headerCheck[section] = checked;
    }
    public boolean isItemCheck(int section,int position){
        return isCheck[section][position];
    }
    public void setItemCheck(int section,int position,boolean isCheck){
        if(isCheck)
            itemCheckCount[section]++;
        else
            itemCheckCount[section]--;
        this.isCheck[section][position] = isCheck;
    }
    public boolean isHeaderCheck(int section){
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
    public void setSelectMod(boolean isSelectMod){
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
    public boolean isSectionAllCheck(int section , int positionCount){
        if(itemCheckCount[section] == positionCount)
            return true;
        else
            return false;
    }
}
