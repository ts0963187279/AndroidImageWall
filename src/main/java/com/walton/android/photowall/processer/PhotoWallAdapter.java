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
import com.walton.android.photowall.view.DefaultPhotoWallCellHeaderView;
import com.walton.android.photowall.view.DefaultPhotoWallCellItemView;
import com.walton.android.photowall.view.PhotoWallCellHeaderView;
import com.walton.android.photowall.view.PhotoWallCellItemView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class PhotoWallAdapter extends StickyHeaderGridAdapter {
    private ArrayList<Uri> uriList;
    private Context context;
    private String[] header;
    private List<List<Uri>> uris;
    private PhotoWallCellItemView photoWallCellItemView;
    private PhotoWallCellHeaderView photoWallCellHeaderView;
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
    private ViewCreator itemViewCreator,headerViewCreator;
    private Toolbar viewModToolBar;
    private Toolbar selectModToolBar;
    public PhotoWallAdapter(Context context, TreeMap<String,ArrayList<Uri>> UriTreeMap){
        Fresco.initialize(context);
        Iterator iterator;
        Object Key;
        this.context = context;
        photoWallCellItemView = new DefaultPhotoWallCellItemView(context);
        photoWallCellHeaderView = new DefaultPhotoWallCellHeaderView(context);
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
        itemViewCreator = new ItemViewCreator(context);
        headerViewCreator = new HeaderViewCreator(context);
        selectModData = new SelectModData(UriTreeMap,this);
        uriList = new ArrayList<>();
        iterator = UriTreeMap.navigableKeySet().iterator();
        uris = new ArrayList<>(UriTreeMap.size());
        header = new String[UriTreeMap.size()];
        for(int i =0;i<UriTreeMap.size();i++){
            Key = iterator.next();
            header[i] = Key.toString();
            List<Uri> URI = new ArrayList<>(UriTreeMap.get(Key).size());
            for(int j =0;j< UriTreeMap.get(Key).size();j++){
                Uri uri = UriTreeMap.get(Key).get(j);
                URI.add(uri);
                uriList.add(uri);
            }
            uris.add(URI);
        }
        selectModData.setUriList(uriList);
    }
    public boolean isSelectMod(){
        return selectModData.isSelectMod();
    }
    public void ViewMod(){
            selectModData.clearChecked();
            notifyItemRangeChanged(0,uriList.size()+getSectionCount());
//          notifyDataSetChanged();
    }
    public void removeItem(){
        for(int i=selectModData.getSectionCount()-1;i>=0;i--){
            int deleteCount = 0;
            selectModData.setHeaderCheck(i,false);
            for(int j=selectModData.getPositionCount(i)-1;j>=0;j--){
                if(selectModData.isItemCheck(i,j)) {
                    try {
                        uris.get(i).remove(j);
                        selectModData.decCheckCount();
                        selectModData.setItemCheck(i, j, false);
                        selectModData.checkRemove(i, j);
                        notifySectionItemRemoved(i, j);
                        deleteCount++;
                    }catch (Exception e){
                        System.out.println("delete error");
                    }
                }
            }
        }
        uriList.clear();
        for(int i =0;i<uris.size();i++) {
            for (int j = 0; j < uris.get(i).size(); j++) {
                Uri uri = uris.get(i).get(j);
                uriList.add(uri);
            }
        }
        selectModData.setSelectMod(false);
        notifyItemRangeChanged(0,uriList.size()+getSectionCount());
        //notifyDataSetChanged();
    }
    public void shareItem(){
        ArrayList<Uri> ImageUriList = new ArrayList<>();
        for(int i=0;i< uris.size();i++){
            for(int j=0;j< uris.get(i).size();j++){
                if(selectModData.isItemCheck(i,j)) {
                    ImageUriList.add(uris.get(i).get(j));
                }
            }
        }
        ShareImage shareImage = new ShareImage(context, ImageUriList);
        shareImage.StartShare();
    }
    public void TitleOnChange(String title){
        try {
            selectModToolBar.setTitle(title);
        }catch (Exception e){}
            notifyDataSetChanged();
    }
    public void setItemViewCreator(ViewCreator itemViewCreator){
        this.itemViewCreator = itemViewCreator;
    }
    public void setHeaderViewCreator(ViewCreator headerViewCreator){
        this.headerViewCreator = headerViewCreator;
    }
    public void setViewModToolBar(Toolbar viewModToolBar){
        this.viewModToolBar = viewModToolBar;
    }
    public void setSelectModToolBar(Toolbar selectModToolBar){
        this.selectModToolBar = selectModToolBar;
        selectModToolBar.setTitle("");
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
    @Override
    public int getSectionHeaderViewType(int section){
        if(selectModData.isHeaderCheck(section) || selectModData.isSectionAllCheck(section,getSectionItemCount(section)))
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
        return uris.size();
    }
    @Override
    public int getSectionItemCount(int section) {
        return uris.get(section).size();
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        PhotoWallCellHeaderView view = (PhotoWallCellHeaderView) headerViewCreator.createView(headerType);
        return new PhotoWallHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        PhotoWallCellItemView view = (PhotoWallCellItemView) itemViewCreator.createView(itemType);
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
        holder.photoWallCellHeaderView.setSelectModData(selectModData);
        holder.photoWallCellHeaderView.setSection(section);
        holder.photoWallCellHeaderView.setText(label);
        if(selectModData.isSelectMod()){
            if(selectModData.isHeaderCheck(section))
                holder.photoWallCellHeaderView.setChecked(true);
            else
                holder.photoWallCellHeaderView.setChecked(false);
        }
        holder.photoWallCellHeaderView.setOnTouchListener(headerViewOnTouchListener);
    }
    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section,final int position) {
        final PhotoWallItemViewHolder holder = (PhotoWallItemViewHolder) viewHolder;
        final Uri uri = uris.get(section).get(position);
        int count = 0;
        for(int i =0;i<section;i++)
            count += getSectionItemCount(i);
        holder.photoWallCellView.setSelectModData(selectModData);
        holder.photoWallCellView.setPosition(position);
        holder.photoWallCellView.setAbsolutePosition(count + position);
        holder.photoWallCellView.setSection(section);
        holder.photoWallCellView.setUriList(uriList);
        holder.photoWallCellView.setImageUri(uri);
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
