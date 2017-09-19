package com.walton.android.photowall.processor;

import com.walton.getgooglephotos.processor.OnBackGroundResult;
import com.walton.android.photowall.processer.PhotoWallAdapter;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/9/4.
 */

public class UpDateAdapterData implements OnBackGroundResult {
    private PhotoWallAdapter photoWallAdapter;
    public UpDateAdapterData(PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
    }
    @Override
    public void doIt(TreeMap<String, ArrayList<String>> strTreeMap) {
        photoWallAdapter.setData(strTreeMap);
    }
}
