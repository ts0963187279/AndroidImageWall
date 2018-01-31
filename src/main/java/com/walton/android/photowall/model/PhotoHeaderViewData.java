package com.walton.android.photowall.model;

import com.walton.android.photowall.model.HeaderViewData;

public class PhotoHeaderViewData implements HeaderViewData{
	private String sortString;
	public void setSortString(String sortString){
		this.sortString = sortString;
	}
	public String getSortString(){
		return sortString;
	}
	public int compareTo(HeaderViewData headerViewData){
		return sortString.compareTo(headerViewData.getSortString());
	}
}
