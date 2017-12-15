package com.wsloan.fanLiWang.service;

import java.util.List;

import com.wsloan.fanLiWang.entity.ObjectList;

public interface ObjectListService {
	/**
	 * 录入标的信息
	 * */

	Integer addObject(ObjectList objectList);
	/**
	 * 删除标的信息
	 * */
	Integer deleteObject(Integer objectID);
	
	/**
	 * 标的的修改
	 * */
	Integer update(ObjectList objectList);
	
	/**
	 * 获取标的列表
	 * */
	List<ObjectList> getObjectList(String platform,Integer shangjia);
	
	/**
	 * 查看一条标的详情
	 * */
	ObjectList getOneObject(Integer objectID);

	/*单独修改项目排序*/
	Integer updatePaixu(Integer paiXu,Integer id);
}
