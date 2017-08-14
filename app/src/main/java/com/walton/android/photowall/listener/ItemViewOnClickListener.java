package com.walton.android.photowall.listener;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import com.walton.android.photowall.model.VideoActivity;
import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.ShowImageActivity;

import java.util.ArrayList;


/**
 * Created by waltonmis on 2017/7/13.
 */

public class ItemViewOnClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), VideoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        v.getContext().startActivity(intent);
    }
}
