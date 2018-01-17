package com.walton.android.photowall.processor;

import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public interface CellViewCreator {
    ItemView createView(int status);
}
