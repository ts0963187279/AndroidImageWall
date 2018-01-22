package com.walton.android.photowall.listener;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.ShowImageActivity;
import com.walton.android.photowall.model.ItemViewData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by waltonmis on 2017/7/13.
 */

public class ItemViewOnClickListener implements View.OnClickListener{
    private String PUT_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String PUT_EXTRA_POSITION_KEY = "position";
    @Override
    public void onClick(View v) {
        ArrayList<Uri> imageList = new ArrayList<>();
		List<ItemViewData> itemViewDataList;
        ItemView view = (ItemView)v;
		itemViewDataList = view.getItemViewDataList();
        for(ItemViewData itemViewData : itemViewDataList){
			Uri uri = Uri.parse((String)itemViewData.getContentData());
			imageList.add(uri);
		}
        int position = view.getAbsolutePosition();
        Intent intent = new Intent(v.getContext(), ShowImageActivity.class);
        intent.putParcelableArrayListExtra(PUT_EXTRA_IMAGELIST_KEY,imageList);
        intent.putExtra(PUT_EXTRA_POSITION_KEY, position);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        v.getContext().startActivity(intent);
    }
}
