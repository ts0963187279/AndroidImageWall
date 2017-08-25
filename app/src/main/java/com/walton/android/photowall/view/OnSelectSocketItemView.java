package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.walton.android.photowall.listener.DefaultImageGalleryOnClickListener;
import com.walton.android.photowall.processor.GetImageSocketTask;

/**
 * Created by waltonmis on 2017/8/8.
 */

public class OnSelectSocketItemView extends ItemView {
    private ImageView imageView;
    private CheckBox selectChecker;
    public OnSelectSocketItemView(Context context){
        super(context);
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        imageView = new ImageView(context);
        imageView.setImageResource(android.R.color.transparent);
        selectChecker = new CheckBox(context);
        imageView.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        selectChecker.setClickable(false);
        setBackgroundColor(Color.GREEN);
        DefaultImageGalleryOnClickListener defaultImageGalleryOnClickListener = new DefaultImageGalleryOnClickListener();
        setOnClickListener(defaultImageGalleryOnClickListener);
        addView(imageView);
        addView(selectChecker);
        selectChecker.setChecked(true);
        imageView.setPadding(25,25,25,25);
    }
    @Override
    public void setImagePath(String str) {
        Uri uri = Uri.parse(str);
        GetImageSocketTask getImageSocketTask = new GetImageSocketTask(imageView);
        getImageSocketTask.setPort(8080);
        getImageSocketTask.setHost("192.168.0.147");
        getImageSocketTask.execute(uri);
    }
}
