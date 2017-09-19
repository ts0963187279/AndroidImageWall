package com.walton.getgooglephotos.module;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Service;

import com.walton.getgooglephotos.processor.OnBackGroundResult;
import com.walton.getgooglephotos.processor.Services;

import static android.content.Context.ACCOUNT_SERVICE;

/**
 * Created by waltonmis on 2017/9/19.
 */

public abstract class GoogleData {
    private final int PICK_ACCOUNT_REQUEST = 1;
    private final int REQUEST_AUTHENTICATE = 2;
    private AccountManager accountManager;
    private Account selectedAccount;
    private Activity activity;
    private OnBackGroundResult onBackGroundResult;
    private Services services;
    public GoogleData(Activity activity)
    {
        this.activity = activity;
        accountManager = (AccountManager)activity.getSystemService(ACCOUNT_SERVICE);
    }
    public void setSelectedAccount(Account selectedAccount){
        this.selectedAccount = selectedAccount;
    }
    public Account getSelectedAccount(){
        return selectedAccount;
    }
    public AccountManager getAccountManager(){
        return accountManager;
    }
    public int getPICK_ACCOUNT_REQUEST(){
        return PICK_ACCOUNT_REQUEST;
    }
    public int getREQUEST_AUTHENTICATE(){
        return REQUEST_AUTHENTICATE;
    }
    public Activity getActivity(){
        return activity;
    }
    public void setOnBackGroundResult(OnBackGroundResult onBackGroundResult){
        this.onBackGroundResult = onBackGroundResult;
    }
    public OnBackGroundResult onBackGroundResult(){
        return onBackGroundResult;
    }
    public void setService(Services service){
        this.services = service;
    }
    public Services getService(){
        return services;
    }
}
