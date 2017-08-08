package com.walton.android.photowall.processor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PrepareUri {
    TreeMap<String,ArrayList<Uri>> ImageUriTreeMap;
    public PrepareUri(){
        ImageUriTreeMap = new TreeMap<>();
        ArrayList<Uri> UriList1 = new ArrayList<>();
        UriList1.add(Uri.parse("https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png"));
        UriList1.add(Uri.parse("https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png"));
        UriList1.add(Uri.parse("https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png"));
        UriList1.add(Uri.parse("http://www.vjmedia.com.hk/wp-content/uploads/2017/06/02/160951/24823_963e_12.jpg"));
        UriList1.add(Uri.parse("https://java.com/ga/images/jv0h_gojava.jpg"));
        ImageUriTreeMap.put("Java",UriList1);

        ArrayList<Uri> UriList2 = new ArrayList<>();
        UriList2.add(Uri.parse("https://isocpp.org/files/img/cpp_logo.png"));
        UriList2.add(Uri.parse("https://lh3.googleusercontent.com/3vGlLyKkKC46G1qqiqyKf0jeOyUtiZk5NxOxeuRJOfP4aZzCob9kabZX252mUmVAHA=w300"));
        UriList2.add(Uri.parse("https://www.visualstudio.com/wp-content/uploads/2016/05/C-4-562x309-OPx.png"));
        UriList2.add(Uri.parse("https://daks2k3a4ib2z.cloudfront.net/590b02ac96d6fe11f3fcef0c/59143a1e01301267ba12abb3_cpp-1.jpg"));
        UriList2.add(Uri.parse("https://lh3.ggpht.com/yB8HooRMBe9S23VT2rW127FOGirb9X5_ErczTGMgfJ_3SfyjCj-w5yekHCPNmSxri-kf=w300"));
        UriList2.add(Uri.parse("https://www.embarcadero.com/images/free-tools/CCompiler_Logo_256x256px.png"));
        UriList2.add(Uri.parse("http://errorpage.b0.upaiyun.com/jbcdn2-403"));
        UriList2.add(Uri.parse("https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAb_AAAAJDBkMGEyNjk3LTE2OWYtNDI1YS1iOWFiLTU3ZDg1OWNmMmVhYw.jpg"));
        ImageUriTreeMap.put("C++",UriList2);

        ArrayList<Uri> UriList3 = new ArrayList<>();
        UriList3.add(Uri.parse("https://www.python.org/static/opengraph-icon-200x200.png"));
        UriList3.add(Uri.parse("https://udemy-images.udemy.com/course/750x422/567828_67d0.jpg"));
        UriList3.add(Uri.parse("http://eli.thegreenplace.net/images/2010/07/smilingpython.gif"));
        UriList3.add(Uri.parse("https://www.sololearn.com/Icons/Courses/1073.png"));
        UriList3.add(Uri.parse("http://unanth.com/blog/wp-content/uploads/2016/12/python.png"));
        UriList3.add(Uri.parse("https://www.filepicker.io/api/file/kM33ZaTQWSrb1QLymej9"));
        UriList3.add(Uri.parse("https://ee5817f8e2e9a2e34042-3365e7f0719651e5b8d0979bce83c558.ssl.cf5.rackcdn.com/python.png"));
        UriList3.add(Uri.parse("https://realpython.com/learn/python-first-steps/images/pythonlogo.jpg"));
        UriList3.add(Uri.parse("https://www.visualstudio.com/wp-content/uploads/2016/06/python-1-562x309@2x-op.png"));
        ImageUriTreeMap.put("Python",UriList3);

        ArrayList<Uri> UriList4 = new ArrayList<>();
        //UriList4.add(Uri.parse("http://travel.chiayi.gov.tw/upload/14/2012051514355672603.jpg"));
        UriList4.add(Uri.parse("http://www.taiwan.net.tw/att/1/big_scenic_spots/pic_3229_24.jpg"));
        UriList4.add(Uri.parse("http://tourism.chcg.gov.tw/upload/17/2016112115184588019.jpg"));
        ImageUriTreeMap.put("View",UriList4);
    }
    public TreeMap<String, ArrayList<Uri>> getPrepareUri(){
        return ImageUriTreeMap;
    }
}
