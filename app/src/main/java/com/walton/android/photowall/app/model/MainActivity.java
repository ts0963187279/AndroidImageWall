package com.walton.android.photowall.app.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.app.R;
import com.walton.android.photowall.app.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.app.listener.MyItemViewOnClickListener;
import com.walton.android.photowall.app.listener.MyHeaderDoubleClickListener;
import com.walton.android.photowall.app.listener.MyHeaderLongClickListener;
import com.walton.android.photowall.app.listener.MyHeaderOnClickListener;
import com.walton.android.photowall.app.listener.MyItemDoubleClickListener;
import com.walton.android.photowall.app.listener.MyItemLongClickListener;
import com.walton.android.photowall.app.listener.MyItemSelectModOnClickListener;
import com.walton.android.photowall.app.listener.MySelectModMenuClickListener;
import com.walton.android.photowall.app.listener.MyViewModMenuClickListener;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processor.PhotoWallAdapter;
import com.walton.android.photowall.app.processor.MyArrayListComparator;
import com.walton.android.photowall.app.processor.MyHeaderViewCreator;
import com.walton.android.photowall.app.processor.MyItemViewCreator;
import com.walton.android.photowall.app.processor.MyTreeMapComparator;
import com.walton.android.photowall.app.processor.PrepareUri;


public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private PhotoWallAdapter photoWallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar viewModToolBar = (Toolbar)findViewById(R.id.viewModToolBar);
        viewModToolBar.inflateMenu(R.menu.view_mod_menu);
        viewModToolBar.setTitle("PhotoWall");
        Toolbar selectModToolBar = (Toolbar)findViewById(R.id.selectModToolBar);
        selectModToolBar.inflateMenu(R.menu.select_mod_menu);
        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);
        photoWallAdapter = new PhotoWallAdapter(getApplicationContext());
        PrepareUri prepareUri = new PrepareUri();

        photoWallAdapter.setData(prepareUri.getPrepareUri());

        selectModToolBar.setOnMenuItemClickListener(new MySelectModMenuClickListener(photoWallAdapter));
        viewModToolBar.setOnMenuItemClickListener(new MyViewModMenuClickListener(photoWallAdapter));
        photoWallAdapter.setViewModToolBar(viewModToolBar);
        photoWallAdapter.setSelectModToolBar(selectModToolBar);
        photoWallAdapter.setItemCellViewCreator(new MyItemViewCreator(getApplicationContext()));
        photoWallAdapter.setHeaderViewCreator(new MyHeaderViewCreator(getApplicationContext()));
        photoWallAdapter.setItemViewOnClickListener(new MyItemViewOnClickListener());
        photoWallAdapter.setSelectModHeaderLongClickListener(new MyHeaderLongClickListener());
        photoWallAdapter.setSelectModHeaderOnClickListener(new MyHeaderOnClickListener());
        photoWallAdapter.setSelectModItemLongClickListener(new MyItemLongClickListener());
        photoWallAdapter.setSelectModItemOnClickListener(new MyItemSelectModOnClickListener());
        photoWallAdapter.setHeaderViewOnDoubleClickListener(new MyHeaderDoubleClickListener());
        photoWallAdapter.setItemViewOnDoubleClickListener(new MyItemDoubleClickListener());
        photoWallAdapter.setTreeMapComparator(new MyTreeMapComparator());
        photoWallAdapter.setArrayListComparator(new MyArrayListComparator());
        recyclerView.setLayoutManager(new StickyHeaderGridLayoutManager(4));
        recyclerView.setOnKeyListener(new ExitSelectModOnKeyListener(photoWallAdapter));
        recyclerView.setAdapter(photoWallAdapter);
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener();
        scaleViewTouchListener.setMinRow(2);
        scaleViewTouchListener.setMaxRow(4);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);
    }
}
