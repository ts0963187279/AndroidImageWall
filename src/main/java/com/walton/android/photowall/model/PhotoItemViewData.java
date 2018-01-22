package com.walton.android.photowall.model;

public class PhotoItemViewData implements ItemViewData<String>{
	private String previewData;
	private String contentData;
	public void setPreviewData(String input){
		this.previewData = input;
	}
	public void setContentData(String input){
		this.contentData = input;
	}
	public String getPreviewData(){
		return previewData;
	}
	public String getContentData(){
		return contentData;
	}
}
