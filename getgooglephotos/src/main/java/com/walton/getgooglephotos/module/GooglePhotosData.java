package com.walton.getgooglephotos.module;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;

import com.walton.getgooglephotos.processor.DoInBackground;
import com.google.gdata.client.photos.PicasawebService;

import java.net.URL;
import java.util.ArrayList;

import static android.content.Context.ACCOUNT_SERVICE;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class GooglePhotosData {
    private final int PICK_ACCOUNT_REQUEST = 1;
    private final int REQUEST_AUTHENTICATE = 2;
    private static final String API_PREFIX
            = "https://picasaweb.google.com/data/feed/api/user/";
    private PicasawebService picasawebService;
    private AccountManager accountManager;
    private Account[] list;
    private String selectedAccountName;
    private Account selectedAccount;
    private Activity activity;
    private String authToken;
    private ArrayList<URL> photoUrls;
    private DoInBackground doInBackground;
    public GooglePhotosData(Activity activity){
        this.activity = activity;
        accountManager = (AccountManager)activity.getSystemService(ACCOUNT_SERVICE);
        list = accountManager.getAccounts();
        photoUrls = new ArrayList<>();
    }
    public String getApiPrefix(){
        return API_PREFIX;
    }
    public Account getSelectedAccount(){
        return selectedAccount;
    }
    public String getSelectedAccountName(){
        return selectedAccountName;
    }
    public Account[] getList(){
        return list;
    }
    public AccountManager getAccountManager(){
        return accountManager;
    }
    public PicasawebService getPicasawebService(){
        return picasawebService;
    }
    public String getAuthToken(){
        return authToken;
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
    public ArrayList<URL> getPhotoUrls(){
        return photoUrls;
    }
    public void setSelectedAccount(Account selectedAccount){
        this.selectedAccount = selectedAccount;
    }
    public void setSelectedAccountName(String selectedAccountName){
        this.selectedAccountName = selectedAccountName;
    }
    public void setList(Account[] list){
        this.list = list;
    }
    public void setPicasawebService(PicasawebService picasawebService){
        this.picasawebService = picasawebService;
    }
    public void setAuthToken(String authToken){
        this.authToken = authToken;
    }
    public void setPhotoUrls(ArrayList<URL> photoUrls){
        this.photoUrls = photoUrls;
    }
    public void setDoInBackground(DoInBackground doInBackground){
        this.doInBackground = doInBackground;
    }
    public DoInBackground doInBackground(){
        return doInBackground;
    }
}
