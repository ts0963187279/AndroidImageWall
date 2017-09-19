package com.walton.getgooglephotos.processor;

import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.util.ServiceException;
import com.walton.getgooglephotos.module.GoogleContactData;

import java.io.IOException;
import java.net.URL;

/**
 * Created by waltonmis on 2017/9/19.
 */

public class GetContact {
    private GoogleContactData contactData;
    private ContactsService contactsService;
    public GetContact(GoogleContactData contactData){
        this.contactData = contactData;
        contactsService = contactData.getContactsService();
    }
    public <T extends ContactFeed> T getFeed(String feedHref, Class<T> feedClass) throws IOException, ServiceException {
        return contactsService.getFeed(new URL(feedHref), feedClass);
    }
    public void getContact(){
        try {
            ContactFeed contactFeed = getFeed(contactData.getApiPrefix(),ContactFeed.class);
            System.out.println(contactFeed.getTitle().getPlainText());
            for(ContactEntry entry : contactFeed.getEntries()){
                if(entry.hasName()){
                    System.out.println(entry.getTitle().getPlainText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
