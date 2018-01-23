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
package com.walton.android.photowall.app.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.app.R;
import com.walton.android.photowall.app.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.app.listener.MyItemViewOnClickListener;
import com.walton.android.photowall.app.listener.MyHeaderDoubleClickListener;
import com.walton.android.photowall.app.listener.MyHeaderLongClickListener;
import com.walton.android.photowall.app.listener.MyHeaderOnClickListener;
import com.walton.android.photowall.app.listener.MyItemDoubleClickListener;
import com.walton.android.photowall.app.listener.MyItemLongClickListener;
import com.walton.android.photowall.app.listener.MyItemSelectModOnClickListener;
import com.walton.android.photowall.app.listener.MySelectModMenuClickListener;
import com.walton.android.photowall.app.listener.MyViewModMenuClickListener;
import com.walton.android.photowall.listener.ScaleViewTouchListener;
import com.walton.android.photowall.processor.PhotoWallAdapter;
import com.walton.android.photowall.view.PhotoWall;
import com.walton.android.photowall.app.processor.MyArrayListComparator;
import com.walton.android.photowall.app.processor.MyHeaderViewCreator;
import com.walton.android.photowall.app.processor.MyItemViewCreator;
import com.walton.android.photowall.app.processor.MyTreeMapComparator;
import com.walton.android.photowall.app.processor.PrepareData;


public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private PhotoWallAdapter photoWallAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		PhotoWall photoWall = new PhotoWall(this);
		PrepareData prepareData = new PrepareData();
		photoWall.setData(prepareData.getPrepareData());
		photoWall.setCellViewCreator(new MyItemViewCreator(this));
		photoWall.setLabelViewCreator(new MyHeaderViewCreator(this));
		photoWall.setItemViewOnClickListener(new MyItemViewOnClickListener());
		photoWall.setSelectModHeaderLongClickListener(new MyHeaderLongClickListener());
		photoWall.setSelectModHeaderOnClickListener(new MyHeaderOnClickListener());
		photoWall.setSelectModItemLongClickListener(new MyItemLongClickListener());
		photoWall.setSelectModItemOnClickListener(new MyItemSelectModOnClickListener());
		photoWall.setHeaderViewOnDoubleClickListener(new MyHeaderDoubleClickListener());
		photoWall.setItemViewOnDoubleClickListener(new MyItemDoubleClickListener());
		photoWall.setWidth(4);
		photoWall.setOnItemViewTouchListener(new ScaleViewTouchListener());
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
		addContentView(photoWall,layoutParams);
    }
}
