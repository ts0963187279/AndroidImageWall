package com.walton.android.photowall.processer;

/**
 * Created by waltonmis on 2017/8/31.
 */

public interface Observable {
    void register(Observer observer);
    void unRegister(Observer observer);
    void notifyObserver();
}
