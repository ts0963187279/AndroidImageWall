package com.walton.android.photowall.processer;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
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
import com.walton.android.photowall.view.OnSelectHeaderView;
import com.walton.android.photowall.view.OnSelectItemView;
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
    private ArrayList<Uri> UriList;
    private Context context;
    private String[] header;
    private List<List<Uri>> URIS;
    private PhotoWallCellItemView photoWallCellItemView;
    private PhotoWallCellHeaderView photoWallCellHeaderView;
    private View.OnLongClickListener selectModHeaderLongClickListener;
    private View.OnClickListener selectModHeaderOnClickListener;
    private View.OnClickListener selectModItemOnClickListener;
    private View.OnLongClickListener selectModItemLongClickListener;
    private AppCompatActivity appCompatActivity;
    private View.OnClickListener itemViewOnClickListener;
    private View.OnClickListener itemViewOnDoubleClickListener;
    private View.OnClickListener headerViewOnDoubleClickListener;
    private SelectModData selectModData;
    private ItemViewGestureListener itemViewGestureDetectorListener;
    private ItemViewOnTouchListener itemViewOnTouchListener;
    private HeaderViewGestureListener headerViewGestureListener;
    private HeaderViewOnTouchListener headerViewOnTouchListener;
    private ViewCreator itemViewCreator,headerViewCreator;
    public PhotoWallAdapter(Context context, TreeMap<String,ArrayList<Uri>> UriTreeMap,AppCompatActivity appCompatActivity){
        Fresco.initialize(context);
        Iterator iterator;
        Object Key;
        this.appCompatActivity = appCompatActivity;
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
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UriList = new ArrayList<>();
        iterator = UriTreeMap.descendingKeySet().iterator();
        URIS = new ArrayList<>(UriTreeMap.size());
        header = new String[UriTreeMap.size()];
        for(int i =0;i<UriTreeMap.size();i++){
            Key = iterator.next();
            header[i] = Key.toString();
            List<Uri> URI = new ArrayList<>(UriTreeMap.get(Key).size());
            for(int j =0;j< UriTreeMap.get(Key).size();j++){
                Uri uri = UriTreeMap.get(Key).get(j);
                URI.add(uri);
                UriList.add(uri);
            }
            URIS.add(URI);
        }
    }
    public boolean isSelectMod(){
        return selectModData.isSelectMod();
    }
    public void ViewMod(){
        selectModData.clearChecked();
        notifyItemRangeChanged(0,UriList.size()+getSectionCount());
//        notifyDataSetChanged();
    }
    public void removeItem(){
        for(int i=0;i< selectModData.getSectionCount();i++){
            int deleteCount = 0;
            selectModData.headerOnChecked(i,false);
            for(int j=0;j< selectModData.getPositionCount(i);j++){
                if(selectModData.isItemCheck(i,j)) {
                    try {
                        URIS.get(i).remove(j - deleteCount);
                        selectModData.decCheckCount();
                        selectModData.setItemCheck(i, j, false);
                        notifySectionItemRemoved(i, j - deleteCount);
                        deleteCount++;
                    }catch (Exception e){
                        System.out.println("delete error");
                    }
                }
            }
        }
        UriList.clear();
        for(int i =0;i<URIS.size();i++) {
            for (int j = 0; j < URIS.get(i).size(); j++) {
                Uri uri = URIS.get(i).get(j);
                UriList.add(uri);
            }
        }
        selectModData.setSelectMod(false);
//        notifyItemRangeChanged(0,UriList.size()+getSectionCount());
        notifyDataSetChanged();
    }
    public void shareItem(){
        ArrayList<Uri> ImageUriList = new ArrayList<>();
        for(int i=0;i< URIS.size();i++){
            for(int j=0;j< URIS.get(i).size();j++){
                if(selectModData.isItemCheck(i,j)) {
                    ImageUriList.add(URIS.get(i).get(j));
                }
            }
        }
        ShareImage shareImage = new ShareImage(context, ImageUriList);
        shareImage.StartShare();
    }
    public void TitleOnChange(String title){
        appCompatActivity.setTitle(title);
//        notifyItemRangeChanged(0,UriList.size()+getSectionCount());
        notifyDataSetChanged();
    }
    public void setItemViewCreator(ViewCreator itemViewCreator){
        this.itemViewCreator = itemViewCreator;
    }
    public void setHeaderViewCreator(ViewCreator headerViewCreator){
        this.headerViewCreator = headerViewCreator;
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
        return selectModData.isHeaderCheck(section) ? 1:0;
    }
    @Override
    public int getSectionItemViewType(int section,int position){
        return selectModData.isItemCheck(section,position) ? 1:0;
    }
    @Override
    public int getSectionCount() {
        return URIS.size();
    }
    @Override
    public int getSectionItemCount(int section) {
        return URIS.get(section).size();
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        PhotoWallCellHeaderView view;
        if(headerType == 0)
            view = (PhotoWallCellHeaderView) headerViewCreator.createView();
        else
            view = new OnSelectHeaderView(context);
        return new PhotoWallHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        PhotoWallCellItemView view;
        if(itemType == 0)
            view = (PhotoWallCellItemView) itemViewCreator.createView();
        else
            view = new OnSelectItemView(context);
        return new PhotoWallItemViewHolder(view);
    }
    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int section) {
        final PhotoWallHeaderViewHolder holder = (PhotoWallHeaderViewHolder) viewHolder;
        final String label = header[section];
//        if(selectModData.isSectionAllCheck(section,getSectionItemCount(section))){
//            selectModData.setHeaderCheck(section,true);
//        }else{
//            selectModData.setHeaderCheck(section,false);
//        }
        if(selectModData.getCheckCount() == 0) {
            selectModData.setSelectMod(false);
        }else
            selectModData.setSelectMod(true);
        holder.photoWallCellHeaderView.setSelectModData(selectModData);
        holder.photoWallCellHeaderView.setSection(section);
        holder.photoWallCellHeaderView.setPadding(20,20,20,20);
        holder.photoWallCellHeaderView.setCheckBoxVisible(View.GONE);
        holder.photoWallCellHeaderView.setText(label);
        holder.photoWallCellHeaderView.setOnClickListener(null);
        if(selectModData.isSelectMod()){
            appCompatActivity.getSupportActionBar().show();
            if(selectModData.isHeaderCheck(section))
                holder.photoWallCellHeaderView.setChecked(true);
            else
                holder.photoWallCellHeaderView.setChecked(false);
            holder.photoWallCellHeaderView.setCheckBoxVisible(View.VISIBLE);
        }else{
            appCompatActivity.getSupportActionBar().hide();
            holder.photoWallCellHeaderView.setCheckBoxVisible(View.GONE);
        }
        holder.photoWallCellHeaderView.setOnTouchListener(headerViewOnTouchListener);
    }
    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section,final int position) {
        final PhotoWallItemViewHolder holder = (PhotoWallItemViewHolder) viewHolder;
        final Uri uri = URIS.get(section).get(position);
        int count = 0;
        for(int i =0;i<section;i++)
            count += getSectionItemCount(i);
        holder.photoWallCellView.setSelectModData(selectModData);
        holder.photoWallCellView.setPosition(position);
        holder.photoWallCellView.setAbsolutePosition(count + position);
        holder.photoWallCellView.setSection(section);
        holder.photoWallCellView.setUriList(UriList);
        holder.photoWallCellView.setImage(uri);
        holder.photoWallCellView.setPadding(0,0,0,0);
        if(selectModData.getCheckCount() == 0) {
            selectModData.setSelectMod(false);
            holder.photoWallCellView.setCheckBoxVisible(View.GONE);
        }else
            selectModData.setSelectMod(true);
        if(selectModData.isSelectMod()){
            appCompatActivity.getSupportActionBar().show();
            appCompatActivity.setTitle("已選取 "+String.valueOf(selectModData.getCheckCount()));
            if(selectModData.isItemCheck(section,position)){
                holder.photoWallCellView.setChecked(true);
                holder.photoWallCellView.setPadding(30,30,30,30);
            }else{
                holder.photoWallCellView.setChecked(false);
                holder.photoWallCellView.setPadding(0,0,0,0);
            }
            holder.photoWallCellView.setCheckBoxVisible(View.VISIBLE);
        }else{
            appCompatActivity.getSupportActionBar().hide();
        }
        holder.photoWallCellView.setOnTouchListener(itemViewOnTouchListener);
    }
}
