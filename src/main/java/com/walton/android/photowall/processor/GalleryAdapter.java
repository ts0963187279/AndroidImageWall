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
package com.walton.android.photowall.processor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.view.GalleryCellItemView;

import java.io.File;
import java.util.List;

import com.walton.android.photowall.library.R;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryItemViewHolder>{
    private Context context;
    private List<Uri> ImageUriList;
    public GalleryAdapter(Context context , List<Uri> ImageUriList){
        this.context = context;
        this.ImageUriList = ImageUriList;
    }
    @Override
    public GalleryItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gallery_layout,viewGroup,false);
        return new GalleryItemViewHolder(view,context);
    }
    @Override
    public void onBindViewHolder(final GalleryItemViewHolder viewHolder, final int position) {
        viewHolder.galleryCellItemView.setImageURI(ImageUriList.get(position));
    }
    @Override
    public int getItemCount() {
        return ImageUriList.size();
    }
}
