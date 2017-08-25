package com.walton.android.photowall.processor;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/8/25.
 */

public class SocketPrepareData {
    private TreeMap<String,ArrayList<String>> fileUriTreeMap;
    public SocketPrepareData(){
        fileUriTreeMap = new TreeMap<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("1.png");
        list1.add("2.jpg");
        list1.add("3.jpg");
        list1.add("4.png");
        list1.add("5.jpg");
        list1.add("6.png");
        list1.add("7.jpg");
        fileUriTreeMap.put("C",list1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("11.png");
        list2.add("12.jpg");
        list2.add("13.png");
        list2.add("14.jpg");
        list2.add("15.jpg");
        fileUriTreeMap.put("j",list2);
    }
    public TreeMap<String,ArrayList<String>> getPrepareData(){
        return fileUriTreeMap;
    }
}
