package com.walton.android.photowall.processer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by waltonmis on 2017/7/17.
 */

public class GetFileCreateDate {
    private String Date;
    private File file;
    private Calendar calendar;
    public GetFileCreateDate(File file){
        this.file = file;
    }
    public String GetCreateDate(){
        calendar = Calendar.getInstance();
        calendar.setTimeInMillis(file.lastModified());
        Date = new SimpleDateFormat().format(calendar.getTime());
        return Date;
    }
    public String GetCreateYear(){
        return String.valueOf(calendar.get(Calendar.YEAR));
    }
}
