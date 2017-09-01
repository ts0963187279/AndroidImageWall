package com.walton.android.photowall.model;


import android.net.Uri;

import com.walton.android.photowall.processer.Observable;
import com.walton.android.photowall.processer.Observer;

import java.net.URL;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/8/31.
 */

public class GooglePhotosUrl implements Observer {
    private ArrayList<URL> photoUrls;
    private Observable observable;
    public GooglePhotosUrl(){
        photoUrls = new ArrayList<>();
    }
    public TreeMap<String,ArrayList<Uri>> getUriTreeMap(){
        TreeMap<String,ArrayList<Uri>> uriTreeMap = new TreeMap<>();
        ArrayList<Uri> uris = new ArrayList<>();
        for(URL url : photoUrls){
            uris.add(Uri.parse(uris.toString()));
        }
        uriTreeMap.put("1",uris);
        return uriTreeMap;
    }
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
