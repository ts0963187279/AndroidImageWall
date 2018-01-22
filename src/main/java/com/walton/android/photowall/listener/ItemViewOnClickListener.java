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
package com.walton.android.photowall.listener;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.ShowImageActivity;
import com.walton.android.photowall.model.ItemViewData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waltonmis on 2017/7/13.
 */

public class ItemViewOnClickListener implements View.OnClickListener{
    private String PUT_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String PUT_EXTRA_POSITION_KEY = "position";
    @Override
    public void onClick(View v) {
        ArrayList<Uri> imageList = new ArrayList<>();
		List<ItemViewData> itemViewDataList;
        ItemView view = (ItemView)v;
		itemViewDataList = view.getItemViewDataList();
        for(ItemViewData itemViewData : itemViewDataList){
			Uri uri = Uri.parse((String)itemViewData.getContentData());
			imageList.add(uri);
		}
        int position = view.getAbsolutePosition();
        Intent intent = new Intent(v.getContext(), ShowImageActivity.class);
        intent.putParcelableArrayListExtra(PUT_EXTRA_IMAGELIST_KEY,imageList);
        intent.putExtra(PUT_EXTRA_POSITION_KEY, position);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        v.getContext().startActivity(intent);
    }
}
