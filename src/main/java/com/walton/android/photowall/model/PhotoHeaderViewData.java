package com.walton.android.photowall.model;

import com.walton.android.photowall.model.HeaderViewData;

public class PhotoHeaderViewData implements HeaderViewData<String>{
	private String sortString;
	private String content;
	public void setSortString(String sortString){
		this.sortString = sortString;
	}
	public String getSortString(){
		return sortString;
	}
	public void setContent(String input){
		this.content = input;
	}
	public String getContent(){
		return content;
	}
	public int compareTo(HeaderViewData headerViewData){
		return sortString.compareTo(headerViewData.getSortString());
	}
}
