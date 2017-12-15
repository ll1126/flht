package com.wsloan.fanLiWang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsloan.fanLiWang.dao.NoticeDao;
import com.wsloan.fanLiWang.entity.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	@Resource 
	private NoticeDao noticeDao;
	/**
	 * 录入公告信息
	 * */
	public Integer addNotice(Notice notice) {
		Integer number = noticeDao.addNotice(notice);
		if(number==0){
			return number;
		}
		return number;
	}

	
	/**
	 * 公告的删除
	 * */
	public Integer deleteNotice(Integer noticeID){
		Integer number = noticeDao.deleteNotice(noticeID);
		if(number==0){
			return number;
		}
		return number;
	}
	
	/**
	 * 公告列表
	 * */
	public List<Notice> getNoticeList(){
		List<Notice> list = null;
		list = noticeDao.getNoticeList();
		return list;
	}


	public Notice getOneNotice(Integer noticeID) {
		Notice notice = noticeDao.getOneNotice(noticeID);
		return notice;
	}


	public Integer update(Notice notice) {
		Integer number = noticeDao.updateNotice(notice);
		return number;
	}
}
