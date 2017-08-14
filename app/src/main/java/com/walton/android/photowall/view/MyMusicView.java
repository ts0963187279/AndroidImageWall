package com.walton.android.photowall.view;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.walton.android.photowall.processor.PrepareMusic;

/**
 * Created by waltonmis on 2017/8/11.
 */

public class MyMusicView extends ItemView{
    private SimpleDraweeView showImage;
    private Context context;
    private static MediaPlayer mediaPlayer;
    public MyMusicView(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        showImage = new SimpleDraweeView(context);
        showImage.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        showImage.setAdjustViewBounds(true);
        setBackgroundColor(Color.BLACK);
        addView(showImage);
    }
    public void startMusic(){
        if(mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(context,new PrepareMusic().getMusic(this.getAbsolutePosition()));
        mediaPlayer.start();
    }
    @Override
    public void setImageUri(Uri uri) {
        showImage.setImageURI(uri);
    }
}
