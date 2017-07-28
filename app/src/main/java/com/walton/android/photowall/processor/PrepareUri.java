package com.walton.android.photowall.processor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PrepareUri {
    TreeMap<String,ArrayList<Uri>> ImageUriTreeMap;
    ArrayList<Uri> UriList1;
    ArrayList<Uri> UriList2;
    ArrayList<Uri> UriList3;
    public PrepareUri(){
        ImageUriTreeMap = new TreeMap<>();
        UriList1 = new ArrayList<>();
        UriList1.add(Uri.parse("https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png"));
        UriList1.add(Uri.parse("https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png"));
        UriList1.add(Uri.parse("https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png"));
        UriList1.add(Uri.parse("http://www.vjmedia.com.hk/wp-content/uploads/2017/06/02/160951/24823_963e_12.jpg"));
        UriList1.add(Uri.parse("https://java.com/ga/images/jv0h_gojava.jpg"));
        ImageUriTreeMap.put("Java",UriList1);

        UriList2 = new ArrayList<>();
        UriList2.add(Uri.parse("https://isocpp.org/files/img/cpp_logo.png"));
        UriList2.add(Uri.parse("https://lh3.googleusercontent.com/3vGlLyKkKC46G1qqiqyKf0jeOyUtiZk5NxOxeuRJOfP4aZzCob9kabZX252mUmVAHA=w300"));
        UriList2.add(Uri.parse("https://www.visualstudio.com/wp-content/uploads/2016/05/C-4-562x309-OPx.png"));
        ImageUriTreeMap.put("C++",UriList2);

        UriList3 = new ArrayList<>();
        UriList3.add(Uri.parse("https://www.python.org/static/opengraph-icon-200x200.png"));
        UriList3.add(Uri.parse("https://udemy-images.udemy.com/course/750x422/567828_67d0.jpg"));
        UriList3.add(Uri.parse("http://eli.thegreenplace.net/images/2010/07/smilingpython.gif"));
        UriList3.add(Uri.parse("https://www.sololearn.com/Icons/Courses/1073.png"));
        ImageUriTreeMap.put("Python",UriList3);
    }
    public TreeMap<String, ArrayList<Uri>> getPrepareUri(){
        return ImageUriTreeMap;
    }
}
