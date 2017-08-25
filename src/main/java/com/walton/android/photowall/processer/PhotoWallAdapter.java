package com.walton.android.photowall.processer;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.walton.android.photowall.listener.DefaultHeaderDoubleClickListener;
import com.walton.android.photowall.listener.DefaultItemDoubleClickListener;
import com.walton.android.photowall.listener.DefaultSelectModHeaderLongClickListener;
import com.walton.android.photowall.listener.DefaultSelectModHeaderOnClickListener;
import com.walton.android.photowall.listener.DefaultSelectModItemLongClickListener;
import com.walton.android.photowall.listener.DefaultSelectModItemOnClickListener;
import com.walton.android.photowall.listener.HeaderViewGestureListener;
import com.walton.android.photowall.listener.HeaderViewOnTouchListener;
import com.walton.android.photowall.listener.ItemViewGestureListener;
import com.walton.android.photowall.listener.ItemViewOnTouchListener;
import com.walton.android.photowall.model.SelectModData;
import com.walton.android.photowall.view.DefaultHeaderView;
import com.walton.android.photowall.view.DefaultItemView;
import com.walton.android.photowall.view.HeaderView;
import com.walton.android.photowall.view.ItemView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class PhotoWallAdapter extends StickyHeaderGridAdapter {
    private ArrayList<String> pathList;
    private Context context;
    private String[] header;
    private List<List<String>> paths;
    private TreeMap<String,ArrayList<String>> pathTreeMap;
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
    private Comparator arrayListComparator;
    public PhotoWallAdapter(Context context, TreeMap<String,ArrayList<String>> pathTreeMap){
        Fresco.initialize(context);
        this.context = context;
        this.pathTreeMap = pathTreeMap;
        itemView = new DefaultItemView(context);
        headerView = new DefaultHeaderView(context);
        selectModHeaderLongClickListener = new DefaultSelectModHeaderLongClickListener();
        selectModHeaderOnClickListener = new DefaultSelectModHeaderOnClickListener();
        selectModItemLongClickListener = new DefaultSelectModItemLongClickListener();
        selectModItemOnClickListener = new DefaultSelectModItemOnClickListener();
        itemViewGestureDetectorListener = new ItemViewGestureListener();
        itemViewOnTouchListener = new ItemViewOnTouchListener();
        itemViewOnDoubleClickListener = new DefaultItemDoubleClickListener();
        headerViewGestureListener = new HeaderViewGestureListener();
        headerViewOnTouchListener = new HeaderViewOnTouchListener();
        headerViewOnDoubleClickListener = new DefaultHeaderDoubleClickListener();
        cellViewCreator = new ItemViewCreator(context);
        labelViewCreator = new HeaderViewCreator(context);
        upDateData(pathTreeMap);
    }
    public void upDateData(TreeMap<String,ArrayList<String>> pathTreeMap){
        selectModData = new SelectModData(pathTreeMap,this);
        pathList = new ArrayList<>();
        paths = new ArrayList<>(pathTreeMap.size());
        header = new String[pathTreeMap.size()];
        Object key;
        Iterator iterator;
        iterator = pathTreeMap.navigableKeySet().iterator();
        for(int i =0;i<pathTreeMap.size();i++){
            key = iterator.next();
            header[i] = key.toString();
            List<String> strs = new ArrayList<>(pathTreeMap.get(key).size());
            for(int j =0;j< pathTreeMap.get(key).size();j++){
                String str = pathTreeMap.get(key).get(j);
                strs.add(str);
                pathList.add(str);
            }
            paths.add(strs);
        }
        selectModData.setUriList(pathList);
        notifyDataSetChanged();

    }
    public boolean isSelectMod(){
        return selectModData.isSelectMod();
    }
    public void ViewMod(){
            selectModData.clearChecked();
//            notifyItemRangeChanged(0,pathList.size()+getSectionCount());
          notifyDataSetChanged();
    }
    public void removeItem(){
        for(int i=selectModData.getSectionCount()-1;i>=0;i--){
            selectModData.setHeaderCheck(i,false);
            for(int j=selectModData.getPositionCount(i)-1;j>=0;j--){
                if(selectModData.isItemCheck(i,j)) {
                    try {
                        paths.get(i).remove(j);
                        selectModData.setItemCheck(i, j, false);
                        selectModData.checkRemove(i, j);
                        notifySectionItemRemoved(i, j);
                    }catch (Exception e){
                        System.out.println("delete error");
                    }
                }
            }
        }
        pathList.clear();
        for(int i =0;i<paths.size();i++) {
            for (int j = 0; j < paths.get(i).size(); j++) {
                String str = paths.get(i).get(j);
                pathList.add(str);
            }
        }
        selectModData.setSelectMod(false);
        notifyItemRangeChanged(0,pathList.size()+getSectionCount());
        //notifyDataSetChanged();
    }
    public void shareItem(){
        ArrayList<String> imagePathList = new ArrayList<>();
        for(int i=0;i< paths.size();i++){
            for(int j=0;j< paths.get(i).size();j++){
                if(selectModData.isItemCheck(i,j)) {
                    imagePathList.add(paths.get(i).get(j));
                }
            }
        }
        ShareImage shareImage = new ShareImage(context, imagePathList);
        shareImage.StartShare();

    }
    public void TitleOnChange(String title){
        try {
            selectModToolBar.setTitle(title);
        }catch (Exception e){}
        notifyDataSetChanged();
    }
    public void setItemCellViewCreator(CellViewCreator cellViewCreator){
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
    public void setArrayListComparator(Comparator arrayListComparator){
        this.arrayListComparator = arrayListComparator;
    }
    public void sortHeader(){
        TreeMap<String,ArrayList<String>> pathTreeMapTmp = new TreeMap<>(treeMapComparator);
        Object key;Iterator iterator = pathTreeMap.navigableKeySet().iterator();
        while(iterator.hasNext()){
            key = iterator.next();
            pathTreeMapTmp.put((String)key,pathTreeMap.get(key));
        }
        paths.clear();
        pathList.clear();
        pathTreeMap = pathTreeMapTmp;
        upDateData(pathTreeMapTmp);
        notifyAllSectionsDataSetChanged();
    }
    public void sortArrayList(){
        for(int i=0;i<paths.size();i++){
            Collections.sort(paths.get(i),arrayListComparator);
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
        return paths.size();
    }
    @Override
    public int getSectionItemCount(int section) {
        return paths.get(section).size();
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        HeaderView view;
        switch(headerType) {
            case 2 :
                view = labelViewCreator.createView(Status.ONSELECT);
                break;
            case 1 :
                view = labelViewCreator.createView(Status.STAYSELECT);
                break;
            default:
                view = labelViewCreator.createView(Status.VIEW);
        }
        return new PhotoWallHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        ItemView view;
        switch(itemType) {
            case 2 :
                view =cellViewCreator.createView(Status.ONSELECT);
                break;
            case 1 :
                view =cellViewCreator.createView(Status.STAYSELECT);
                break;
            default:
                view =cellViewCreator.createView(Status.VIEW);
        }
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
        final String str = paths.get(section).get(position);
        int count = 0;
        for(int i =0;i<section;i++)
            count += getSectionItemCount(i);
        holder.photoWallCellView.setSelectModData(selectModData);
        holder.photoWallCellView.setPosition(position);
        holder.photoWallCellView.setAbsolutePosition(count + position);
        holder.photoWallCellView.setSection(section);
        holder.photoWallCellView.setPathList(pathList);
        holder.photoWallCellView.setImagePath(str);
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