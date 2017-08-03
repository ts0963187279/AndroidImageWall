package com.walton.android.photowall.processer;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.walton.android.photowall.listener.DefaultSelectModHeaderLongClickListener;
import com.walton.android.photowall.listener.DefaultSelectModHeaderOnClickListener;
import com.walton.android.photowall.listener.DefaultSelectModItemLongClickListener;
import com.walton.android.photowall.listener.DefaultSelectModItemOnClickListener;
import com.walton.android.photowall.listener.SelectModHeaderLongClickListener;
import com.walton.android.photowall.listener.SelectModHeaderOnClickListener;
import com.walton.android.photowall.listener.SelectModItemLongClickListener;
import com.walton.android.photowall.listener.SelectModItemOnClickListener;
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
    private SelectModHeaderLongClickListener selectModHeaderLongClickListener;
    private SelectModHeaderOnClickListener selectModHeaderOnClickListener;
    private SelectModItemOnClickListener selectModItemOnClickListener;
    private SelectModItemLongClickListener selectModItemLongClickListener;
    private AppCompatActivity appCompatActivity;
    private View.OnClickListener goToImageGalleryOnClickListener;
    private SelectModData selectModData;
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
                    URIS.get(i).remove(j-deleteCount);
                    selectModData.decCheckCount();
                    selectModData.setIsCheck(i,j,false);
                    notifySectionItemRemoved(i,j - deleteCount);
                    deleteCount++;
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
    public void setItemView(PhotoWallCellItemView photoWallCellItemView){
        this.photoWallCellItemView = photoWallCellItemView;
    }
    public void setHeaderView(PhotoWallCellHeaderView photoWallCellHeaderView){
        this.photoWallCellHeaderView = photoWallCellHeaderView;
    }
    public void setGoToImageGalleryClickListener(View.OnClickListener goToImageGalleryOnClickListener){
        this.goToImageGalleryOnClickListener = goToImageGalleryOnClickListener;
    }
    public void setSelectModHeaderLongClickListener(SelectModHeaderLongClickListener selectModHeaderLongClickListener){
        this.selectModHeaderLongClickListener = selectModHeaderLongClickListener;
    }
    public void setSelectModHeaderOnClickListener(SelectModHeaderOnClickListener selectModHeaderOnClickListener){
        this.selectModHeaderOnClickListener = selectModHeaderOnClickListener;
    }
    public void setSelectModItemLongClickListener(SelectModItemLongClickListener selectModItemLongClickListener){
        this.selectModItemLongClickListener = selectModItemLongClickListener;
    }
    public void setSelectModItemOnClickListener(SelectModItemOnClickListener selectModItemOnClickListener){
        this.selectModItemOnClickListener = selectModItemOnClickListener;
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
        final PhotoWallCellHeaderView view = photoWallCellHeaderView.getNew();
        return new PhotoWallHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        final PhotoWallCellItemView view = photoWallCellItemView.getNew();
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
            selectModHeaderOnClickListener.setSelectModData(selectModData);
            holder.photoWallCellHeaderView.setOnClickListener(selectModHeaderOnClickListener);
        }else{
            appCompatActivity.getSupportActionBar().hide();
            holder.photoWallCellHeaderView.setCheckBoxVisible(View.GONE);
            selectModHeaderLongClickListener.setSelectModData(selectModData);
            holder.photoWallCellHeaderView.setOnLongClickListener(selectModHeaderLongClickListener);
        }
    }
    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section,final int position) {
        final PhotoWallItemViewHolder holder = (PhotoWallItemViewHolder) viewHolder;
        final Uri uri = URIS.get(section).get(position);
        int count = 0;
        for(int i =0;i<section;i++)
            count += itemCount[i];
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
            selectModItemOnClickListener.setSelectModData(selectModData);
            holder.photoWallCellView.setOnClickListener(selectModItemOnClickListener);
        }else{
            appCompatActivity.getSupportActionBar().hide();
            holder.photoWallCellView.setOnClickListener(goToImageGalleryOnClickListener);
            selectModItemLongClickListener.setSelectModData(selectModData);
            holder.photoWallCellView.setOnLongClickListener(selectModItemLongClickListener);
        }
    }
}
