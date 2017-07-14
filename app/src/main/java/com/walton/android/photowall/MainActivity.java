package com.walton.android.photowall;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.walton.android.photowall.listener.ZoomOnTouchListener;
import com.walton.android.photowall.processer.MyAdapter;
import com.walton.android.photowall.processer.SearchFile;

import java.io.File;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        recyclerView.setLayoutManager(layoutManager);
        SearchFile searchFile = new SearchFile();
        File[] fileList = searchFile.getImageList();
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), fileList, fragmentManager, recyclerView);
        recyclerView.setAdapter(adapter);
        ZoomOnTouchListener zoomOnTouchListener = new ZoomOnTouchListener(getApplicationContext(), recyclerView);
        recyclerView.setOnTouchListener(zoomOnTouchListener);
    }
}
