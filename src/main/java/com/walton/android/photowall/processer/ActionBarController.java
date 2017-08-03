package com.walton.android.photowall.processer;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by waltonmis on 2017/8/3.
 */

public class ActionBarController {
    private AppCompatActivity appCompatActivity;
    public ActionBarController(AppCompatActivity appCompatActivity){
        this.appCompatActivity = appCompatActivity;
    }
    public void setHomeButtonEnabled(boolean enabled){
        appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(enabled);
    }
}
