package com.walton.android.photowall.app.listener;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.walton.android.photowall.app.R;
import com.walton.android.photowall.processor.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/8/10.
 */

public class MyViewModMenuClickListener implements Toolbar.OnMenuItemClickListener {
    PhotoWallAdapter photoWallAdapter;
    public MyViewModMenuClickListener(PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sortByHeaderName:
                photoWallAdapter.sortHeader();
                return true;
            case R.id.sortByUri:
                photoWallAdapter.sortArrayList();
                return true;
        }
        return false;
    }
}
