package com.example.getgooglephotos.processor;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;

import com.example.getgooglephotos.module.GooglePhotosData;
import com.google.android.gms.common.AccountPicker;

import static android.content.Context.ACCOUNT_SERVICE;

/**
 * Created by waltonmis on 2017/8/30.
 */

public class GetGooglePhotos {
    Activity activity;
    AccountManager am;
    Account[] list;
    private final int PICK_ACCOUNT_REQUEST = 1;
    public GetGooglePhotos(GooglePhotosData googlePhotosData){
        activity = googlePhotosData.getActivity();
        am = (AccountManager) activity.getSystemService(ACCOUNT_SERVICE);
        list = googlePhotosData.getList();
    }
    public void get(){
        Intent intent = AccountPicker.newChooseAccountIntent(null,null,new String[]{"com.google"},false,null,null,null,null);
        activity.startActivityForResult(intent,PICK_ACCOUNT_REQUEST);
    }
}
