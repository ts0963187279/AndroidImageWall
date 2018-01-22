package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.listener.ItemViewOnClickListener;
import com.walton.android.photowall.model.ItemViewData;
/**
 * Created by waltonmis on 2017/8/7.
 */

public class NotSelectedItemView extends ItemView {
    private SimpleDraweeView showImage;
    private CheckBox selectChecker;
    public NotSelectedItemView(Context context){
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        selectChecker = new CheckBox(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        selectChecker.setClickable(false);
        setBackgroundColor(Color.RED);
        ItemViewOnClickListener itemViewOnClickListener = new ItemViewOnClickListener();
        setOnClickListener(itemViewOnClickListener);
        addView(showImage);
        addView(selectChecker);
        selectChecker.setChecked(true);
        showImage.setPadding(25,25,25,25);
    }

    @Override
    public void setData(ItemViewData itemViewData) {
		Uri uri = Uri.parse((String)itemViewData.getPreviewData());
        showImage.setImageURI(uri);
    }
}
