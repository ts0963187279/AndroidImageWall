package com.walton.android.photowall.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.google.gdata.client.photos.PicasawebService;
import com.walton.android.photowall.R;
import com.walton.android.photowall.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.listener.ItemViewOnClickListener;
import com.walton.android.photowall.listener.MyHeaderDoubleClickListener;
import com.walton.android.photowall.listener.MyHeaderLongClickListener;
import com.walton.android.photowall.listener.MyHeaderOnClickListener;
import com.walton.android.photowall.listener.MyItemDoubleClickListener;
import com.walton.android.photowall.listener.MyItemLongClickListener;
import com.walton.android.photowall.listener.MyItemSelectModOnClickListener;
import com.walton.android.photowall.listener.MySelectModMenuClickListener;
import com.walton.android.photowall.listener.MyViewModMenuClickListener;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.processor.MyArrayListComparator;
import com.walton.android.photowall.processor.MyHeaderViewCreator;
import com.walton.android.photowall.processor.MyItemViewCreator;
import com.walton.android.photowall.processor.MyTreeMapComparator;
import com.walton.android.photowall.processor.UpDateAdapterData;
import com.walton.getgooglephotos.module.GoogleContactData;
import com.walton.getgooglephotos.module.GooglePhotosData;
import com.walton.getgooglephotos.processor.ConnectGoogleAccount;
import com.walton.getgooglephotos.processor.GetGooglePhotosToken;
import com.walton.getgooglephotos.processor.SelectGoogleAccount;
import com.walton.getgooglephotos.processor.Services;


public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private PhotoWallAdapter photoWallAdapter;
    private GooglePhotosData googlePhotosData;
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
        googlePhotosData = new GooglePhotosData(this);
        googlePhotosData.setOnBackGroundResult(new UpDateAdapterData(photoWallAdapter));
        Services services = new Services(new PicasawebService("AndroidPhotoWall"));
        googlePhotosData.setService(services);

        SelectGoogleAccount selectGoogleAccount = new SelectGoogleAccount(this);
        selectGoogleAccount.select();

        selectModToolBar.setOnMenuItemClickListener(new MySelectModMenuClickListener(photoWallAdapter));
        viewModToolBar.setOnMenuItemClickListener(new MyViewModMenuClickListener(photoWallAdapter));
//        photoWallAdapter.setData(new PrepareUri().getPrepareUri());
        photoWallAdapter.setViewModToolBar(viewModToolBar);
        photoWallAdapter.setSelectModToolBar(selectModToolBar);
        photoWallAdapter.setItemCellViewCreator(new MyItemViewCreator(getApplicationContext()));
        photoWallAdapter.setHeaderViewCreator(new MyHeaderViewCreator(getApplicationContext()));
        photoWallAdapter.setItemViewOnClickListener(new ItemViewOnClickListener());
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
    protected void onActivityResult(final int requestCode , final int resultCode , final Intent data){
        ConnectGoogleAccount connectGoogleAccount = new ConnectGoogleAccount(requestCode,resultCode,data);
        connectGoogleAccount.connect(new GetGooglePhotosToken(googlePhotosData),googlePhotosData);
    }
}