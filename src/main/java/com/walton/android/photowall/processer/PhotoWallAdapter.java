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
    private int itemCount[];
    private List<List<Uri>> URIS;
    private PhotoWallCellItemView photoWallCellItemView;
    private PhotoWallCellHeaderView photoWallCellHeaderView;
    private View.OnLongClickListener selectModHeaderLongClickListener;
    private View.OnClickListener selectModHeaderOnClickListener;
    private View.OnClickListener selectModItemOnClickListener;
    private View.OnLongClickListener selectModItemLongClickListener;
    private AppCompatActivity appCompatActivity;
    private View.OnClickListener imageGalleryOnClickListener;
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
        setHasStableIds(false);
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        UriList = new ArrayList<>();
        iterator = UriTreeMap.descendingKeySet().iterator();
        URIS = new ArrayList<>(UriTreeMap.size());
        itemCount = new int[UriTreeMap.size()];
        header = new String[UriTreeMap.size()];
        for(int i =0;i<UriTreeMap.size();i++){
            itemCount[i] = 0;
            Key = iterator.next();
            header[i] = Key.toString();
            List<Uri> URI = new ArrayList<>(UriTreeMap.get(Key).size());
            for(int j =0;j< UriTreeMap.get(Key).size();j++){
                Uri uri = UriTreeMap.get(Key).get(j);
                itemCount[i]++;
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
    }
    public void removeItem(){
        for(int i=0;i< selectModData.getSectionCount();i++){
            int deleteCount = 0;
            selectModData.setHeaderCheck(i,false);
            for(int j=0;j< selectModData.getPositionCount(i);j++){
                if(selectModData.isCheck(i,j)) {
                    try {
                        URIS.get(i).remove(j - deleteCount);
                        selectModData.decCheckCount();
                        selectModData.setIsCheck(i, j, false);
                        notifySectionItemRemoved(i, j - deleteCount);
                        deleteCount++;
                    }catch (Exception e){
                        System.out.println("delete error");
                    }
                }
            }
        }
        UriList.clear();
        itemCount = new int[getSectionCount()];
        for(int i =0;i<URIS.size();i++) {
            itemCount[i] = 0;
            for (int j = 0; j < URIS.get(i).size(); j++) {
                itemCount[i]++;
                Uri uri = URIS.get(i).get(j);
                UriList.add(uri);
            }
        }
        selectModData.setIsSelectMod(false);
        notifyItemRangeChanged(0,UriList.size()+getSectionCount());
    }
    public void shareItem(){
        ArrayList<Uri> ImageUriList = new ArrayList<>();
        for(int i=0;i< URIS.size();i++){
            for(int j=0;j< URIS.get(i).size();j++){
                if(selectModData.isCheck(i,j)) {
                    ImageUriList.add(URIS.get(i).get(j));
                }
            }
        }
        ShareImage shareImage = new ShareImage(context, ImageUriList);
        shareImage.StartShare();
    }
    public void TitleOnChange(String title){
        appCompatActivity.setTitle(title);
        notifyItemRangeChanged(0,UriList.size()+getSectionCount());
    }
    public void setItemViewCreator(ViewCreator itemViewCreator){
        this.itemViewCreator = itemViewCreator;
    }
    public void setHeaderViewCreator(ViewCreator headerViewCreator){
        this.headerViewCreator = headerViewCreator;
    }
    public void setImageGalleryClickListener(View.OnClickListener imageGalleryOnClickListener){
        this.imageGalleryOnClickListener = imageGalleryOnClickListener;
        itemViewGestureDetectorListener.setOnClickListener(this.imageGalleryOnClickListener);
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
    public int getSectionCount() {
        return URIS.size();
    }
    @Override
    public int getSectionItemCount(int section) {
        return URIS.get(section).size();
    }
    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        final PhotoWallCellHeaderView view  = (PhotoWallCellHeaderView) headerViewCreator.getView();
        return new PhotoWallHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        final PhotoWallCellItemView view = (PhotoWallCellItemView) itemViewCreator.getView();
        return new PhotoWallItemViewHolder(view);
    }
    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int section) {
        final PhotoWallHeaderViewHolder holder = (PhotoWallHeaderViewHolder) viewHolder;
        final String label = header[section];
        if(selectModData.getCheckCount() == 0) {
            selectModData.setIsSelectMod(false);
        }else
            selectModData.setIsSelectMod(true);
        holder.photoWallCellHeaderView.setSelectModData(selectModData);
        holder.photoWallCellHeaderView.setSection(section);
        holder.photoWallCellHeaderView.setPadding(20,20,20,20);
        holder.photoWallCellHeaderView.setCheckBoxVisible(View.GONE);
        holder.photoWallCellHeaderView.setText(label);
        holder.photoWallCellHeaderView.setOnClickListener(null);
        if(selectModData.isSelectMod()){
            appCompatActivity.getSupportActionBar().show();
            if(selectModData.getHeaderCheck(section))
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
            count += itemCount[i];
        holder.photoWallCellView.setSelectModData(selectModData);
        holder.photoWallCellView.setPosition(position);
        holder.photoWallCellView.setAbsolutePosition(count + position);
        holder.photoWallCellView.setSection(section);
        holder.photoWallCellView.setUriList(UriList);
        holder.photoWallCellView.setImage(uri);
        holder.photoWallCellView.setPadding(0,0,0,0);
        if(selectModData.getCheckCount() == 0) {
            selectModData.setIsSelectMod(false);
            holder.photoWallCellView.setCheckBoxVisible(View.GONE);
        }else
            selectModData.setIsSelectMod(true);
        if(selectModData.isSelectMod()){
            appCompatActivity.getSupportActionBar().show();
            appCompatActivity.setTitle("已選取 "+String.valueOf(selectModData.getCheckCount()));
            if(selectModData.isCheck(section,position)){
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
