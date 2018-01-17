package com.walton.android.photowall.app.listener;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.walton.android.photowall.app.R;
import com.walton.android.photowall.processor.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/8/9.
 */

public class MySelectModMenuClickListener implements Toolbar.OnMenuItemClickListener {
    private PhotoWallAdapter photoWallAdapter;
    public MySelectModMenuClickListener(PhotoWallAdapter photoWallAdapter){
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
