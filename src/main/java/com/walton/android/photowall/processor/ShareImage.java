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
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/25.
 */

public class ShareImage {
    private Intent intent;
    private Context context;
    public ShareImage(Context context,ArrayList<Uri> ImageUriList){
        this.context = context;
        intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,ImageUriList);
        intent.setType("image/*");
    }
    public void StartShare(){
        context.startActivity(Intent.createChooser(intent,"Image share").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
