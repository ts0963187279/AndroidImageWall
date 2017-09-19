package com.walton.getgooglephotos.processor;

import android.accounts.AccountManager;

import com.walton.getgooglephotos.module.GoogleContactData;

/**
 * Created by waltonmis on 2017/9/19.
 */

public class GetGoogleContactToken implements GetToken {
    GoogleContactData contactData;
    public GetGoogleContactToken(GoogleContactData contactData){
        this.contactData = contactData;
    }
    @Override
    public void getToken() {
        AccountManager am = contactData.getAccountManager();
        OnTokenAcquired onTokenAcquired = new OnTokenAcquired(contactData,new GetContactAsyncTask(contactData));
        am.getAuthToken(
                contactData.getSelectedAccount(),
                "cp",
                null,
                contactData.getActivity(),
                onTokenAcquired,
                null);
    }
}
