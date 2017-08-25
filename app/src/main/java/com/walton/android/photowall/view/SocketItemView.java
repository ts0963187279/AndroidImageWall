package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.walton.android.photowall.listener.DefaultImageGalleryOnClickListener;
import com.walton.android.photowall.processor.GetImageSocketTask;

/**
 * Created by waltonmis on 2017/8/25.
 */

public class SocketItemView extends ItemView{
    private ImageView imageView;
    public SocketItemView(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView = new ImageView(context);
        imageView.setImageResource(android.R.color.transparent);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setGravity(CENTER_HORIZONTAL);
        DefaultImageGalleryOnClickListener defaultImageGalleryOnClickListener = new DefaultImageGalleryOnClickListener();
        setOnClickListener(defaultImageGalleryOnClickListener);
        addView(imageView);
    }
    @Override
    public void setImagePath(String str) {
        Uri uri = Uri.parse(str);
        GetImageSocketTask getImageSocketTask = new GetImageSocketTask(imageView);
        getImageSocketTask.setPort(8080);
        getImageSocketTask.setHost("192.168.0.147");
        getImageSocketTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,uri);
    }
}
