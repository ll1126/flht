package com.wsloan.fanLiWang.service;

import java.util.List;

import com.wsloan.fanLiWang.entity.RebateScheme;

public interface RebateSchemeService {
	/**
	 * 录入返利方案
	 * */
	
	Integer addScheme(RebateScheme rebateScheme);
	
	/**
	 * 返利方案列表
	 * */
	List<RebateScheme> getScheme(Integer objectID,String objectName,Integer shangjia);
	
	/**
	 * 删除返利方案
	 * */
	Integer deleteScheme(Integer schemeID);
	
	/**
	 * 方案的修改
	 * */
	
	Integer updateScheme(RebateScheme rebateScheme);
	
	/**
	 * 获取一条方案详情
	 * */
	RebateScheme getOneScheme(Integer schemeID);
}
