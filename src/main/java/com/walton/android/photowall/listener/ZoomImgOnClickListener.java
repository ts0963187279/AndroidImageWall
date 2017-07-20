package com.walton.android.photowall.listener;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.View;

import com.walton.android.photowall.processer.PathFileConverter;
import com.walton.android.photowall.view.ShowImageActivity;

import java.io.File;


/**
 * Created by waltonmis on 2017/7/13.
 */

public class ZoomImgOnClickListener implements View.OnClickListener{
    private static boolean isChagne = false;
    private String PUT_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String PUT_EXTRA_POSITION_KEY = "position";
    private Context context;
    private String[] ImageListPath;
    private int position;
    public ZoomImgOnClickListener(Context context , File[] ImageList,int position){
        this.context = context;
        this.position = position;
        ImageListPath = new PathFileConverter().getPath(ImageList);
    }
    @Override
    public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), ShowImageActivity.class);
            intent.putExtra(PUT_EXTRA_IMAGELIST_KEY, ImageListPath);
            intent.putExtra(PUT_EXTRA_POSITION_KEY, position);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
    }
}
