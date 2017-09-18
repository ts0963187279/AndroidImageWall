package com.walton.getgooglephotos.processor;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;


import com.walton.getgooglephotos.module.GooglePhotosData;

import static android.app.Activity.RESULT_OK;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class ActivityResult {
    private Account[] list;
    private int PICK_ACCOUNT_REQUEST;
    private int REQUEST_AUTHENTICATE;
    private int requestCode;
    private int resultCode;
    private Intent data;
    private GooglePhotosData googlePhotosData;
    private AccountManager am;
    public ActivityResult(GooglePhotosData googlePhotosData, final int requestCode , final int resultCode , final Intent data){
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = data;
        this.googlePhotosData = googlePhotosData;
        list = googlePhotosData.getList();
        PICK_ACCOUNT_REQUEST = googlePhotosData.getPICK_ACCOUNT_REQUEST();
        REQUEST_AUTHENTICATE = googlePhotosData.getREQUEST_AUTHENTICATE();
        am = googlePhotosData.getAccountManager();
    }
    public void connectGooglePhotos(){
        if(requestCode == PICK_ACCOUNT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                for (Account a : list) {
                    if (a.name.equals(accountName)) {
                        googlePhotosData.setSelectedAccount(a);
                        break;
                    }
                }
                googlePhotosData.setSelectedAccountName(accountName);
                OnTokenAcquired onTokenAcquired = new OnTokenAcquired(googlePhotosData);
                am.getAuthToken(
                        googlePhotosData.getSelectedAccount(),
                        "lh2",
                        null,
                        googlePhotosData.getActivity(),
                        onTokenAcquired,
                        null);
            }
        }
        if(requestCode == REQUEST_AUTHENTICATE) {
            if (resultCode == RESULT_OK) {
                am.getAuthToken(
                        googlePhotosData.getSelectedAccount(),
                        "lh2",
                        null,
                        googlePhotosData.getActivity(),
                        new OnTokenAcquired(googlePhotosData),
                        null);
            }
        }
    }
}
