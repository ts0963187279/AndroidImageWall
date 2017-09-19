package com.walton.getgooglephotos.processor;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.common.AccountPicker;
import com.walton.getgooglephotos.module.GoogleData;
import com.walton.getgooglephotos.module.GooglePhotosData;

import static android.content.Context.ACCOUNT_SERVICE;

/**
 * Created by waltonmis on 2017/8/30.
 */

public class SelectGoogleAccount {
    Activity activity;
    AccountManager am;
    private final int PICK_ACCOUNT_REQUEST = 1;
    public SelectGoogleAccount(Activity activity){
        this.activity = activity;
        am = (AccountManager) activity.getSystemService(ACCOUNT_SERVICE);
    }
    public void select(){
        Intent intent = AccountPicker.newChooseAccountIntent(null,null,new String[]{"com.google"},false,null,null,null,null);
        activity.startActivityForResult(intent,PICK_ACCOUNT_REQUEST);
    }
}
