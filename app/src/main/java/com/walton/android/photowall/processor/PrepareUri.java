package com.walton.android.photowall.processor;
import android.net.Uri;

import com.walton.android.photowall.processer.ArrayListComparator;
import com.walton.android.photowall.processer.TreeMapComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PrepareUri {
    TreeMap<String,ArrayList<Uri>> imageUriTreeMap;
    public PrepareUri(){
        imageUriTreeMap = new TreeMap<>(/*new TreeMapComparator()*/);
        ArrayList<Uri> uriList1 = new ArrayList<>();
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2013/07/13/11/35/autumn-158448__340.png"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2013/07/12/13/17/tree-146748__340.png"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2013/07/12/17/21/conifer-152063__340.png"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2013/07/13/09/39/birch-155882__340.png"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2013/07/13/14/00/tree-161941_960_720.png"));
//        Collections.sort(uriList1,new ArrayListComparator());
        imageUriTreeMap.put("Tree",uriList1);

        ArrayList<Uri> uriList2 = new ArrayList<>();
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2016/10/04/23/52/cow-1715829__340.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2013/11/22/22/59/brown-216001__340.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2017/06/18/17/13/cow-2416474__340.jpg"));
        //        Collections.sort(uriList2,new ArrayListComparator());
        imageUriTreeMap.put("Cow",uriList2);
    }
    public TreeMap<String, ArrayList<Uri>> getPrepareUri(){
        return imageUriTreeMap;
    }
}
