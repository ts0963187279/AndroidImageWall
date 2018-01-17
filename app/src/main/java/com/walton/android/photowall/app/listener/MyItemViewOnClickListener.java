package com.walton.android.photowall.app.listener;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.ShowImageActivity;

import java.util.ArrayList;


/**
 * Created by waltonmis on 2017/7/13.
 */

public class MyItemViewOnClickListener implements View.OnClickListener{
    private String PUT_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String PUT_EXTRA_POSITION_KEY = "position";
    @Override
    public void onClick(View v) {
        ArrayList<Uri> ImageList;
        ItemView view = (ItemView) v;
        ImageList = view.getUriList();
        int position = view.getAbsolutePosition();
        Intent intent = new Intent(v.getContext(), ShowImageActivity.class);
        intent.putParcelableArrayListExtra(PUT_EXTRA_IMAGELIST_KEY, ImageList);
        intent.putExtra(PUT_EXTRA_POSITION_KEY, position);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        v.getContext().startActivity(intent);
    }
}
