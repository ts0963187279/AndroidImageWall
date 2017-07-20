package com.walton.android.photowall.processer;

import android.support.v7.widget.GridLayoutManager;

/**
 * Created by waltonmis on 2017/7/18.
 */

public class MySpanSizeLookup extends GridLayoutManager.SpanSizeLookup {
    private int[] TitlePosition;
    private int row;
    private int numberOfTitle;
    public MySpanSizeLookup(int[] TitlePosition,int row){
        this.TitlePosition = TitlePosition;
        this.row = row;
    }
    @Override
    public int getSpanSize(int position) {
        for(int i=0;i<TitlePosition.length;i++){
            if(position <= TitlePosition[i]){
                numberOfTitle = i;
                break;
            }else if(position > TitlePosition[TitlePosition.length-2]){
                numberOfTitle = TitlePosition.length-1;
                break;
            }
        }
        return position == TitlePosition[numberOfTitle] ? row:1;
    }
}
