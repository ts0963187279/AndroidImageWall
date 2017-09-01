package com.walton.android.photowall.processor;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;


import com.walton.android.photowall.model.GooglePhotosData;

import static android.app.Activity.RESULT_OK;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class ActivityResult {
    public ActivityResult(GooglePhotosData googlePhotosData, final int requestCode , final int resultCode , final Intent data){
        Account[] list = googlePhotosData.getList();
        int PICK_ACCOUNT_REQUEST = googlePhotosData.getPICK_ACCOUNT_REQUEST();
        int REQUEST_AUTHENTICATE = googlePhotosData.getREQUEST_AUTHENTICATE();
        AccountManager am = googlePhotosData.getAccountManager();
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
