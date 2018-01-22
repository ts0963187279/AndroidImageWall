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
package com.walton.android.photowall.app.processor;

import android.content.Context;
import android.view.View;

import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.processor.CellViewCreator;
import com.walton.android.photowall.app.view.MyNotSelectedItemView;
import com.walton.android.photowall.app.view.MyItemView;
import com.walton.android.photowall.app.view.MySelectedItemView;

/**
 * Created by waltonmis on 2017/8/7.
 */

public class MyItemViewCreator implements CellViewCreator {
    Context context;
    public MyItemViewCreator(Context context){
        this.context = context;
    }
    @Override
    public ItemView createView(int status) {
        switch (status){
            case 1:
                return new MySelectedItemView(context);
            case 2:
                return new MyNotSelectedItemView(context);
            default:
                return new MyItemView(context);
        }
    }
}
