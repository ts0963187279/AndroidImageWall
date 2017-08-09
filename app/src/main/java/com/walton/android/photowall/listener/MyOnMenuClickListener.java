package com.walton.android.photowall.listener;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.walton.android.photowall.R;
import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/8/9.
 */

public class MyOnMenuClickListener implements Toolbar.OnMenuItemClickListener {
    private PhotoWallAdapter photoWallAdapter;
    public MyOnMenuClickListener(PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                photoWallAdapter.removeItem();
                return true;
            case R.id.action_share:
                photoWallAdapter.shareItem();
                return true;
           }
           return false;
    }
}
