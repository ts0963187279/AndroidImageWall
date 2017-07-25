package com.walton.android.photowall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.AdapterCallBack;
import com.walton.android.photowall.processer.CreateFileTreeMap;
import com.walton.android.photowall.processer.RecyclerViewAdapter;
import com.walton.android.photowall.processer.SearchFile;

import java.io.File;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity implements AdapterCallBack{
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.PhotoWall);
        recyclerView.setHasFixedSize(true);

        SearchFile searchFile = new SearchFile();
        File[] ImageList = searchFile.getImageList();
        CreateFileTreeMap createFileTreeMap = new CreateFileTreeMap(ImageList);
        TreeMap<String,File[]> FileTreeMap = createFileTreeMap.GetTreeMap();

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this,FileTreeMap,recyclerView,4,this);
        recyclerView.setAdapter(recyclerViewAdapter);
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener(getApplicationContext(),recyclerViewAdapter);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
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
}
