package com.walton.android.photowall.app.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.view.ItemView;
/**
 * Created by waltonmis on 2017/8/8.
 */

public class MyStaySelectionItemView extends ItemView<Uri> {
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    public MyStaySelectionItemView(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setPadding(5,5,5,5);
        showImage = new SimpleDraweeView(context);
        selectChecker = new CheckBox(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        selectChecker.setClickable(false);
        setBackgroundColor(Color.RED);
        addView(showImage);
        addView(selectChecker);
        selectChecker.setChecked(false);
    }
    @Override
    public void setData(Uri uri) {
        showImage.setImageURI(uri);
    }
}
