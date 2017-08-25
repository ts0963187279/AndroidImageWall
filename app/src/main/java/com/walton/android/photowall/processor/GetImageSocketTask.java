package com.walton.android.photowall.processor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ImageView;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by waltonmis on 2017/8/22.
 */

public class GetImageSocketTask extends AsyncTask<Uri, Integer, Bitmap>{
    ImageView imageView;
    Bitmap bitmap;
    String host;
    int port;
    public GetImageSocketTask(ImageView imageView){
        this.imageView = imageView;
    }
    public void setPort(int port){
        this.port = port;
    }
    public void setHost(String host){
        this.host = host;
    }
    @Override
    protected Bitmap doInBackground(Uri... uris) {
        DataOutputStream dataOutputStream;
        DataInputStream dataInputStream;
        try {
            long submitTime = SystemClock.elapsedRealtime();
            System.out.println("連結 " + host+ " 中");
            Socket socket = new Socket(host, port);
            System.out.println("連結 " + host + " 成功");
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(uris[0].toString());
            System.out.println("接收中");
            int size = dataInputStream.readInt();
            byte[] temp = new byte[2048];
            byte[] buffer =new byte[size];
            int len  = 0;
            int tlen;
            while(len < size){
                tlen = dataInputStream.read(temp);
                for(int i=0;i < tlen;i++) {
                    buffer[len++] = temp[i];
                }
                System.out.println(len);
            }
            bitmap = BitmapFactory.decodeByteArray(buffer,0,len);
            System.out.println("接收"+uris[0].toString()+"完成");
            long endTime = SystemClock.elapsedRealtime();
            System.out.println("花費 :"+(endTime - submitTime));
        }catch (Exception e){
            System.out.println("連結中斷");
            System.out.println(e);
        }
        return bitmap;
    }
    protected void onPostExecute(Bitmap result)
    {
        imageView.setImageBitmap(result);
    }
}

