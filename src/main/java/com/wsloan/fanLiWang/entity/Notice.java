package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class Notice implements Serializable{

	/**
	 * 后台公告
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 公告标题
	 * */
	private Integer ID;
	/**
	 * 公告标题
	 * */
	private String noticeTitle;
	/**
	 * 公告内容
	 * */
	private String noticeContent;
	/**
	 * 时间
	 * */
	private String noticeTime;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}
	@Override
	public String toString() {
		return "Notice [noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent + ", noticeTime=" + noticeTime
				+ "]";
	}


}
