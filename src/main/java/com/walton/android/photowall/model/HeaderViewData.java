package com.walton.android.photowall.model;

public interface HeaderViewData<T> extends Comparable<HeaderViewData>{
	public void setSortString(String sortString);
	public String getSortString();
	public void setContentData(T input);
	public T getContentData();
	public int compareTo(HeaderViewData headerViewData);
}
