package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by waltonmis on 2017/8/8.
 */

public class MyStaySelectionItemView extends ItemView {
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    public MyStaySelectionItemView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        selectChecker = new CheckBox(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        selectChecker.setClickable(false);
        setBackgroundColor(Color.RED);
        addView(showImage);
        addView(selectChecker);
        selectChecker.setChecked(false);
    }

    @Override
    public void setImagePath(String str) {
        Uri uri = Uri.parse(str);
        showImage.setImageURI(uri);
    }
}
