package com.walton.android.photowall.processer;

import java.io.File;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/17.
 */

public class CreateFileTreeMap {
    private File[] file;
    private File[] newFile;
    private TreeMap<String ,File[]> FileTreeMap;
    public CreateFileTreeMap(File[] file){
        this.file = file;FileTreeMap = new TreeMap<>();
    }
    public TreeMap<String ,File[]> GetTreeMap(){
        newFile = new File[5];
        for(int i = 0 ; i < 5 ; i++){
            newFile[i] = file[i];
        }
        FileTreeMap.put("MyFirst Key",newFile);
        newFile = new File[20];
        for(int i=0;i<20;i++){
            newFile[i] = file[i+5];
        }
        FileTreeMap.put("MySecond Key",newFile);
        newFile = new File[13];
        for(int i=0;i<13;i++){
            newFile[i] = file[i+25];
        }
        FileTreeMap.put("My Key",newFile);
        return FileTreeMap;
    }
}
