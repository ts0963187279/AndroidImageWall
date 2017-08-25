package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.walton.android.photowall.processor.GetImageSocketTask;

/**
 * Created by waltonmis on 2017/8/25.
 */

public class GalleryView extends LinearLayout{
    private ImageView imageView;
    public GalleryView(Context context) {
        super(context);
        setOrientation(HORIZONTAL);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView = new ImageView(context);
        imageView.setImageResource(android.R.color.transparent);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setAdjustViewBounds(true);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        addView(imageView);
    }
    public void setImagePath(String str){
        Uri uri = Uri.parse(str);
        GetImageSocketTask getImageSocketTask = new GetImageSocketTask(imageView);
        getImageSocketTask.setHost("192.168.0.147");
        getImageSocketTask.setPort(8080);
        getImageSocketTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,uri);
    }
}
