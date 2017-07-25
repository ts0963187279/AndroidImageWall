package com.walton.android.photowall.processer;

import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/25.
 */

public class ShareImage {
    private Intent intent;
    public ShareImage(ArrayList<Uri> ImageList){
        intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,ImageList);
    }
}
