package com.walton.android.photowall.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.walton.android.photowall.R;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processor.ActivityResult;
import com.walton.android.photowall.processor.GetGooglePhotos;


public class MainActivity extends AppCompatActivity{
    RecyclerView recyclerView;
    GooglePhotosData googlePhotosData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar viewModToolBar = (Toolbar)findViewById(R.id.viewModToolBar);
        viewModToolBar.inflateMenu(R.menu.view_mod_menu);
        viewModToolBar.setTitle("PhotoWall");
        Toolbar selectModToolBar = (Toolbar)findViewById(R.id.selectModToolBar);
        selectModToolBar.inflateMenu(R.menu.select_mod_menu);
        googlePhotosData = new GooglePhotosData(this);
        GetGooglePhotos getGooglePhotos = new GetGooglePhotos(googlePhotosData);
        getGooglePhotos.get();
        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);
        googlePhotosData.setRecyclerView(recyclerView);
        googlePhotosData.setSelectModToolBar(selectModToolBar);
        googlePhotosData.setViewModToolBar(viewModToolBar);
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener();
        scaleViewTouchListener.setMinRow(2);
        scaleViewTouchListener.setMaxRow(4);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);
    }
    protected void onActivityResult(final int requestCode , final int resultCode , final Intent data){
        new ActivityResult(googlePhotosData,requestCode,resultCode,data);
    }
}