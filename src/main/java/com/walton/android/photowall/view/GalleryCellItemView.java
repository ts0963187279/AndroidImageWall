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
import android.net.Uri;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import com.walton.android.photowall.library.R;

/**
 * Created by waltonmis on 2017/8/1.
 */

public class GalleryCellItemView extends LinearLayout {
    private SimpleDraweeView FullScreenImg;
    public GalleryCellItemView(Context context, View itemView) {
        super(context);
        FullScreenImg = (SimpleDraweeView)itemView.findViewById(R.id.FullScreenImg);
    }
    public void setImageURI(Uri uri){
        FullScreenImg.setImageURI(uri);
    }
}
