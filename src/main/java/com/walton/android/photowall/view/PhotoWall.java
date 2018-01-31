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

import android.widget.LinearLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.content.Context;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.walton.android.photowall.processor.PhotoWallAdapter;
import com.walton.android.photowall.model.ItemViewData;
import com.walton.android.photowall.processor.CellViewCreator;
import com.walton.android.photowall.processor.LabelViewCreator;
import com.walton.android.photowall.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.model.HeaderViewData;

import java.util.List;
import java.util.TreeMap;
import java.util.Comparator;
import java.util.Hashtable;

public class PhotoWall extends LinearLayout{
	private Toolbar viewModToolBar;
	private Toolbar selectModToolBar;
	private RecyclerView recyclerView;
	private PhotoWallAdapter photoWallAdapter;
	public PhotoWall(Context context){
		super(context);
		setOrientation(VERTICAL);
		viewModToolBar = new Toolbar(context);
		viewModToolBar.setLayoutParams(new LinearLayout.LayoutParams(0,0));
		addView(viewModToolBar);
		selectModToolBar = new Toolbar(context);
		addView(selectModToolBar);
		recyclerView = new RecyclerView(context);
		recyclerView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
		addView(recyclerView);
		photoWallAdapter = new PhotoWallAdapter(context);
		photoWallAdapter.setViewModToolBar(viewModToolBar);
		photoWallAdapter.setSelectModToolBar(selectModToolBar);
		recyclerView.setOnKeyListener(new ExitSelectModOnKeyListener(photoWallAdapter));
		recyclerView.setLayoutManager(new StickyHeaderGridLayoutManager(4));
		recyclerView.setAdapter(photoWallAdapter);
	}
	public void setData(TreeMap<HeaderViewData,List<ItemViewData>> itemViewDataTreeMap){
		photoWallAdapter.setData(itemViewDataTreeMap);
	}
	public void setViewModToolBar(Toolbar toolbar){
		viewModToolBar = toolbar;
		addView(viewModToolBar);
		photoWallAdapter.setViewModToolBar(toolbar);
	}
	public void setSelectModToolBar(Toolbar toolbar){
		selectModToolBar = toolbar;
		addView(selectModToolBar);
		photoWallAdapter.setSelectModToolBar(toolbar);
	}
	public void setCellViewCreator(CellViewCreator cellViewCreator){
		photoWallAdapter.setItemViewCreator(cellViewCreator);
	}
	public void setLabelViewCreator(LabelViewCreator labelViewCreator){
		photoWallAdapter.setHeaderViewCreator(labelViewCreator);
	}
	public void setItemViewOnClickListener(OnClickListener onClickListener){
		photoWallAdapter.setItemViewOnClickListener(onClickListener);
	}
	public void setSelectModHeaderLongClickListener(OnLongClickListener onLongClickListener){
		photoWallAdapter.setSelectModHeaderLongClickListener(onLongClickListener);
	}
	public void setSelectModHeaderOnClickListener(OnClickListener onClickListener){
		photoWallAdapter.setSelectModHeaderOnClickListener(onClickListener);
	}
	public void setSelectModItemLongClickListener(OnLongClickListener onLongClickListener){
		photoWallAdapter.setSelectModItemLongClickListener(onLongClickListener);
	}
	public void setSelectModItemOnClickListener(OnClickListener onClickListener){
		photoWallAdapter.setSelectModItemOnClickListener(onClickListener);
	}
	public void setHeaderViewOnDoubleClickListener(OnClickListener onDoubleClickListener){
		photoWallAdapter.setHeaderViewOnDoubleClickListener(onDoubleClickListener);
	}
	public void setItemViewOnDoubleClickListener(OnClickListener onDoubleClickListener){
		photoWallAdapter.setItemViewOnDoubleClickListener(onDoubleClickListener);
	}
	public void setTreeMapComparator(Comparator<String> comparator){
		photoWallAdapter.setTreeMapComparator(comparator);
	}
	public void setListComparator(Comparator comparator){
		photoWallAdapter.setListComparator(comparator);
	}
	public void setWidth(int width){
		recyclerView.setLayoutManager(new StickyHeaderGridLayoutManager(width));
	}
	public void setOnItemTouchListener(RecyclerView.OnItemTouchListener onItemTouchListener){
		recyclerView.addOnItemTouchListener(onItemTouchListener);
	}
}
