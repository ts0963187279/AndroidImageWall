package com.walton.getgooglephotos.module;

import android.app.Activity;

import com.google.gdata.client.photos.PicasawebService;
import com.walton.getgooglephotos.processor.GetGooglePhotosToken;
import com.walton.getgooglephotos.processor.GetToken;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class GooglePhotosData extends GoogleData {
    private static final String API_PREFIX
            = "https://picasaweb.google.com/data/feed/api/user/";
    public String getApiPrefix() {
        return API_PREFIX;
    }
    public PicasawebService getPicasawebService(){
        return (PicasawebService)this.getService().getGoogleService();
    }
}
