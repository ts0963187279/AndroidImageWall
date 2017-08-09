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
    TreeMap<String,ArrayList<Uri>> ImageUriTreeMap;
    public PrepareUri(){
        ImageUriTreeMap = new TreeMap<>(new TreeMapComparator());
        ArrayList<Uri> uriList1 = new ArrayList<>();
        uriList1.add(Uri.parse("https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png"));
        uriList1.add(Uri.parse("https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png"));
        uriList1.add(Uri.parse("https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png"));
        uriList1.add(Uri.parse("http://www.vjmedia.com.hk/wp-content/uploads/2017/06/02/160951/24823_963e_12.jpg"));
        uriList1.add(Uri.parse("https://java.com/ga/images/jv0h_gojava.jpg"));
        Collections.sort(uriList1,new ArrayListComparator());
        ImageUriTreeMap.put("Java",uriList1);

        ArrayList<Uri> uriList2 = new ArrayList<>();
        uriList2.add(Uri.parse("https://isocpp.org/files/img/cpp_logo.png"));
        uriList2.add(Uri.parse("https://lh3.googleusercontent.com/3vGlLyKkKC46G1qqiqyKf0jeOyUtiZk5NxOxeuRJOfP4aZzCob9kabZX252mUmVAHA=w300"));
        uriList2.add(Uri.parse("https://www.visualstudio.com/wp-content/uploads/2016/05/C-4-562x309-OPx.png"));
        uriList2.add(Uri.parse("https://daks2k3a4ib2z.cloudfront.net/590b02ac96d6fe11f3fcef0c/59143a1e01301267ba12abb3_cpp-1.jpg"));
        uriList2.add(Uri.parse("https://lh3.ggpht.com/yB8HooRMBe9S23VT2rW127FOGirb9X5_ErczTGMgfJ_3SfyjCj-w5yekHCPNmSxri-kf=w300"));
        uriList2.add(Uri.parse("https://www.embarcadero.com/images/free-tools/CCompiler_Logo_256x256px.png"));
        uriList2.add(Uri.parse("http://errorpage.b0.upaiyun.com/jbcdn2-403"));
        uriList2.add(Uri.parse("https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAb_AAAAJDBkMGEyNjk3LTE2OWYtNDI1YS1iOWFiLTU3ZDg1OWNmMmVhYw.jpg"));
        Collections.sort(uriList2,new ArrayListComparator());
        ImageUriTreeMap.put("C++",uriList2);

        ArrayList<Uri> uriList3 = new ArrayList<>();
        uriList3.add(Uri.parse("https://www.python.org/static/opengraph-icon-200x200.png"));
        uriList3.add(Uri.parse("https://udemy-images.udemy.com/course/750x422/567828_67d0.jpg"));
        uriList3.add(Uri.parse("http://eli.thegreenplace.net/images/2010/07/smilingpython.gif"));
        uriList3.add(Uri.parse("https://www.sololearn.com/Icons/Courses/1073.png"));
        uriList3.add(Uri.parse("http://unanth.com/blog/wp-content/uploads/2016/12/python.png"));
        uriList3.add(Uri.parse("https://www.filepicker.io/api/file/kM33ZaTQWSrb1QLymej9"));
        uriList3.add(Uri.parse("https://ee5817f8e2e9a2e34042-3365e7f0719651e5b8d0979bce83c558.ssl.cf5.rackcdn.com/python.png"));
        uriList3.add(Uri.parse("https://realpython.com/learn/python-first-steps/images/pythonlogo.jpg"));
        uriList3.add(Uri.parse("https://www.visualstudio.com/wp-content/uploads/2016/06/python-1-562x309@2x-op.png"));
        Collections.sort(uriList3,new ArrayListComparator());
        ImageUriTreeMap.put("Python",uriList3);

        ArrayList<Uri> uriList4 = new ArrayList<>();
        uriList4.add(Uri.parse("http://www.bomb01.com/upload/news/original/a7ffee577c127e703e667f1f0d3dbb79.jpg"));
        uriList4.add(Uri.parse("http://www.taiwan.net.tw/att/1/big_scenic_spots/pic_3229_24.jpg"));
        uriList4.add(Uri.parse("http://tourism.chcg.gov.tw/upload/17/2016112115184588019.jpg"));
        uriList4.add(Uri.parse("http://www.v3wall.com/wallpaper/1920_1080/1111/1920_1080_20111117090135772230.jpg"));
        Collections.sort(uriList4,new ArrayListComparator());
        ImageUriTreeMap.put("View",uriList4);
    }
    public TreeMap<String, ArrayList<Uri>> getPrepareUri(){
        return ImageUriTreeMap;
    }
}
