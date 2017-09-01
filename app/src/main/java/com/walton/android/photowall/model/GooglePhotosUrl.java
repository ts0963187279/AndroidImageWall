package com.walton.android.photowall.model;


import android.net.Uri;

import com.walton.android.photowall.processer.Observable;
import com.walton.android.photowall.processer.Observer;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/31.
 */

public class GooglePhotosUrl implements Observer {
    private ArrayList<URL> photoUrls;
    private Observable observable;
    @Override
    public void subscribe(Observable observable) {
        this.observable = observable;
        observable.register(this);
    }
    @Override
    public void unSubscribe() {
        observable.unRegister(this);
    }
    @Override
    public void updateUrl(ArrayList<URL> photoUrls) {
        this.photoUrls = photoUrls;
        System.out.println("update thread :" + Thread.currentThread());
        System.out.println("update photoUrls");
    }
}
