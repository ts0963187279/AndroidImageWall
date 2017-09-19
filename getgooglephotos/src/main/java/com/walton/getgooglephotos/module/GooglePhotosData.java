package com.walton.getgooglephotos.module;

import android.app.Activity;
import android.app.Service;

import com.google.gdata.client.photos.PicasawebService;
import com.walton.getgooglephotos.processor.Services;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class GooglePhotosData extends GoogleData {
    private static final String API_PREFIX
            = "https://picasaweb.google.com/data/feed/api/user/";
    public GooglePhotosData(Activity activity) {
        super(activity);
    }
    public String getApiPrefix() {
        return API_PREFIX;
    }
    public PicasawebService getPicasawebService(){
        return this.getService().getPicasawebService();
    }
}
