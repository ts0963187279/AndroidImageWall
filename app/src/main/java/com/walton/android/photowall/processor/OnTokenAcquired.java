package com.walton.android.photowall.processor;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.gdata.client.photos.PicasawebService;
import com.walton.android.photowall.model.GooglePhotosData;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class OnTokenAcquired implements AccountManagerCallback<Bundle> {
    Activity activity;
    private final int REQUEST_AUTHENTICATE = 2;
    PicasawebService picasawebService;
    GooglePhotosData googlePhotosData;
    public OnTokenAcquired(GooglePhotosData googlePhotosData){
        activity = googlePhotosData.getActivity();
        this.googlePhotosData = googlePhotosData;
    }
    @Override
    public void run(AccountManagerFuture<Bundle> result) {
        try{
            Bundle bundle = result.getResult();
            if(bundle.containsKey(AccountManager.KEY_INTENT)){
                Intent intent = bundle.getParcelable(AccountManager.KEY_INTENT);
                int flags = intent.getFlags();
                intent.setFlags(flags);
                flags &= ~Intent.FLAG_ACTIVITY_NEW_TASK;
                activity.startActivityForResult(intent,REQUEST_AUTHENTICATE);
                return;
            }
            if(bundle.containsKey(AccountManager.KEY_AUTHTOKEN)){
                final String authToken = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                googlePhotosData.setAuthToken(authToken);
                picasawebService = new PicasawebService("pictureframe");
                picasawebService.setUserToken(authToken);
                googlePhotosData.setPicasawebService(picasawebService);
                new GetPhotoUrlsAsyncTask(googlePhotosData).execute();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
