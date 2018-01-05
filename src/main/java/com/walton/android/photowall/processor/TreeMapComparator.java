package com.walton.android.photowall.processer;

import java.util.Comparator;

/**
 * Created by waltonmis on 2017/8/8.
 */

public class TreeMapComparator implements Comparator<String> {
    @Override
    public int compare(String name1, String name2) {
        int result = name2.compareTo(name1);
        return result;
    }
}
