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
package com.walton.android.photowall.processor;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.walton.android.photowall.listener.*;
import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.view.HeaderView;
import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.DefaultHeaderView;
import com.walton.android.photowall.view.DefaultItemView;
import com.walton.android.photowall.model.ItemViewData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class PhotoWallAdapter extends StickyHeaderGridAdapter{
    private List<ItemViewData> itemViewDataList;
    private Context context;
    private String[] header;
    private List<List<ItemViewData>> itemViewDataSortList;
	private TreeMap<String,List<ItemViewData>> itemViewDataTreeMap;
    private ItemView itemView;
    private HeaderView headerView;
    private View.OnLongClickListener selectModHeaderLongClickListener;
    private View.OnClickListener selectModHeaderOnClickListener;
    private View.OnClickListener selectModItemOnClickListener;
    private View.OnLongClickListener selectModItemLongClickListener;
    private View.OnClickListener itemViewOnClickListener;
    private View.OnClickListener itemViewOnDoubleClickListener;
    private View.OnClickListener headerViewOnDoubleClickListener;
    private SelectModData selectModData;
    private ItemViewGestureListener itemViewGestureDetectorListener;
    private ItemViewOnTouchListener itemViewOnTouchListener;
    private HeaderViewGestureListener headerViewGestureListener;
    private HeaderViewOnTouchListener headerViewOnTouchListener;
    private CellViewCreator cellViewCreator;
    private LabelViewCreator labelViewCreator;
    private Toolbar viewModToolBar;
    private Toolbar selectModToolBar;
    private Comparator treeMapComparator;
    private Comparator listComparator;
	public PhotoWallAdapter(Context context){
        Fresco.initialize(context);
        this.context = context;
		itemViewDataTreeMap = new TreeMap<>();
        itemView = new DefaultItemView(context);
        headerView = new DefaultHeaderView(context);
        selectModHeaderLongClickListener = new SelectModHeaderLongClickListener();
        selectModHeaderOnClickListener = new SelectModHeaderOnClickListener();
        selectModItemLongClickListener = new SelectModItemLongClickListener();
        selectModItemOnClickListener = new SelectModItemOnClickListener();
        itemViewGestureDetectorListener = new ItemViewGestureListener();
        itemViewOnTouchListener = new ItemViewOnTouchListener();
        itemViewOnDoubleClickListener = new ItemDoubleClickListener();
		itemViewOnClickListener = new ItemViewOnClickListener();
        headerViewGestureListener = new HeaderViewGestureListener();
        headerViewOnTouchListener = new HeaderViewOnTouchListener();
        headerViewOnDoubleClickListener = new HeaderDoubleClickListener();
		cellViewCreator = new ItemViewCreator(context);
        labelViewCreator = new HeaderViewCreator(context);
    }
    public void setData(TreeMap<String,List<ItemViewData>> itemViewDataTreeMap){
		this.itemViewDataTreeMap = itemViewDataTreeMap;
		itemViewDataList = new ArrayList<>();
		itemViewDataSortList = new ArrayList<>(itemViewDataTreeMap.size());
		selectModData = new SelectModData(itemViewDataTreeMap,this);
		header = new String[itemViewDataTreeMap.size()];
		Iterator iterator;
		iterator = itemViewDataTreeMap.navigableKeySet().iterator();
		for(int i=0;i<itemViewDataTreeMap.size();i++){
			Object key = iterator.next();
			header[i] = key.toString();
			List<ItemViewData> itemViewDataListTmp = new ArrayList<>(itemViewDataTreeMap.get(key).size());
			for(int j=0;j<itemViewDataTreeMap.get(key).size();j++){
				ItemViewData itemViewData = itemViewDataTreeMap.get(key).get(j);
				itemViewDataListTmp.add(itemViewData);
				itemViewDataList.add(itemViewData);
			}
			itemViewDataSortList.add(itemViewDataListTmp);
		}
		notifyAllSectionsDataSetChanged();
    }
    public boolean isSelectMod(){
        return selectModData.isSelectMod();
    }
    public void ViewMod(){
		selectModData.clearChecked();
		notifyDataSetChanged();
    }
    public void removeItem(){
        for(int i=selectModData.getSectionCount()-1;i>=0;i--){
            selectModData.setHeaderCheck(i,false);
            for(int j=selectModData.getPositionCount(i)-1;j>=0;j--){
                if(selectModData.isItemCheck(i,j)) {
                    try {
                        itemViewDataSortList.get(i).remove(j);
                        selectModData.setItemCheck(i, j, false);
                        selectModData.checkRemove(i, j);
                        notifySectionItemRemoved(i, j);
                    }catch (Exception e){
                        System.out.println("delete error");
                    }
                }
            }
        }
        itemViewDataList.clear();
        for(int i =0;i<itemViewDataSortList.size();i++) {
            for (int j = 0; j < itemViewDataSortList.get(i).size(); j++) {
                ItemViewData itemViewData = itemViewDataSortList.get(i).get(j);
                itemViewDataList.add(itemViewData);
            }
        }
        selectModData.setSelectMod(false);
        notifyItemRangeChanged(0,itemViewDataList.size()+getSectionCount());
    }
    public void TitleOnChange(String title){
        try {
            selectModToolBar.setTitle(title);
        }catch (Exception e){}
        notifyDataSetChanged();
    }
    public void setItemViewCreator(CellViewCreator cellViewCreator){
        this.cellViewCreator = cellViewCreator;
    }
    public void setHeaderViewCreator(LabelViewCreator labelViewCreator){
        this.labelViewCreator = labelViewCreator;
    }
    public void setViewModToolBar(Toolbar viewModToolBar){
        this.viewModToolBar = viewModToolBar;
    }
    public void setSelectModToolBar(Toolbar selectModToolBar){
        this.selectModToolBar = selectModToolBar;
        selectModToolBar.setVisibility(View.GONE);
    }
    public void setItemViewOnClickListener(View.OnClickListener itemOnClickListener){
        this.itemViewOnClickListener = itemOnClickListener;
        itemViewGestureDetectorListener.setOnClickListener(this.itemViewOnClickListener);
        itemViewOnTouchListener.setGestureDetector(context,itemViewGestureDetectorListener);
    }
    public void setSelectModHeaderLongClickListener(View.OnLongClickListener selectModHeaderLongClickListener){
        this.selectModHeaderLongClickListener = selectModHeaderLongClickListener;
        headerViewGestureListener.setSelectModOnLongClickListener(this.selectModHeaderLongClickListener);
        headerViewOnTouchListener.setGestureDetector(context,headerViewGestureListener);
    }
    public void setSelectModHeaderOnClickListener(View.OnClickListener selectModHeaderOnClickListener){
        this.selectModHeaderOnClickListener = selectModHeaderOnClickListener;
        headerViewGestureListener.setSelectModOnClickListener(this.selectModHeaderOnClickListener);
        headerViewOnTouchListener.setGestureDetector(context,headerViewGestureListener);
    }
    public void setSelectModItemLongClickListener(View.OnLongClickListener selectModItemLongClickListener){
        this.selectModItemLongClickListener = selectModItemLongClickListener;
        itemViewGestureDetectorListener.setSelectModOnLongClickListener(this.selectModItemLongClickListener);
        itemViewOnTouchListener.setGestureDetector(context,itemViewGestureDetectorListener);
    }
    public void setSelectModItemOnClickListener(View.OnClickListener selectModItemOnClickListener){
        this.selectModItemOnClickListener = selectModItemOnClickListener;
        itemViewGestureDetectorListener.setSelectModOnClickListener(this.selectModItemOnClickListener);
        itemViewOnTouchListener.setGestureDetector(context,itemViewGestureDetectorListener);
    }
    public void setItemViewOnDoubleClickListener(View.OnClickListener itemViewOnDoubleClickListener){
        this.itemViewOnDoubleClickListener = itemViewOnDoubleClickListener;
        itemViewGestureDetectorListener.setDoubleOnClickListener(this.itemViewOnDoubleClickListener);
        itemViewOnTouchListener.setGestureDetector(context,itemViewGestureDetectorListener);
    }
    public void setHeaderViewOnDoubleClickListener(View.OnClickListener headerViewOnDoubleClickListener){
        this.headerViewOnDoubleClickListener = headerViewOnDoubleClickListener;
        headerViewGestureListener.setOnDoubleClickListener(this.headerViewOnDoubleClickListener);
        headerViewOnTouchListener.setGestureDetector(context,headerViewGestureListener);
    }
    public void setTreeMapComparator(Comparator treeMapComparator){
        this.treeMapComparator = treeMapComparator;
    }
    public void setListComparator(Comparator listComparator){
        this.listComparator = listComparator;
    }
    public void sortHeader(){
        TreeMap<String,List<ItemViewData>> itemViewDataTreeMapTmp = new TreeMap<>(treeMapComparator);
        Object key;Iterator iterator = itemViewDataTreeMap.navigableKeySet().iterator();
        while(iterator.hasNext()){
            key = iterator.next();
            itemViewDataTreeMapTmp.put((String)key,itemViewDataTreeMap.get(key));
        }
        itemViewDataSortList.clear();
        itemViewDataList.clear();
        itemViewDataTreeMap = itemViewDataTreeMapTmp;
        setData(itemViewDataTreeMapTmp);
        notifyAllSectionsDataSetChanged();
    }
    public void sortList(){
        for(int i=0;i<itemViewDataSortList.size();i++){
            Collections.sort(itemViewDataSortList.get(i),listComparator);
        }
        notifyDataSetChanged();
    }
    @Override
    public int getSectionHeaderViewType(int section){
        if(selectModData.isSectionAllCheck(section,getSectionItemCount(section))&&selectModData.isHeaderCheck(section) )
            return 2;
        if(isSelectMod())
            return 1;
        return 0;
    }
    @Override
    public int getSectionItemViewType(int section,int position){
        if(selectModData.isItemCheck(section,position))
            return 2;
        if(isSelectMod())
            return 1;
        return 0;
    }
    @Override
    public int getSectionCount() {
        if(itemViewDataSortList == null)
            return 0;
        return itemViewDataSortList.size();
    }
    @Override
    public int getSectionItemCount(int section) {
        return itemViewDataSortList.get(section).size();
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        HeaderView view =labelViewCreator.createView(headerType);
        return new PhotoWallHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        ItemView view =cellViewCreator.createView(itemType);
        return new PhotoWallItemViewHolder(view);
    }
    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int section) {
        final PhotoWallHeaderViewHolder holder = (PhotoWallHeaderViewHolder) viewHolder;
        final String label = header[section];
        if(selectModData.getCheckCount() == 0) {
            selectModData.setSelectMod(false);
        }else
            selectModData.setSelectMod(true);
        holder.headerView.setSelectModData(selectModData);
        holder.headerView.setSection(section);
        holder.headerView.setText(label);
        if(selectModData.isSelectMod()){
            if(selectModData.isHeaderCheck(section))
                holder.headerView.setChecked(true);
            else
                holder.headerView.setChecked(false);
        }
        holder.headerView.setOnTouchListener(headerViewOnTouchListener);
    }
    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section,final int position) {
        final PhotoWallItemViewHolder holder = (PhotoWallItemViewHolder) viewHolder;
        final ItemViewData itemViewData = itemViewDataSortList.get(section).get(position);
        int count = 0;
        for(int i =0;i<section;i++)
            count += getSectionItemCount(i);
        holder.photoWallCellView.setSelectModData(selectModData);
        holder.photoWallCellView.setPosition(position);
        holder.photoWallCellView.setAbsolutePosition(count + position);
        holder.photoWallCellView.setSection(section);
        holder.photoWallCellView.setItemViewDataList(itemViewDataList);
        holder.photoWallCellView.setData(itemViewData);
        if(selectModData.getCheckCount() == 0) {
            selectModData.setSelectMod(false);
        }else
            selectModData.setSelectMod(true);
        if(selectModData.isSelectMod()){
            if(selectModToolBar != null) {
                viewModToolBar.setVisibility(View.GONE);
                selectModToolBar.setVisibility(View.VISIBLE);
            }else if(viewModToolBar != null) {
                viewModToolBar.setVisibility(View.GONE);
            }
        }else{
            if(viewModToolBar != null) {
                selectModToolBar.setVisibility(View.GONE);
                viewModToolBar.setVisibility(View.VISIBLE);
            }else if(selectModToolBar != null) {
                selectModToolBar.setVisibility(View.GONE);
            }
        }
        holder.photoWallCellView.setOnTouchListener(itemViewOnTouchListener);
    }
}
