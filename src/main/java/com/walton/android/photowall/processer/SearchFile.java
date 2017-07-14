package com.walton.android.photowall.processer;

import android.os.Environment;

import java.io.File;

/**
 * Created by waltonmis on 2017/7/14.
 */

public class SearchFile {
    String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    File ImageFile = new File(path);
    File[] ImageList = ImageFile.listFiles();
    public File[] getImageList(){
        return ImageList;
    }
}
