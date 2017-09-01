package com.walton.android.photowall.processor;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.GphotoFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;
import com.google.gdata.util.ServiceException;
import com.walton.android.photowall.model.GooglePhotosData;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class GetPhotos {
    private PicasawebService picasawebService;
    private GooglePhotosData googlePhotosData;

    public GetPhotos(GooglePhotosData googlePhotosData) {
        this.googlePhotosData = googlePhotosData;
    }

    public <T extends GphotoFeed> T getFeed(String feedHref, Class<T> feedClass) throws IOException, ServiceException {
        picasawebService = googlePhotosData.getPicasawebService();
        return picasawebService.getFeed(new URL(feedHref), feedClass);
    }

    public List<AlbumEntry> getAlbums(String userID) throws IOException, ServiceException {
        String albumUrl = googlePhotosData.getApiPrefix() + userID;
        UserFeed userFeed = getFeed(albumUrl, UserFeed.class);
        List<GphotoEntry> entries = userFeed.getEntries();
        List<AlbumEntry> albums = new ArrayList<>();
        for (GphotoEntry gp : entries) {
            AlbumEntry ae = new AlbumEntry(gp);
            albums.add(ae);
        }
        return albums;
    }
    public List<PhotoEntry> getPhoto(String userID, AlbumEntry album) throws IOException, ServiceException {
        AlbumFeed feed = album.getFeed();
        List<PhotoEntry> photos = new ArrayList<>();
        for (GphotoEntry entry : feed.getEntries()) {
            PhotoEntry pe = new PhotoEntry(entry);
            photos.add(pe);
        }
        return photos;
    }
}