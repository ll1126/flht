package com.wsloan.fanLiWang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.entity.RebateScheme;

public interface ObjectListDao {
	
	/**
	 * 标的信息录入
	 * */
	Integer addObject(ObjectList objectList);
	/**
	 * 标的删除
	 * */
	Integer deleteObject(Integer objectID);
	
	/**
	 * 标的的修改
	 * */
	Integer updateObject(ObjectList objectList);
	
	/**
	 * 标的列表批量查询
	 * */
	List<ObjectList> queryObjectList(@Param("platform") String platform,@Param("shangjia") Integer shangjia);
	
	/**
	 * 获取标的的总记录数
	 * */
	Integer getCountObject();
	
	/**
	 * 查看一条标的详细信息
	 * */
	ObjectList getOneObject(Integer objectID);
	
	

	/**
	 * 删除标的删除所有的返利方案
	 * */
	
	List<RebateScheme> getAllScheme(Integer ID);
	
	void deleteAllSchemeList(Integer ID);

	/*项目列表单独修改排序*/
	Integer updatePaixu(@Param("paixu") Integer paixu,@Param("id") Integer id);
}
