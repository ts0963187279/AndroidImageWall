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
package com.walton.android.photowall.app.view;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.walton.android.photowall.view.HeaderView;
/**
 * Created by waltonmis on 2017/8/8.
 */

public class MyNotSelectedHeaderView extends HeaderView {
    private TextView header;
    private CheckBox selectAllChecker;
    public MyNotSelectedHeaderView(Context context) {
        super(context);
        setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header = new TextView(context);
        header.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        selectAllChecker = new CheckBox(context);
        selectAllChecker.setClickable(false);
        setBackgroundColor(Color.GRAY);
        addView(selectAllChecker);
        addView(header);
        selectAllChecker.setChecked(true);
    }

    @Override
    public void setText(String title) {
        header.setText(title);
    }
}