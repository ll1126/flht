package com.wsloan.fanLiWang.service;

import java.util.List;

import com.wsloan.fanLiWang.entity.Notice;

public interface NoticeService {
	/**
	 * 录入标的信息
	 * */

	Integer addNotice(Notice notice);
	/**
	 * 公告的信息
	 * */
	Integer deleteNotice(Integer noticeID);
//	
	/**
	 * 标的的修改
	 * */
	Integer update(Notice notice);
	
	/**
	 * 获取公告列表
	 * */
	List<Notice> getNoticeList();
	
	/**
	 * 查看一条公告详情
	 * */
	Notice getOneNotice(Integer noticeID);
}
