package com.walton.android.photowall.model;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.R;
import com.walton.android.photowall.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.listener.ImageGalleryClickListener;
import com.walton.android.photowall.listener.MyHeaderDoubleClickListener;
import com.walton.android.photowall.listener.MyHeaderLongClickListener;
import com.walton.android.photowall.listener.MyHeaderOnClickListener;
import com.walton.android.photowall.listener.MyItemDoubleClickListener;
import com.walton.android.photowall.listener.MyItemLongClickListener;
import com.walton.android.photowall.listener.MyItemOnClickListener;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.processor.MyHeaderViewCreator;
import com.walton.android.photowall.processor.MyItemViewCreator;
import com.walton.android.photowall.processor.PrepareUri;
import com.walton.android.photowall.processer.RecyclerViewOnChangeAnimation;
import com.walton.android.photowall.view.MyPhotoWallCellHeaderView;
import com.walton.android.photowall.view.MyPhotoWallCellItemView;

import java.util.ArrayList;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    PhotoWallAdapter photoWallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);
        RecyclerViewOnChangeAnimation recyclerViewOnChangeAnimation = new RecyclerViewOnChangeAnimation(recyclerView);
        recyclerViewOnChangeAnimation.setAnimationEnabled(false);

        TreeMap<String,ArrayList<Uri>> UriTreeMap = new PrepareUri().getPrepareUri();

        photoWallAdapter = new PhotoWallAdapter(getApplicationContext(),UriTreeMap,this);
        photoWallAdapter.setItemViewCreator(new MyItemViewCreator(getApplicationContext()));
        photoWallAdapter.setHeaderViewCreator(new MyHeaderViewCreator(getApplicationContext()));
        photoWallAdapter.setImageGalleryClickListener(new ImageGalleryClickListener());
        photoWallAdapter.setSelectModHeaderLongClickListener(new MyHeaderLongClickListener());
        photoWallAdapter.setSelectModHeaderOnClickListener(new MyHeaderOnClickListener());
        photoWallAdapter.setSelectModItemLongClickListener(new MyItemLongClickListener());
        photoWallAdapter.setSelectModItemOnClickListener(new MyItemOnClickListener());
        photoWallAdapter.setHeaderViewOnDoubleClickListener(new MyHeaderDoubleClickListener());
        photoWallAdapter.setItemViewOnDoubleClickListener(new MyItemDoubleClickListener());
        recyclerView.setAdapter(photoWallAdapter);
        recyclerView.setLayoutManager(new StickyHeaderGridLayoutManager(4));
        recyclerView.setOnKeyListener(new ExitSelectModOnKeyListener(photoWallAdapter));
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener();
        scaleViewTouchListener.setMinRow(2);
        scaleViewTouchListener.setMaxRow(4);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_delete:
                photoWallAdapter.removeItem();
                return true;
            case R.id.action_share:
                photoWallAdapter.shareItem();
                return true;
            case android.R.id.home:
                photoWallAdapter.ViewMod();
                photoWallAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
