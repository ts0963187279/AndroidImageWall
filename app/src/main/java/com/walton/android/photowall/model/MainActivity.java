package com.walton.android.photowall.model;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.R;
import com.walton.android.photowall.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.listener.ItemMusicOnClickListener;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.processor.MyArrayListComparator;
import com.walton.android.photowall.processor.MyHeaderViewCreator;
import com.walton.android.photowall.processor.MyItemViewCreator;
import com.walton.android.photowall.processor.MyTreeMapComparator;
import com.walton.android.photowall.processor.PrepareUri;

import java.util.ArrayList;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    PhotoWallAdapter photoWallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar viewModToolBar = (Toolbar)findViewById(R.id.viewModToolBar);
        viewModToolBar.setTitle("PhotoWall");
        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);


        TreeMap<String,ArrayList<Uri>> uriTreeMap = new PrepareUri().getPrepareUri();
        photoWallAdapter = new PhotoWallAdapter(getApplicationContext(),uriTreeMap);
        photoWallAdapter.setViewModToolBar(viewModToolBar);
        photoWallAdapter.setItemCellViewCreator(new MyItemViewCreator(getApplicationContext()));
        photoWallAdapter.setHeaderViewCreator(new MyHeaderViewCreator(getApplicationContext()));
        photoWallAdapter.setItemViewOnClickListener(new ItemMusicOnClickListener());
        photoWallAdapter.setTreeMapComparator(new MyTreeMapComparator());
        photoWallAdapter.setArrayListComparator(new MyArrayListComparator());
        recyclerView.setAdapter(photoWallAdapter);
        recyclerView.setLayoutManager(new StickyHeaderGridLayoutManager(4));
        recyclerView.setOnKeyListener(new ExitSelectModOnKeyListener(photoWallAdapter));
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener();
        scaleViewTouchListener.setMinRow(2);
        scaleViewTouchListener.setMaxRow(4);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);

    }
}