package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.entity.CountMessage;

import java.util.List;
import java.util.Map;

public interface CountMessageService {
	/**
	 * 返回统计的实体类
	 * */
	List<CountMessage> getCountMessage(String submissionTimeStart, String submissionTimeEnd);

	/**
	 * 获取昨日统计的数据
	 * */
	List<Map> getZuoRiShuJu(String date_start,String date_end);

	/*获取总的数据信息*/
	List<Map> getTotalShuJu();

}
