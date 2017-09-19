package com.walton.getgooglephotos.processor;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gdata.client.photos.PicasawebService;
import com.walton.getgooglephotos.module.GoogleContactData;
import com.walton.getgooglephotos.module.GoogleData;
import com.walton.getgooglephotos.module.GooglePhotosData;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class OnTokenAcquired implements AccountManagerCallback<Bundle> {
    Activity activity;
    private final int REQUEST_AUTHENTICATE;
    Services services;
    AsyncTask<Void,Void,Void> asyncTask;
    public OnTokenAcquired(GoogleData googleData, AsyncTask<Void,Void,Void> asyncTask) {
        activity = googleData.getActivity();
        services = googleData.getService();
        this.asyncTask = asyncTask;
        REQUEST_AUTHENTICATE = googleData.getREQUEST_AUTHENTICATE();
    }
    @Override
    public void run(AccountManagerFuture<Bundle> result) {
        try{
            Bundle bundle = result.getResult();
            if(bundle.containsKey(AccountManager.KEY_INTENT)){
                Intent intent = bundle.getParcelable(AccountManager.KEY_INTENT);
                int flags = intent.getFlags();
                intent.setFlags(flags);
                activity.startActivityForResult(intent,REQUEST_AUTHENTICATE);
                return;
            }
            if(bundle.containsKey(AccountManager.KEY_AUTHTOKEN)){
                final String authToken = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                services.setUserToken(authToken);
                asyncTask.execute();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
