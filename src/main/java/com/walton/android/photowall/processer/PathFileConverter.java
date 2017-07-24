package com.walton.android.photowall.processer;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class PathFileConverter {
    public ArrayList<String> getPath(List<File> files){
        List<String> Path = new ArrayList<>();
        for(int i=0;i<files.size();i++)
            Path.add(files.get(i).getAbsolutePath());
        return (ArrayList<String>) Path;
    }
    public ArrayList<File> getFile(List<String> Path){
        List<File> files = new ArrayList<>();
        for(int i=0;i<Path.size();i++)
            files.add(new File(Path.get(i)));
        return (ArrayList<File>) files;
    }
}
