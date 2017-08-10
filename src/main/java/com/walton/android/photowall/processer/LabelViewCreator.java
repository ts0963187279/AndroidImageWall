package com.walton.android.photowall.processer;

import com.walton.android.photowall.view.HeaderView;

/**
 * Created by waltonmis on 2017/8/10.
 */

public interface LabelViewCreator {
    HeaderView createView(int status);
}
