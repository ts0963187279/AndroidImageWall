package com.walton.android.photowall.processer;

import android.net.Uri;

import java.util.Comparator;

/**
 * Created by waltonmis on 2017/8/9.
 */

public class ArrayListComparator implements Comparator<Uri> {
    @Override
    public int compare(Uri uri1, Uri uri2) {
        int result = uri1.compareTo(uri2);
        return result;
    }
}
