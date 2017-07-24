package com.walton.android.photowall.processer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private TextView fixedTitle;
    private String[] Titletmp;
    private TreeMap<String,File[]> FileTreeMap;
    private List<List<File>> Files ;
    private int position;

    public RecyclerViewAdapter (Context context, TreeMap<String,File[]> FileTreeMap, RecyclerView recyclerView,int row){
        this.recyclerView = recyclerView;
        this.context = context;
        this.FileTreeMap = FileTreeMap;

        ImageList = new ArrayList<>();
        iterator = FileTreeMap.descendingKeySet().iterator();
        Files = new ArrayList<>(FileTreeMap.size());
        for(int i=0;i<FileTreeMap.size();i++){
            Key = iterator.next();
            List<File> files = new ArrayList<>(FileTreeMap.get(Key).length);
            for(int j=0;j<FileTreeMap.get(Key).length;j++){
                File file = new File(FileTreeMap.get(Key)[j].getAbsolutePath());
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
        final String label = "Header " + section;
        holder.header.setText(label);
    }

    @Override
    public void onBindItemViewHolder(ItemViewHolder viewHolder, int section, int position) {
        this.position = position;
        final MyItemViewHolder holder = (MyItemViewHolder) viewHolder;
        final String path = Files.get(section).get(position).getAbsolutePath();
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        holder.img.setImageBitmap(bitmap);
        holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ZoomImgOnClickListener zoomImgOnClickListener = new ZoomImgOnClickListener(context, ImageList, position);
        holder.img.setOnClickListener(zoomImgOnClickListener);
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
        public MyItemViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
