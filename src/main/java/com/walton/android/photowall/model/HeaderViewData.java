package com.walton.android.photowall.model;

public interface HeaderViewData<T> extends Comparable<HeaderViewData>{
	public void setSortString(String sortString);
	public String getSortString();
	public void setContent(T input);
	public T getContent();
	public int compareTo(HeaderViewData headerViewData);
}
