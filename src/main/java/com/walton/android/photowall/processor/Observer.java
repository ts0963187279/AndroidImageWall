package com.walton.android.photowall.processer;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/31.
 */

public interface Observer {
    void subscribe(Observable observable);
    void unSubscribe();
    void updateUrl(ArrayList<URL> photoUrls);
}
