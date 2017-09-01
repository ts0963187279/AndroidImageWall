package com.walton.android.photowall.processor;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.codewaves.stickyheadergrid.StickyHeaderGridLayoutManager;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.ServiceForbiddenException;
import com.walton.android.photowall.listener.ExitSelectModOnKeyListener;
import com.walton.android.photowall.listener.ItemViewOnClickListener;
import com.walton.android.photowall.listener.MyHeaderDoubleClickListener;
import com.walton.android.photowall.listener.MyHeaderLongClickListener;
import com.walton.android.photowall.listener.MyHeaderOnClickListener;
import com.walton.android.photowall.listener.MyItemDoubleClickListener;
import com.walton.android.photowall.listener.MyItemLongClickListener;
import com.walton.android.photowall.listener.MyItemSelectModOnClickListener;
import com.walton.android.photowall.listener.MySelectModMenuClickListener;
import com.walton.android.photowall.listener.MyViewModMenuClickListener;
import com.walton.android.photowall.model.GooglePhotosData;
import com.walton.android.photowall.processer.PhotoWallAdapter;

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
    private PhotoWallAdapter photoWallAdapter;
    private Activity activity;
    private RecyclerView recyclerView;
    private Toolbar viewModToolBar;
    private Toolbar selectModToolBar;
    private TreeMap<String,ArrayList<String>> strTreeMap;
    public GetPhotoUrlsAsyncTask(GooglePhotosData googlePhotosData){
        this.googlePhotosData = googlePhotosData;
        activity = googlePhotosData.getActivity();
        recyclerView = googlePhotosData.getRecyclerView();
        getPhotos = new GetPhotos(googlePhotosData);
        viewModToolBar = googlePhotosData.getViewModToolBar();
        selectModToolBar = googlePhotosData.getSelectModToolBar();
    }
    @Override
    protected Void doInBackground(Void... voids) {
        List<AlbumEntry> albums;
        strTreeMap = new TreeMap<>();
        System.out.println("Thread.currentThread : " + Thread.currentThread());
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
        System.out.println(strTreeMap.size());
        photoWallAdapter = new PhotoWallAdapter(activity.getApplicationContext(),strTreeMap);
        googlePhotosData.setPhotoWallAdapter(photoWallAdapter);
        selectModToolBar.setOnMenuItemClickListener(new MySelectModMenuClickListener(photoWallAdapter));
        viewModToolBar.setOnMenuItemClickListener(new MyViewModMenuClickListener(photoWallAdapter));
        photoWallAdapter.setViewModToolBar(viewModToolBar);
        photoWallAdapter.setSelectModToolBar(selectModToolBar);
        photoWallAdapter.setItemCellViewCreator(new MyItemViewCreator(activity.getApplicationContext()));
        photoWallAdapter.setHeaderViewCreator(new MyHeaderViewCreator(activity.getApplicationContext()));
        photoWallAdapter.setItemViewOnClickListener(new ItemViewOnClickListener());
        photoWallAdapter.setSelectModHeaderLongClickListener(new MyHeaderLongClickListener());
        photoWallAdapter.setSelectModHeaderOnClickListener(new MyHeaderOnClickListener());
        photoWallAdapter.setSelectModItemLongClickListener(new MyItemLongClickListener());
        photoWallAdapter.setSelectModItemOnClickListener(new MyItemSelectModOnClickListener());
        photoWallAdapter.setHeaderViewOnDoubleClickListener(new MyHeaderDoubleClickListener());
        photoWallAdapter.setItemViewOnDoubleClickListener(new MyItemDoubleClickListener());
        photoWallAdapter.setTreeMapComparator(new MyTreeMapComparator());
        photoWallAdapter.setArrayListComparator(new MyArrayListComparator());
        recyclerView.setLayoutManager(new StickyHeaderGridLayoutManager(4));
        recyclerView.setOnKeyListener(new ExitSelectModOnKeyListener(photoWallAdapter));
        recyclerView.setAdapter(photoWallAdapter);
    }
}
