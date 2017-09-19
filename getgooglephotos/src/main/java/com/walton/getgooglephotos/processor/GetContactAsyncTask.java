package com.walton.getgooglephotos.processor;

import android.os.AsyncTask;

import com.walton.getgooglephotos.module.GoogleContactData;

/**
 * Created by waltonmis on 2017/9/19.
 */

public class GetContactAsyncTask extends AsyncTask<Void,Void,Void> {
    private GoogleContactData googleContactData;
    private GetContact getContact;
    public GetContactAsyncTask(GoogleContactData googleContactData){
        this.googleContactData = googleContactData;
        getContact = new GetContact(googleContactData);
    }
    @Override
    protected Void doInBackground(Void... voids) {
        getContact.getContact();
        return null;
    }
    protected void onPostExecute(Void test)
    {
    }
}
