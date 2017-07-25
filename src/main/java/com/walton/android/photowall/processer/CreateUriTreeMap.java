package com.walton.android.photowall.processer;



import android.net.Uri;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/25.
 */

public class CreateUriTreeMap {
    private File[] files;
    private TreeMap<String,ArrayList<Uri>> UriTreeMap;
    private ArrayList<Uri> URIS;
    public CreateUriTreeMap(File[] files){
        this.files = files;
    }
    public TreeMap<String,ArrayList<Uri>> getTreeMap(){
        UriTreeMap = new TreeMap<>();
        URIS = new ArrayList<>(12);
        for(int i=0;i<12;i++){
            URIS.add(Uri.fromFile(files[i]));
        }
        UriTreeMap.put("MySecond Key",URIS);
        URIS = new ArrayList<>(12);
        for(int i=0;i<12;i++){
            URIS.add(Uri.fromFile(files[i+12]));
        }
        UriTreeMap.put("Hello World!@!",URIS);
        URIS = new ArrayList<>(7);
        for(int i=0;i<7;i++){
            URIS.add(Uri.fromFile(files[i+24]));
        }
        UriTreeMap.put("New Hello Worldddddd",URIS);
        URIS = new ArrayList<>(7);
        for(int i=0;i<7;i++){
            URIS.add(Uri.fromFile(files[i+31]));
        }
        UriTreeMap.put("ASDJASOID",URIS);
        return UriTreeMap;
    }
}
