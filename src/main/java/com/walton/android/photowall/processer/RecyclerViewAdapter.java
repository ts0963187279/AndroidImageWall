package com.walton.android.photowall.processer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.test.ActivityUnitTestCase;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.walton.android.photowall.listener.ZoomImgOnClickListener;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/21.
 */

public class RecyclerViewAdapter extends StickyHeaderGridAdapter{
    private List<File> ImageList;
    private Context context;
    private RecyclerView recyclerView;
    private StickyHeaderGridLayoutManager layoutManager;
    private Object Key;
    private Iterator iterator;
    private String[] header;
    private int itemCount[];
    private TreeMap<String,File[]> FileTreeMap;
    private boolean[][] isCheck;
    private List<List<File>> Files ;
    private int CheckCount = 0;
    private boolean selectMod = false;
    private AdapterCallBack adapterCallBack;

    public RecyclerViewAdapter (Context context, TreeMap<String,File[]> FileTreeMap, RecyclerView recyclerView, int row,AdapterCallBack adapterCallBack){
        this.recyclerView = recyclerView;
        this.context = context;
        this.FileTreeMap = FileTreeMap;
        this.adapterCallBack = adapterCallBack;
        ImageList = new ArrayList<>();
        iterator = FileTreeMap.descendingKeySet().iterator();
        Files = new ArrayList<>(FileTreeMap.size());
        itemCount = new int[FileTreeMap.size()];
        isCheck = new boolean[FileTreeMap.size()][];
        header = new String[FileTreeMap.size()];
        for(int i=0;i<FileTreeMap.size();i++){
            itemCount[i] = 0;
            Key = iterator.next();
            header[i] = Key.toString();
            List<File> files = new ArrayList<>(FileTreeMap.get(Key).length);
            isCheck[i] = new boolean[FileTreeMap.get(Key).length];
            for(int j=0;j<FileTreeMap.get(Key).length;j++){
                File file = new File(FileTreeMap.get(Key)[j].getAbsolutePath());
                itemCount[i]++;
                isCheck[i][j] = false;
                files.add(file);
                ImageList.add(file);
            }
            Files.add(files);
        }

        layoutManager = new StickyHeaderGridLayoutManager(row);
        recyclerView.setLayoutManager(layoutManager);
    }
    public int getScrollPosition(){
        return layoutManager.getLastVisibleItemPosition();
    }
    public void UpdateView(int row,int ScrollPosition,StickyHeaderGridLayoutManager layoutManager){
        this.layoutManager = layoutManager;
        this.layoutManager.scrollToPosition(ScrollPosition/row);
    }
    @Override
    public int getSectionCount() {
        return Files.size();
    }

    @Override
    public int getSectionItemCount(int section) {
        return Files.get(section).size();
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_header_layout,parent,false);
        return new MyHeaderViewHolder(view);
    }

    @Override
    public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item_layout,parent,false);
        return new MyItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int section) {
        final MyHeaderViewHolder holder = (MyHeaderViewHolder) viewHolder;
        final String label = header[section];
        holder.header.setText(label);
    }

    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section,final int position) {
        final MyItemViewHolder holder = (MyItemViewHolder) viewHolder;
        final String path = Files.get(section).get(position).getAbsolutePath();
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        holder.checkBox.setChecked(false);
        holder.img.setPadding(0,0,0,0);
        holder.img.setImageBitmap(bitmap);
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        adapterCallBack.hideActionBar(!selectMod);
        if(CheckCount == 0) {
            selectMod = false;
            holder.checkBox.setVisibility(View.GONE);
        }
        if(selectMod){
            adapterCallBack.titleOnChange("已選取 "+String.valueOf(CheckCount));
            if(isCheck[section][position]){
                holder.checkBox.setChecked(true);
                holder.img.setPadding(30,30,30,30);
            }
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    isCheck[section][position] = !holder.checkBox.isChecked();
                    if(isCheck[section][position])
                        CheckCount++;
                    else
                        CheckCount--;
                    notifyDataSetChanged();
                }
            });
            recyclerView.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                    if(selectMod) {
                        if (keyCode == keyEvent.KEYCODE_BACK) {
                            for (int i = 0; i < isCheck.length; i++) {
                                for (int j = 0; j < isCheck[i].length; j++) {
                                    isCheck[i][j] = false;
                                }
                            }
                            CheckCount = 0;
                            selectMod = false;
                            notifyDataSetChanged();
                            return true;
                        }
                    }
                    return false;
                }
            });

        }else{
            int count = 0;
            for(int i =0;i<section;i++)
                count += itemCount[i];
            ZoomImgOnClickListener zoomImgOnClickListener = new ZoomImgOnClickListener(context, ImageList,count + position);
            holder.img.setOnClickListener(zoomImgOnClickListener);
            holder.img.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    selectMod = true;
                    isCheck[section][position] = true;
                    CheckCount ++;
                    adapterCallBack.titleOnChange("已選取 "+String.valueOf(CheckCount));
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
    }
    public static class MyHeaderViewHolder extends HeaderViewHolder{
        TextView header;
        MyHeaderViewHolder(View itemView){
            super(itemView);
            header = (TextView) itemView.findViewById(R.id.header);
        }
    }
    public static class MyItemViewHolder extends ItemViewHolder{
        ImageView img;
        CheckBox checkBox;
        public MyItemViewHolder(View itemView) {
            super(itemView);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
