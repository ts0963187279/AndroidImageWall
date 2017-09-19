package com.walton.getgooglephotos.processor;

import android.net.Uri;
import android.os.AsyncTask;

import com.walton.getgooglephotos.module.GooglePhotosData;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.ServiceForbiddenException;

import java.io.IOException;
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
    private TreeMap<String,ArrayList<String>> strTreeMap;
    public GetPhotoUrlsAsyncTask(GooglePhotosData googlePhotosData){
        this.googlePhotosData = googlePhotosData;
        getPhotos = new GetPhotos(googlePhotosData);
    }
    @Override
    protected Void doInBackground(Void... voids) {
        List<AlbumEntry> albums;
        strTreeMap = new TreeMap<>();
        try{
            selectedAccountName = googlePhotosData.getSelectedAccount().name;
            albums = getPhotos.getAlbums(selectedAccountName);
            for(AlbumEntry mAlbum : albums){
                List<PhotoEntry> mPhotos = getPhotos.getPhoto(mAlbum);
                ArrayList<String> imageUrls = new ArrayList<>();
                for(PhotoEntry mPhoto : mPhotos) {
                    imageUrls.add(Uri.parse(mPhoto.getMediaContents().get(0).getUrl()).toString());
                }
                if(imageUrls.size() != 0)
                    strTreeMap.put(mAlbum.getTitle().getPlainText().toString(),imageUrls);
            }
        }catch(ServiceForbiddenException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ServiceException e){
            e.printStackTrace();
        }
        return null;
    }
    protected void onPostExecute(Void test)
    {
        System.out.println("onPostExecute " + strTreeMap.size());
        googlePhotosData.onBackGroundResult().doIt(strTreeMap);
    }
}
