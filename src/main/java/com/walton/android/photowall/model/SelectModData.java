package com.walton.android.photowall.model;

import android.net.Uri;

import com.walton.android.photowall.processor.PhotoWallAdapter;
import com.walton.android.photowall.model.ItemViewData;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/8/3.
 */

public class SelectModData {
    private ArrayList<ArrayList<Boolean>> isCheck;
    private ArrayList<Uri> uriList;
    private boolean[] headerCheck;
    private int[] itemCheckCount;
    private boolean isSelectMod;
    private int checkCount;
    private PhotoWallAdapter photoWallAdapter;
    public SelectModData(TreeMap<String,List<ItemViewData>> uriTreeMap,PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
        Iterator iterator;
        Object key;
        isCheck = new ArrayList<>(uriTreeMap.size());
        headerCheck = new boolean[uriTreeMap.size()];
        itemCheckCount = new int[uriTreeMap.size()];
        iterator = uriTreeMap.navigableKeySet().iterator();
        for(int i=0;i<uriTreeMap.size();i++) {
            key = iterator.next();
            ArrayList<Boolean> tmpCheck = new ArrayList<>(uriTreeMap.get(key).size());
            for(int j=0;j<uriTreeMap.get(key).size();j++)
                tmpCheck.add(false);
            isCheck.add(tmpCheck);
        }
    }
    public void adapterNotify(){
        photoWallAdapter.TitleOnChange("已選取 "+String.valueOf(checkCount));
    }
    public void clearChecked(){
        for(int i=0;i<isCheck.size();i++){
            headerCheck[i] = false;
            itemCheckCount[i] = 0;
            for(int j=0;j<isCheck.get(i).size();j++){
                isCheck.get(i).set(j,false);
            }
        }
        checkCount = 0;
        isSelectMod = false;
    }
    public void headerOnChecked(int section,boolean checked){
        if(checked){
            for(int i=0;i<getPositionCount(section);i++){
                if(!isItemCheck(section,i)) {
                    setItemCheck(section,i,true);
                }
            }
            setHeaderCheck(section,true);
            setSelectMod(true);
        }else{
            for(int i=0;i<getPositionCount(section);i++){
                if(isItemCheck(section,i)) {
                    setItemCheck(section,i,false);
                }
            }
            setHeaderCheck(section,false);
            setSelectMod(false);
        }
    }
    public void setHeaderCheck(int section,boolean checked){
        headerCheck[section] = checked;
    }
    public boolean isItemCheck(int section,int position){
        return isCheck.get(section).get(position);
    }
    public void setItemCheck(int section,int position,boolean isCheck){
        if(isCheck) {
            itemCheckCount[section]++;
            incCheckCount();
        }else {
            itemCheckCount[section]--;
            decCheckCount();
        }
            this.isCheck.get(section).set(position, isCheck);
    }
    public ArrayList<ArrayList<Boolean>> getIsCheck(){
        return isCheck;
    }
    public void checkRemove(int section,int position){
        isCheck.get(section).remove(position);
    }
    public void setUriList(ArrayList<Uri> uriList){
        this.uriList = uriList;
    }
    public ArrayList<Uri> getUriList(){
        return uriList;
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
        return isCheck.size();
    }
    public int getPositionCount(int section){
        return isCheck.get(section).size();
    }
    public boolean isSectionAllCheck(int section , int positionCount){
        if(itemCheckCount[section] == positionCount) {
            setHeaderCheck(section,true);
            return true;
        }else {
            setHeaderCheck(section,false);
            return false;
        }
    }
}
