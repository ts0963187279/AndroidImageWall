package com.walton.android.photowall.processer;

import android.content.Context;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;
import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.listener.ExitSelectModListener;
import com.walton.android.photowall.listener.SelectAllLongClickListener;
import com.walton.android.photowall.listener.SelectAllOnClickListener;
import com.walton.android.photowall.listener.SelectModItemLongClickListener;
import com.walton.android.photowall.listener.SelectModItemOnClickListener;
import com.walton.android.photowall.listener.goToImageGalleryOnClickListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class PhotoWallAdapter extends StickyHeaderGridAdapter {
    private ArrayList<Uri> UriList;
    private Context context;
    private RecyclerView recyclerView;
    private StickyHeaderGridLayoutManager layoutManager;
    private Object Key;
    private Iterator iterator;
    private String[] header;
    private int itemCount[];
    private TreeMap<String,ArrayList<Uri>> UriTreeMap;
    private boolean[][] isCheck;
    private List<List<Uri>> URIS;
    private int CheckCount = 0;
    private boolean selectMod = false;
    private int row = 0;
    private boolean[] headerCheck;
    private int[] headerCheckCounter;
    private AppCompatActivity appCompatActivity;
    public PhotoWallAdapter(Context context, TreeMap<String,ArrayList<Uri>> UriTreeMap, RecyclerView recyclerView, int row, AppCompatActivity appCompatActivity){
        this.recyclerView = recyclerView;
        this.appCompatActivity = appCompatActivity;
        this.context = context;
        this.UriTreeMap =UriTreeMap;
        this.row = row;
        headerCheck = new boolean[UriTreeMap.size()];
        UriList = new ArrayList<>();
        iterator = UriTreeMap.descendingKeySet().iterator();
        URIS = new ArrayList<>(UriTreeMap.size());
        itemCount = new int[UriTreeMap.size()];
        isCheck = new boolean[UriTreeMap.size()][];
        header = new String[UriTreeMap.size()];
        for(int i =0;i<UriTreeMap.size();i++){
            itemCount[i] = 0;
            headerCheck[i] = false;
            Key = iterator.next();
            header[i] = Key.toString();
            List<Uri> URI = new ArrayList<>(UriTreeMap.get(Key).size());
            isCheck[i] = new boolean[UriTreeMap.get(Key).size()];
            for(int j =0;j< UriTreeMap.get(Key).size();j++){
                Uri uri = UriTreeMap.get(Key).get(j);
                itemCount[i]++;
                isCheck[i][j] = false;
                URI.add(uri);
                UriList.add(uri);
            }
            URIS.add(URI);
        }
        layoutManager = new StickyHeaderGridLayoutManager(row);
        recyclerView.setLayoutManager(layoutManager);
    }
    public int getRow(){
        return row;
    }
    public void ViewMode(){
        for (int i = 0; i < isCheck.length; i++) {
            headerCheck[i] = false;
            for (int j = 0; j < isCheck[i].length; j++) {
                isCheck[i][j] = false;
            }
        }
        CheckCount = 0;
        selectMod = false;
        notifyDataSetChanged();
    }
    public void removeItem(){
        for(int i=0;i< isCheck.length;i++){
            int deleteCount = 0;
            headerCheck[i] = false;
            for(int j=0;j< isCheck[i].length;j++){
                if(isCheck[i][j]) {
                    URIS.get(i).remove(j-deleteCount);
                    CheckCount--;
                    isCheck[i][j] = false;
                    notifySectionItemRemoved(i,j - deleteCount);
                    deleteCount++;
                }
            }
        }
        UriList.clear();
        itemCount = new int[UriTreeMap.size()];
        for(int i =0;i<URIS.size();i++) {
            itemCount[i] = 0;
            for (int j = 0; j < URIS.get(i).size(); j++) {
                itemCount[i]++;
                Uri uri = URIS.get(i).get(j);
                UriList.add(uri);
            }
        }
        selectMod = false;
        notifyDataSetChanged();
    }
    public void addItem(){

    }
    public void shareItem(){
        ArrayList<Uri> ImageUriList = new ArrayList<>();
        for(int i=0;i< URIS.size();i++){
            for(int j=0;j< URIS.get(i).size();j++){
                if(isCheck[i][j]) {
                    ImageUriList.add(URIS.get(i).get(j));
                }
            }
        }
        ShareImage shareImage = new ShareImage(context, ImageUriList);
        shareImage.StartShare();
    }
    public void TitleOnChange(String title){
        appCompatActivity.setTitle(title);
        notifyDataSetChanged();
    }
    public void setSelectModData(boolean selectMod,int CheckCount,boolean isCheck[][]){
        this.selectMod = selectMod;
        this.CheckCount = CheckCount;
        this.isCheck = isCheck;
    }
    public void setHeaderCheck(boolean[] headerCheck){
        this.headerCheck = headerCheck;
    }
    public int getScrollPosition(){
        return layoutManager.getLastVisibleItemPosition();
    }
    public void UpdateView(int row,int ScrollPosition,StickyHeaderGridLayoutManager layoutManager){
        this.row = row;
        this.layoutManager = layoutManager;
        this.layoutManager.scrollToPosition(ScrollPosition/row);
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
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_header_layout,parent,false);
        return new MyHeaderViewHolder(view);
    }
    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        Fresco.initialize(context);
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item_layout,parent,false);
        return new MyItemViewHolder(view);
    }
    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int section) {
        final MyHeaderViewHolder holder = (MyHeaderViewHolder) viewHolder;
        final String label = header[section];
        if(CheckCount == 0) {
            selectMod = false;
        }else
            selectMod = true;
        ExitSelectModListener exitSelectModListener = new ExitSelectModListener((PhotoWallAdapter)recyclerView.getAdapter());
        exitSelectModListener.setSelectMod(selectMod);
        recyclerView.setOnKeyListener(exitSelectModListener);
        holder.header.setPadding(20,20,20,20);
        holder.selectAll.setVisibility(View.GONE);
        holder.header.setText(label);
        holder.selectAll.setChecked(false);
        holder.header.setOnClickListener(null);
        if(selectMod){
            appCompatActivity.getSupportActionBar().show();
            holder.header.setPadding(100,15,15,15);
            if(headerCheck[section])
                holder.selectAll.setChecked(true);
            holder.selectAll.setVisibility(View.VISIBLE);
            SelectAllOnClickListener selectAllOnClickListener = new SelectAllOnClickListener(selectMod,CheckCount,isCheck,headerCheck,(PhotoWallAdapter)recyclerView.getAdapter());
            selectAllOnClickListener.setSection(section);
            holder.header.setOnClickListener(selectAllOnClickListener);
        }else{
            appCompatActivity.getSupportActionBar().hide();
            holder.selectAll.setVisibility(View.GONE);
            SelectAllLongClickListener selectAllLongClickListener = new SelectAllLongClickListener(selectMod,CheckCount,isCheck,headerCheck,(PhotoWallAdapter)recyclerView.getAdapter());
            selectAllLongClickListener.setSection(section);
            holder.header.setOnLongClickListener(selectAllLongClickListener);
        }
    }
    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section,final int position) {
        final MyItemViewHolder holder = (MyItemViewHolder) viewHolder;
        final Uri uri = URIS.get(section).get(position);
        holder.frescoImg.setImageURI(uri);
        holder.select.setChecked(false);
        holder.frescoImg.setPadding(0,0,0,0);
        holder.frescoImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if(CheckCount == 0) {
            selectMod = false;
            holder.select.setVisibility(View.GONE);
        }else
            selectMod = true;
        ExitSelectModListener exitSelectModListener = new ExitSelectModListener((PhotoWallAdapter)recyclerView.getAdapter());
        exitSelectModListener.setSelectMod(selectMod);
        recyclerView.setOnKeyListener(exitSelectModListener);
        if(selectMod){
            appCompatActivity.getSupportActionBar().show();
            appCompatActivity.setTitle("已選取 "+String.valueOf(CheckCount));
            if(isCheck[section][position]){
                holder.select.setChecked(true);
                holder.frescoImg.setPadding(30,30,30,30);
            }
            holder.select.setVisibility(View.VISIBLE);
            SelectModItemOnClickListener selectModItemOnClickListener = new SelectModItemOnClickListener(selectMod,CheckCount,isCheck,(PhotoWallAdapter)recyclerView.getAdapter());
            selectModItemOnClickListener.setSectionPosition(section,position);
            holder.frescoImg.setOnClickListener(selectModItemOnClickListener);
        }else{
            appCompatActivity.getSupportActionBar().hide();
            int count = 0;
            for(int i =0;i<section;i++)
                count += itemCount[i];
            goToImageGalleryOnClickListener goToImageGalleryOnClickListener = new goToImageGalleryOnClickListener(context, UriList,count + position);
            holder.frescoImg.setOnClickListener(goToImageGalleryOnClickListener);
            SelectModItemLongClickListener selectModItemLongClickListener = new SelectModItemLongClickListener(selectMod,CheckCount,isCheck,(PhotoWallAdapter) recyclerView.getAdapter());
            selectModItemLongClickListener.setSectionPosition(section,position);
            holder.frescoImg.setOnLongClickListener(selectModItemLongClickListener);
        }
    }
    public static class MyHeaderViewHolder extends HeaderViewHolder{
        TextView header;
        CheckBox selectAll;
        MyHeaderViewHolder(View itemView){
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.header);
            selectAll = (CheckBox) itemView.findViewById(R.id.select_all);
        }
    }
    public static class MyItemViewHolder extends ItemViewHolder{
        SimpleDraweeView frescoImg;
        CheckBox select;
        public MyItemViewHolder(View itemView) {
            super(itemView);
            select = (CheckBox) itemView.findViewById(R.id.select);
            frescoImg = (SimpleDraweeView) itemView.findViewById(R.id.frescoImg);
        }
    }

}
