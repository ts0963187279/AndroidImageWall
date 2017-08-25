package com.walton.android.photowall.processor;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PrepareUri {
    TreeMap<String,ArrayList<String>> imageUriTreeMap;
    public PrepareUri(){
        imageUriTreeMap = new TreeMap<>(/*new TreeMapComparator()*/);
        ArrayList<String> uriList1 = new ArrayList<>();
        uriList1.add("https://cdn.pixabay.com/photo/2014/08/26/07/38/letters-427682_960_720.jpg");
        uriList1.add("https://cdn.pixabay.com/photo/2017/01/26/14/45/alphabet-2010741_960_720.png");
        uriList1.add("https://cdn.pixabay.com/photo/2014/01/21/13/25/letter-249066_960_720.jpg");
        uriList1.add("https://cdn.pixabay.com/photo/2016/08/03/00/29/letter-1565505_960_720.png");
        uriList1.add("https://cdn.pixabay.com/photo/2014/09/18/22/42/letters-451504_960_720.jpg");
//        Collections.sort(uriList1,new ArrayListComparator());
        imageUriTreeMap.put("Java",uriList1);

        ArrayList<String> uriList2 = new ArrayList<>();
        uriList2.add("https://cdn.pixabay.com/photo/2015/11/03/08/44/c-1019707_960_720.jpg");
        uriList2.add("https://cdn.pixabay.com/photo/2015/10/31/12/27/c-1015531_960_720.jpg");
        uriList2.add("https://cdn.pixabay.com/photo/2013/07/12/16/23/alphabet-150811_960_720.png");
        uriList2.add("https://cdn.pixabay.com/photo/2014/08/23/06/11/letters-425002_960_720.jpg");
        uriList2.add("https://cdn.pixabay.com/photo/2015/08/27/00/00/letter-c-909232_960_720.jpg");
        uriList2.add("https://cdn.pixabay.com/photo/2017/04/14/11/45/letter-c-2229970_960_720.png");
        uriList2.add("https://cdn.pixabay.com/photo/2015/12/09/14/49/letter-1084810_960_720.png");
//          Collections.sort(uriList2,new ArrayListComparator());
        imageUriTreeMap.put("C++",uriList2);

        ArrayList<String> uriList3 = new ArrayList<>();
        uriList3.add("https://www.python.org/static/opengraph-icon-200x200.png");
        uriList3.add("https://udemy-images.udemy.com/course/750x422/567828_67d0.jpg");
        uriList3.add("http://eli.thegreenplace.net/images/2010/07/smilingpython.gif");
        uriList3.add("https://www.sololearn.com/Icons/Courses/1073.png");
        uriList3.add("http://unanth.com/blog/wp-content/uploads/2016/12/python.png");
        uriList3.add("https://www.filepicker.io/api/file/kM33ZaTQWSrb1QLymej9");
        uriList3.add("https://ee5817f8e2e9a2e34042-3365e7f0719651e5b8d0979bce83c558.ssl.cf5.rackcdn.com/python.png");
        uriList3.add("https://realpython.com/learn/python-first-steps/images/pythonlogo.jpg");
        uriList3.add("https://www.visualstudio.com/wp-content/uploads/2016/06/python-1-562x309@2x-op.png");
//        Collections.sort(uriList3,new ArrayListComparator());
        imageUriTreeMap.put("Python",uriList3);

        ArrayList<String> uriList4 = new ArrayList<>();
        uriList4.add("http://www.bomb01.com/upload/news/original/a7ffee577c127e703e667f1f0d3dbb79.jpg");
        uriList4.add("http://www.taiwan.net.tw/att/1/big_scenic_spots/pic_3229_24.jpg");
        uriList4.add("http://tourism.chcg.gov.tw/upload/17/2016112115184588019.jpg");
        uriList4.add("http://www.v3wall.com/wallpaper/1920_1080/1111/1920_1080_20111117090135772230.jpg");
//        Collections.sort(uriList4,new ArrayListComparator());
        imageUriTreeMap.put("View",uriList4);
    }
    public TreeMap<String, ArrayList<String>> getPrepareUri(){
        return imageUriTreeMap;
    }
}
