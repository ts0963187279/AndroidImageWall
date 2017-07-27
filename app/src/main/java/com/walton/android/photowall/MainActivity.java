package com.walton.android.photowall;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.AdapterCallBack;
import com.walton.android.photowall.processer.CreateUriTreeMap;
import com.walton.android.photowall.processer.PhotoWallAdapter;
import com.walton.android.photowall.processer.SearchFile;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity implements AdapterCallBack{
    RecyclerView recyclerView;
    PhotoWallAdapter photoWallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);
        recyclerView.setHasFixedSize(true);

        SearchFile searchFile = new SearchFile();
        File[] ImageList = searchFile.getImageList();
        CreateUriTreeMap createUriTreeMap = new CreateUriTreeMap(ImageList);
        TreeMap<String,ArrayList<Uri>> UriTreeMap = createUriTreeMap.getTreeMap();


        photoWallAdapter = new PhotoWallAdapter(this,UriTreeMap,recyclerView,4,this);
        recyclerView.setAdapter(photoWallAdapter);
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener(getApplicationContext(), photoWallAdapter);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void titleOnChange(String title) {
        getSupportActionBar().setTitle(title);
    }
    @Override
    public void hideActionBar(boolean hide) {
        if(hide)
            getSupportActionBar().hide();
        else
            getSupportActionBar().show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_delete:
                photoWallAdapter.removeItem();
                return true;
            case R.id.action_add:
                photoWallAdapter.addItem();
                return true;
            case R.id.action_share:
                photoWallAdapter.shareItem();
                return true;
            case android.R.id.home:
                photoWallAdapter.ViewMode();
                photoWallAdapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
