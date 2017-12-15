package com.wsloan.fanLiWang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.Notice;

public interface NoticeDao {
	
	/**
	 * 公告信息录入
	 * */
	Integer addNotice(Notice notice);
	/**
	 * 公告的删除
	 * */
	Integer deleteNotice(@Param("noticeID")Integer noticeID);
	
	/**
	 * 标的的修改
	 * */
	Integer updateNotice(Notice notice);
	
	/**
	 * 公告列表批量查询
	 * */
	List<Notice> getNoticeList();
	
//	/**
//	 * 获取标的的总记录数
//	 * */
//	Integer getCountObject();
//	
	/**
	 * 查看公告详细信息
	 * */
	Notice getOneNotice(@Param("noticeID")Integer noticeID);
	
	
}
