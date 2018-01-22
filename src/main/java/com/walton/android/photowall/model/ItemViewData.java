package com.walton.android.photowall.model;
public interface ItemViewData<T>{
	public void setPreviewData(T input);
	public void setContentData(T input);
	public T getPreviewData();
	public T getContentData();
}
