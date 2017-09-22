package com.walton.getgooglephotos.processor;


import android.accounts.AccountManager;

import com.walton.getgooglephotos.module.GoogleData;
import com.walton.getgooglephotos.module.GooglePhotosData;

/**
 * Created by waltonmis on 2017/9/19.
 */

public class GetGooglePhotosToken implements GetToken {
    GooglePhotosData googlePhotosData;
    public GetGooglePhotosToken(GoogleData googleData){
        this.googlePhotosData = (GooglePhotosData)googleData;
    }
    @Override
    public void getToken() {
        AccountManager am = googlePhotosData.getAccountManager();
        OnTokenAcquired onTokenAcquired = new OnTokenAcquired(googlePhotosData,new GetPhotoUrlsAsyncTask(googlePhotosData));
        am.getAuthToken(
                googlePhotosData.getSelectedAccount(),
                "lh2",
                null,
                googlePhotosData.getActivity(),
                onTokenAcquired,
                null);
    }
}
