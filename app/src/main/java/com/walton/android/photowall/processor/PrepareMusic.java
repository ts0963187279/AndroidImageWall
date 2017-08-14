package com.walton.android.photowall.processor;



import com.walton.android.photowall.R;

import java.util.ArrayList;

/**
 * Created by waltonmis on 2017/8/11.
 */

public class PrepareMusic {
    ArrayList<Integer> musicList;
    public PrepareMusic() {
        musicList = new ArrayList<>();
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
        musicList.add(R.raw.alternate);
        musicList.add(R.raw.beat_your_competition);
        musicList.add(R.raw.abadf);
        musicList.add(R.raw.about_that_oldie);
    }
    public Integer getMusic(int i){
        return musicList.get(i);
    }
}
