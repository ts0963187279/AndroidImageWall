package com.example.getgooglephotos.processor;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;

import com.example.getgooglephotos.module.GooglePhotosData;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.ServiceForbiddenException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by waltonmis on 2017/8/30.
 */

public class GetPhotoUrlsAsyncTask extends AsyncTask<Void,Void,Void> {
    private String selectedAccountName;
    private GetPhotos getPhotos;
    private GooglePhotosData googlePhotosData;
    private ArrayList<URL> photoUrls;
    private Activity activity;
    private TreeMap<String,ArrayList<String>> strTreeMap;
    public GetPhotoUrlsAsyncTask(GooglePhotosData googlePhotosData){
        this.googlePhotosData = googlePhotosData;
        activity = googlePhotosData.getActivity();
        getPhotos = new GetPhotos(googlePhotosData);
    }
    @Override
    protected Void doInBackground(Void... voids) {
        List<AlbumEntry> albums;
        strTreeMap = new TreeMap<>();
        try{
            selectedAccountName = googlePhotosData.getSelectedAccountName();
            albums = getPhotos.getAlbums(selectedAccountName);
            photoUrls = new ArrayList<>();
            for(AlbumEntry mAlbum : albums){
                List<PhotoEntry> mPhotos = getPhotos.getPhoto(selectedAccountName,mAlbum);
                ArrayList<String> strs = new ArrayList<>();
                for(PhotoEntry mPhoto : mPhotos) {
                    strs.add(Uri.parse(mPhoto.getMediaContents().get(0).getUrl()).toString());
                }
                if(strs.size() != 0)
                    strTreeMap.put(mAlbum.getTitle().toString(),strs);
            }
            googlePhotosData.setPhotoUrls(photoUrls);
        }catch(ServiceForbiddenException e){
            System.out.println("Token expired, invalidating");
            googlePhotosData.getAccountManager().invalidateAuthToken("com.google",googlePhotosData.getAuthToken());
        }catch(IOException e){
            System.out.println(e);
        }catch(ServiceException e){
            System.out.println(e);
        }
        System.out.println(googlePhotosData.getPhotoUrls().size());
        return null;
    }
    protected void onPostExecute(Void test)
    {
        System.out.println("onPostExecute" + strTreeMap.size());
        googlePhotosData.doInBackground().doIt(strTreeMap);
    }
}
