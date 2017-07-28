package com.walton.android.photowall;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.PhotoWallAdapter;

import java.util.ArrayList;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity{
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
        /*SearchFile searchFile = new SearchFile();
        File[] ImageList = searchFile.getImageList();
        CreateUriTreeMap createUriTreeMap = new CreateUriTreeMap(ImageList);
        TreeMap<String,ArrayList<Uri>> UriTreeMap = createUriTreeMap.getTreeMap();*/
        TreeMap<String,ArrayList<Uri>> UriTreeMap = new TreeMap<String,ArrayList<Uri>>();
        ArrayList<Uri> test = new ArrayList<Uri>();
        test.add(Uri.parse("http://hunsci.com/data/out/221/904361.jpeg"));
        UriTreeMap.put("test",test);

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
