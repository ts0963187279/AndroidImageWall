/*
 * Copyright (C) 2017 RS Wong <ts0963187279@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.android.photowall.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Menu;
import android.view.MenuInflater;

import com.walton.android.photowall.processor.GalleryAdapter;

import java.util.ArrayList;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class ShowImageActivity extends AppCompatActivity {
    private String GET_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String GET_EXTRA_POSITION_KEY = "position";
    private RecyclerView recyclerView;
    private int position;
    private ArrayList<Uri> ImageUriList;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        setContentView(R.layout.showimage_layout);
        Intent intent = this.getIntent();
        ImageUriList = intent.getParcelableArrayListExtra(GET_EXTRA_IMAGELIST_KEY);
        position = intent.getIntExtra(GET_EXTRA_POSITION_KEY,1);
        recyclerView = (RecyclerView)findViewById(R.id.Gallery);
        recyclerView.setHasFixedSize(true);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this,ImageUriList);
        recyclerView.setAdapter(galleryAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        layoutManager.scrollToPosition(position);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.show_image_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
