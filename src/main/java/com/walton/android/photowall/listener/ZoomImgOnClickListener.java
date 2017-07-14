package com.walton.android.photowall.listener;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.walton.android.photowall.model.GalleryFragmet;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/13.
 */

public class ZoomImgOnClickListener implements View.OnClickListener{
    private RecyclerView recyclerView;
    private Context context;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    public ZoomImgOnClickListener(Context context , RecyclerView recyclerView , FragmentManager fragmentManager){
        this.context = context;
        this.recyclerView = recyclerView;
        this.fragmentManager = fragmentManager;
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(context,"Click me",Toast.LENGTH_SHORT).show();
        GalleryFragmet galleryFragmet = new GalleryFragmet();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        //fragmentTransaction.replace(R.id.full,galleryFragmet);
        //fragmentTransaction.commit();
    }
}
