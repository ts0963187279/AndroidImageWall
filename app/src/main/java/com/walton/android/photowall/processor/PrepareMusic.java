package com.walton.android.photowall.processor;



import com.walton.android.photowall.R;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/11.
 */

public class PrepareMusic {
    ArrayList<Integer> musicList;
    public PrepareMusic(){
        musicList = new ArrayList<>();
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.blue_skies);
        musicList.add(R.raw.bsfggs);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.easy_day);
        musicList.add(R.raw.etrerst);
        musicList.add(R.raw.fghdfhgfghf);
        musicList.add(R.raw.going_going_gone);
        musicList.add(R.raw.hgfdh);
        musicList.add(R.raw.hhfghfdgh);
        musicList.add(R.raw.hhhhh);
        musicList.add(R.raw.hit_my_soul);
        musicList.add(R.raw.jujf);
        musicList.add(R.raw.qerterg);
        musicList.add(R.raw.qrqwer);
        musicList.add(R.raw.rtyesdfg);
        musicList.add(R.raw.rtyrtya);
        musicList.add(R.raw.sdfgfds);
        musicList.add(R.raw.sghdfg);
        musicList.add(R.raw.wertgg);
        musicList.add(R.raw.jujf);
        musicList.add(R.raw.going_going_gone);
        musicList.add(R.raw.sdfgfds);
    }
    public Integer getMusic(int i){
        return musicList.get(i);
    }
}
