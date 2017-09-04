package com.example.getgooglephotos.processor;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/9/4.
 */

public interface DoInBackground {
    void doIt(TreeMap<String,ArrayList<String>> strTreeMap);
}
