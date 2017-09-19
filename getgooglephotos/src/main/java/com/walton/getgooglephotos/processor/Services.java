package com.walton.getgooglephotos.processor;

import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.client.photos.PicasawebService;

/**
 * Created by waltonmis on 2017/9/19.
 */

public class Services {
    private PicasawebService picasawebService;
    private ContactsService contactsService;
    public Services(PicasawebService picasawebService){
        this.picasawebService = picasawebService;
    }
    public Services(ContactsService contactsService){
        this.contactsService = contactsService;
    }
    public void setUserToken(String token){
        if(picasawebService != null)
            picasawebService.setUserToken(token);
        if(contactsService != null)
            contactsService.setUserToken(token);
    }
    public ContactsService getContactsService(){
        return contactsService;
    }
    public PicasawebService getPicasawebService(){
        return picasawebService;
    }
}
