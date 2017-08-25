package com.walton.android.photowall.processor;

import android.content.Context;

import com.walton.android.photowall.processer.CellViewCreator;
import com.walton.android.photowall.processer.Status;
import com.walton.android.photowall.view.ItemView;
import com.walton.android.photowall.view.OnSelectSocketItemView;
import com.walton.android.photowall.view.SocketItemView;
import com.walton.android.photowall.view.StaySelectionSocketItemView;

/**
 * Created by waltonmis on 2017/8/25.
 */

public class SocketItemCreator implements CellViewCreator {
    Context context;
    public SocketItemCreator(Context context){
        this.context = context;
    }
    @Override
    public ItemView createView(Status status) {
        switch (status){
            case STAYSELECT:
                return new StaySelectionSocketItemView(context);
            case ONSELECT:
                return new OnSelectSocketItemView(context);
            case VIEW:
                return new SocketItemView(context);
        }
        return new SocketItemView(context);
    }
}
