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

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.net.Uri;
	
import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.model.ItemViewData;

/**
 * Created by waltonmis on 2017/7/28.
 */

public  class DefaultItemView extends ItemView {
    private SimpleDraweeView showImage;
    public DefaultItemView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        setBackgroundColor(Color.GREEN);
        addView(showImage);
    }
    @Override
    public void setData(ItemViewData itemViewData) {
		Uri uri = Uri.parse((String)itemViewData.getPreviewData());
        showImage.setImageURI(uri);		
    }
}
