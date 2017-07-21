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
        FileTreeMap.put("MyFirst Key",file);
        return FileTreeMap;
    }
}
