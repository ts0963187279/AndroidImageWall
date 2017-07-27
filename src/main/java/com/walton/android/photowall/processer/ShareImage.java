package com.walton.android.photowall.processer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/7/25.
 */

public class ShareImage {
    private Intent intent;
    private Context context;
    public ShareImage(Context context,ArrayList<Uri> ImageUriList){
        this.context = context;
        intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM,ImageUriList);
        intent.setType("image/*");
    }
    public void StartShare(){
        context.startActivity(Intent.createChooser(intent,"Image share"));
    }
}
