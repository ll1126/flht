package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class Tag implements Serializable  {

	/**
	 * 标签
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标签ID
	 */
	private int ID;
	
	/**
	 * 标签名称
	 */
	
	private String Tag;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTag() {
		return Tag;
	}

	public void setTag(String tag) {
		Tag = tag;
	}

	@Override
	public String toString() {
		return "Tag [ID=" + ID + ", Tag=" + Tag + "]";
	}
	
	

}
