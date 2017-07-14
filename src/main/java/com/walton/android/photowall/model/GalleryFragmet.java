package com.walton.android.photowall.model;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import start.android.library.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragmet extends Fragment {
    public GalleryFragmet() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery_fragmet,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.bigimg);
        return view;
    }

}
