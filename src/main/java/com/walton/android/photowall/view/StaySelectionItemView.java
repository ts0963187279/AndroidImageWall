package com.walton.android.photowall.view;

import android.content.Context;
import android.net.Uri;

/**
 * Created by waltonmis on 2017/8/8.
 */

public class StaySelectionItemView extends PhotoWallCellItemView{
    public StaySelectionItemView(Context context) {
        super(context);

    }
    @Override
    public boolean isChecked() {
        return false;
    }

    @Override
    public void setImage(Uri uri) {

    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {

    }

    @Override
    public void setChecked(boolean isCheck) {

    }

    @Override
    public void setCheckBoxVisible(int isVisible) {

    }
}
