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
import java.util.Iterator;
import java.util.TreeMap;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/11.
 */

public class PhotoWallAdapter extends RecyclerView.Adapter<PhotoWallAdapter.ViewHolder>{
    private File[] ImageList;
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Object Key;
    private Object[] Keytmp;
    private Iterator iterator;
    private int count;
    private int numberOfTitle = 0;
    private int[] Titleposition;
    private TreeMap<String,File[]> FileTreeMap;
    public PhotoWallAdapter(Context context, TreeMap<String,File[]> FileTreeMap, int count, RecyclerView recyclerView){
        this.recyclerView = recyclerView;
        this.context = context;
        this.count = count;
        this.FileTreeMap = FileTreeMap;

        Titleposition = new int[FileTreeMap.size()+1];
        ImageList = new File[count];
        Keytmp = new Object [FileTreeMap.size()];
        iterator = FileTreeMap.descendingKeySet().iterator();
        int i=0,pointer=0;
        while(iterator.hasNext()){
            Titleposition[i] = pointer;
            Key = iterator.next();
            Keytmp[i] = Key;
            for(int j=0;j<FileTreeMap.get(Key).length;j++){
                ImageList[pointer] = FileTreeMap.get(Key)[j];
                pointer ++;
            }
            i++;
        }
        MySpanSizeLookup mySpanSizeLookup = new MySpanSizeLookup(Titleposition,4);
        layoutManager = new GridLayoutManager(context,4);
        ((GridLayoutManager)layoutManager).setSpanSizeLookup(mySpanSizeLookup);
        recyclerView.setLayoutManager(layoutManager);
    }
    public int[] getTitlePosition(){
        return Titleposition;
    }
    public int getScrollPosition(){
        return ((GridLayoutManager)layoutManager).findFirstVisibleItemPosition();
    }
    public void UpdateView(int row,int scrollPosition,RecyclerView.LayoutManager layoutManager){
        this.layoutManager = layoutManager;
        this.layoutManager.scrollToPosition(scrollPosition+row/2 + 1);
    }
    @Override
    public PhotoWallAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PhotoWallAdapter.ViewHolder viewHolder, int position) {
        for(int i=0;i<Titleposition.length;i++){
            if(position <= Titleposition[i]){
                numberOfTitle = i;
                break;
            }else if(position > Titleposition[Titleposition.length-2]){
                numberOfTitle = Titleposition.length-1;
                break;
            }
        }
        if(position != Titleposition[numberOfTitle]){
            Bitmap bitmap = BitmapFactory.decodeFile(ImageList[position-numberOfTitle].getAbsolutePath());
            viewHolder.RecyclerViewImg.setImageBitmap(bitmap);
            viewHolder.RecyclerViewImg.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewHolder.RecyclerViewImg.setVisibility(View.VISIBLE);
            ZoomImgOnClickListener zoomImgOnClickListener = new ZoomImgOnClickListener(context,ImageList,position-numberOfTitle);
            viewHolder.RecyclerViewImg.setOnClickListener(zoomImgOnClickListener);
            viewHolder.Title.setVisibility(View.GONE);
        }else{
            viewHolder.Title.setText(Keytmp[numberOfTitle].toString());
            viewHolder.RecyclerViewImg.setVisibility(View.GONE);
            viewHolder.Title.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return count + FileTreeMap.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView RecyclerViewImg;
        private TextView Title;
        public ViewHolder(View view){
            super(view);
            RecyclerViewImg = (ImageView)view.findViewById(R.id.RecyclerViewImg);
            Title = (TextView)view.findViewById(R.id.Title);
        }
    }
}
