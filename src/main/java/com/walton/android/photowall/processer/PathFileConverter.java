package com.walton.android.photowall.processer;

import java.io.File;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class PathFileConverter {
    public String[] getPath(File[] files){
        String[] Path = new String[files.length];
        for(int i=0;i<files.length;i++)
            Path[i] = files[i].getAbsolutePath();
        return Path;
    }
    public File[] getFile(String[] Path){
        File[] files = new File[Path.length];
        for(int i=0;i<Path.length;i++)
            files[i] = new File(Path[i]);
        return files;
    }
}
