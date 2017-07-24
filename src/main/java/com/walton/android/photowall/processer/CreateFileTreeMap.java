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
        //FileTreeMap.put("MyFirst Key",file);
        newFile = new File[12];
        for(int i=0;i<12;i++){
            newFile[i] = file[i];
        }
        FileTreeMap.put("MySecond Key",newFile);
        newFile = new File[12];
        for(int i=0;i<12;i++){
            newFile[i] = file[i+12];
        }
        FileTreeMap.put("Hello World!!",newFile);
        newFile = new File[7];
        for(int i=0;i<7;i++){
            newFile[i] = file[i+24];
        }
        FileTreeMap.put("New Hello World!@",newFile);
        newFile = new File[7];
        for(int i=0;i<7;i++){
            newFile[i] = file[i+31];
        }
        FileTreeMap.put("AAAAAAAA",newFile);
        return FileTreeMap;
    }
}
