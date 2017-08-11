package com.walton.android.photowall.listener;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.MyMusicView;
import com.walton.android.photowall.view.ShowImageActivity;

import java.util.ArrayList;


/**
 * Created by waltonmis on 2017/7/13.
 */

public class ItemMusicOnClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        MyMusicView view = (MyMusicView)v;
        view.startMusic();
    }
}
