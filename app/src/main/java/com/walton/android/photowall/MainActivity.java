package com.walton.android.photowall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processer.CreateFileTreeMap;
import com.walton.android.photowall.processer.RecyclerViewAdapter;
import com.walton.android.photowall.processer.SearchFile;

import java.io.File;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity {
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

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(),FileTreeMap,recyclerView,4);
        recyclerView.setAdapter(recyclerViewAdapter);
        ScaleViewTouchListener scaleViewTouchListener = new ScaleViewTouchListener(getApplicationContext(),recyclerViewAdapter);
        recyclerView.addOnItemTouchListener(scaleViewTouchListener);
    }
}
