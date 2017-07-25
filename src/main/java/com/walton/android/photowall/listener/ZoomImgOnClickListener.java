package com.walton.android.photowall.listener;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.ShowImageActivity;

import java.util.ArrayList;


/**
 * Created by waltonmis on 2017/7/13.
 */

public class ZoomImgOnClickListener implements View.OnClickListener{
    private String PUT_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String PUT_EXTRA_POSITION_KEY = "position";
    private Context context;
    private ArrayList<Uri> ImageList;
    private int position;
    public ZoomImgOnClickListener(Context context , ArrayList<Uri> ImageList, int position){
        this.context = context;
        this.position = position;
        this.ImageList = ImageList;
    }
    @Override
    public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ShowImageActivity.class);
            intent.putParcelableArrayListExtra(PUT_EXTRA_IMAGELIST_KEY,ImageList);
            intent.putExtra(PUT_EXTRA_POSITION_KEY, position);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
    }
}
