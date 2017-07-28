package com.walton.android.photowall.model;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.walton.android.photowall.R;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.PhotoWallAdapter;
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);

        TreeMap<String,ArrayList<Uri>> UriTreeMap = new PrepareUri().getPrepareUri();

        photoWallAdapter = new PhotoWallAdapter(this,UriTreeMap,recyclerView,4,this);
        recyclerView.setAdapter(photoWallAdapter);

        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener(photoWallAdapter);
        scaleViewTouchListener.setMinRow(2);
        scaleViewTouchListener.setMaxRow(6);
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
