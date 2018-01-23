/*
 * Copyright (C) 2017 RS Wong <ts0963187279@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.android.photowall.app.processor;
import android.net.Uri;

import com.walton.android.photowall.processor.ArrayListComparator;
import com.walton.android.photowall.processor.TreeMapComparator;
import com.walton.android.photowall.model.ItemViewData;
import com.walton.android.photowall.model.PhotoItemViewData;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/7/28.
 */

public class PrepareData {
    TreeMap<String,List<ItemViewData>> itemViewDataTreeMap;
    public PrepareData(){
        itemViewDataTreeMap = new TreeMap<>();
		ItemViewData itemViewDataTmp = new PhotoItemViewData();
        List<ItemViewData> itemViewDataListTmp = new ArrayList<>();
		itemViewDataTmp.setPreviewData("https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png");
		itemViewDataTmp.setContentData("https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F_400x400.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png");
		itemViewDataTmp.setContentData("https://www.technotification.com/wp-content/uploads/2016/07/Why-is-Java-the-best-programming-Language.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("http://www.vjmedia.com.hk/wp-content/uploads/2017/06/02/160951/24823_963e_12.jpg");
		itemViewDataTmp.setContentData("http://www.vjmedia.com.hk/wp-content/uploads/2017/06/02/160951/24823_963e_12.jpg");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://java.com/ga/images/jv0h_gojava.jpg");
		itemViewDataTmp.setContentData("https://java.com/ga/images/jv0h_gojava.jpg");
		itemViewDataListTmp.add(itemViewDataTmp);
        itemViewDataTreeMap.put("Java",itemViewDataListTmp);

		itemViewDataListTmp = new ArrayList<>();
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://lh3.googleusercontent.com/3vGlLyKkKC46G1qqiqyKf0jeOyUtiZk5NxOxeuRJOfP4aZzCob9kabZX252mUmVAHA=w300");
		itemViewDataTmp.setContentData("https://lh3.googleusercontent.com/3vGlLyKkKC46G1qqiqyKf0jeOyUtiZk5NxOxeuRJOfP4aZzCob9kabZX252mUmVAHA=w300");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.visualstudio.com/wp-content/uploads/2016/05/C-4-562x309-OPx.png");
		itemViewDataTmp.setContentData("https://www.visualstudio.com/wp-content/uploads/2016/05/C-4-562x309-OPx.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://isocpp.org/files/img/cpp_blogo.png");
		itemViewDataTmp.setContentData("https://isocpp.org/files/img/cpp_blogo.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://daks2k3a4ib2z.cloudfront.net/590b02ac96d6fe11f3fcef0c/59143a1e01301267ba12abb3_cpp-1.jpg");
		itemViewDataTmp.setContentData("https://daks2k3a4ib2z.cloudfront.net/590b02ac96d6fe11f3fcef0c/59143a1e01301267ba12abb3_cpp-1.jpg");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://lh3.ggpht.com/yB8HooRMBe9S23VT2rW127FOGirb9X5_ErczTGMgfJ_3SfyjCj-w5yekHCPNmSxri-kf=w300");
		itemViewDataTmp.setContentData("https://lh3.ggpht.com/yB8HooRMBe9S23VT2rW127FOGirb9X5_ErczTGMgfJ_3SfyjCj-w5yekHCPNmSxri-kf=w300");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.embarcadero.com/images/free-tools/CCompiler_Logo_256x256px.png");
		itemViewDataTmp.setContentData("https://www.embarcadero.com/images/free-tools/CCompiler_Logo_256x256px.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("http://errorpage.b0.upaiyun.com/jbcdn2-403");
		itemViewDataTmp.setContentData("http://errorpage.b0.upaiyun.com/jbcdn2-403");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAb_AAAAJDBkMGEyNjk3LTE2OWYtNDI1YS1iOWFiLTU3ZDg1OWNmMmVhYw.jpg");
		itemViewDataTmp.setContentData("https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAAb_AAAAJDBkMGEyNjk3LTE2OWYtNDI1YS1iOWFiLTU3ZDg1OWNmMmVhYw.jpg");
		itemViewDataListTmp.add(itemViewDataTmp);
        itemViewDataTreeMap.put("C++",itemViewDataListTmp);

		itemViewDataListTmp = new ArrayList<>();
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.python.org/static/opengraph-icon-200x200.png");
		itemViewDataTmp.setContentData("https://www.python.org/static/opengraph-icon-200x200.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://udemy-images.udemy.com/course/750x422/567828_67d0.jpg");
		itemViewDataTmp.setContentData("https://udemy-images.udemy.com/course/750x422/567828_67d0.jpg");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("http://eli.thegreenplace.net/images/2010/07/smilingpython.bgif");
		itemViewDataTmp.setContentData("http://eli.thegreenplace.net/images/2010/07/smilingpython.bgif");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.sololearn.com/Icons/Courses/1073.png");
		itemViewDataTmp.setContentData("https://www.sololearn.com/Icons/Courses/1073.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("http://unanth.com/blog/wp-content/uploads/2016/12/python.png");
		itemViewDataTmp.setContentData("http://unanth.com/blog/wp-content/uploads/2016/12/python.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.filepicker.io/api/file/kM33ZaTQWSrb1QLymej9");
		itemViewDataTmp.setContentData("https://www.filepicker.io/api/file/kM33ZaTQWSrb1QLymej9");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://ee5817f8e2e9a2e34042-3365e7f0719651e5b8d0979bce83c558.ssl.cf5.rackcdn.com/python.png");
		itemViewDataTmp.setContentData("https://ee5817f8e2e9a2e34042-3365e7f0719651e5b8d0979bce83c558.ssl.cf5.rackcdn.com/python.png");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://realpython.com/learn/python-first-steps/images/pythonlogo.jpg");
		itemViewDataTmp.setContentData("https://realpython.com/learn/python-first-steps/images/pythonlogo.jpg");
		itemViewDataListTmp.add(itemViewDataTmp);
		itemViewDataTmp = new PhotoItemViewData();
		itemViewDataTmp.setPreviewData("https://www.visualstudio.com/wp-content/uploads/2016/06/python-1-562x309@2x-op.png");
		itemViewDataTmp.setContentData("https://www.visualstudio.com/wp-content/uploads/2016/06/python-1-562x309@2x-op.png");
		itemViewDataListTmp.add(itemViewDataTmp);
        itemViewDataTreeMap.put("Python",itemViewDataListTmp);
    }
    public TreeMap<String, List<ItemViewData>> getPrepareData(){
        return itemViewDataTreeMap;
    }
}
