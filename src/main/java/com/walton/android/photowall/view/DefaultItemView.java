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
