package com.wsloan.fanLiWang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.RebateScheme;

public interface RebateSchemeDao {
	/**
	 * 返利方案录入
	 * */
	Integer addScheme(RebateScheme rebateScheme);

	/**
	 * 获取返利方案列表
	 * */
	List<RebateScheme> getScheme(@Param("objectID")Integer objectID,@Param("objectName") String objectName,@Param("shangjia") Integer shangjia);
	
	/**
	 * 删除返利方案
	 * */
	Integer deleteScheme(@Param("schemeID")Integer schemeID);
	
	/**
	 * 修改方案
	 * */
	Integer updateScheme(RebateScheme rebateScheme);
	
	/**
	 * 获取一条返利方案详情
	 * */
	RebateScheme getOneScheme(@Param("schemeID") Integer schemeID );
}
