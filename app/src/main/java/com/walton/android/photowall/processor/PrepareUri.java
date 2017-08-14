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
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2013/07/12/16/50/cafe-151346_960_720.png"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2014/04/03/10/09/coffee-309981_960_720.png"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2016/01/02/04/59/coffee-1117933_960_720.jpg"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2016/04/28/19/37/indonesia-1359504_960_720.jpg"));
        uriList1.add(Uri.parse("https://cdn.pixabay.com/photo/2017/05/19/21/12/java-2327538_960_720.png"));
//        Collections.sort(uriList1,new ArrayListComparator());
        imageUriTreeMap.put("Java",uriList1);

        ArrayList<Uri> uriList2 = new ArrayList<>();
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2016/02/11/17/00/dog-1194087_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2016/02/20/17/05/dog-1212400_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2013/09/28/20/02/dog-187817_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2014/03/04/19/53/dog-279698_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2015/11/06/13/10/dog-1027549_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2015/02/15/03/04/girl-636874_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2015/04/22/12/24/dog-734689_960_720.jpg"));
        uriList2.add(Uri.parse("https://cdn.pixabay.com/photo/2016/02/26/16/32/dog-1224267_960_720.jpg"));
        imageUriTreeMap.put("Dog",uriList2);

        ArrayList<Uri> uriList3 = new ArrayList<>();
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2014/10/10/08/01/letters-483010_960_720.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2014/11/23/21/22/green-tree-python-543243__340.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2013/12/10/18/22/green-tree-python-226553__340.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2011/07/25/23/40/green-tree-python-8343__340.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2017/03/04/15/58/boelens-python-2116390__340.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2017/01/31/13/49/language-2024210__340.png"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2016/08/04/15/42/burmese-python-1569314__340.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2015/01/08/15/01/snake-593076__340.jpg"));
        uriList3.add(Uri.parse("https://cdn.pixabay.com/photo/2017/05/17/05/03/snake-2319873_960_720.jpg"));
//        Collections.sort(uriList3,new ArrayListComparator());
        imageUriTreeMap.put("Python",uriList3);

        ArrayList<Uri> uriList4 = new ArrayList<>();
        uriList4.add(Uri.parse("https://cdn.pixabay.com/photo/2016/07/28/20/28/clearwater-villa-ocean-view-1549550_960_720.jpg"));
        uriList4.add(Uri.parse("https://cdn.pixabay.com/photo/2015/03/18/03/03/sea-view-678659_960_720.jpg"));
        uriList4.add(Uri.parse("https://cdn.pixabay.com/photo/2017/06/04/14/09/dolomites-2371178_960_720.jpg"));
        uriList4.add(Uri.parse("https://cdn.pixabay.com/photo/2017/03/27/16/46/dolomites-2179604_960_720.jpg"));
//        Collections.sort(uriList4,new ArrayListComparator());
        imageUriTreeMap.put("View",uriList4);
    }
    public TreeMap<String, ArrayList<Uri>> getPrepareUri(){
        return imageUriTreeMap;
    }
}
