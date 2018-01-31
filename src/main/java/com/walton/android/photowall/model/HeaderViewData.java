package com.walton.android.photowall.model;

public interface HeaderViewData extends Comparable<HeaderViewData>{
	public void setSortString(String sortString);
	public String getSortString();
	public int compareTo(HeaderViewData headerViewData);
}
