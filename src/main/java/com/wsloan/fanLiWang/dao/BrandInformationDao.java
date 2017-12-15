package com.wsloan.fanLiWang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.entity.ObjectList;

public interface BrandInformationDao {
	/**
	 * 录入平台信息
	 * */
	Integer addBrand(BrandInformation brandInformation);
	
	/**
	 * 平台信息删除
	 * */
	Integer deleteBrand(Integer brandID);
	
	/**
	 * 查询平台列表
	 * */
	
	List<BrandInformation> getBrandList(@Param("platform")String platform,@Param("shangjia") Integer shangjia);
	
	/**
	 * 总的平台数量
	 * */
	Integer getCountBrand();
	
	/**
	 * 获取一个平台详情
	 * */
	BrandInformation getBrandDetails(Integer brandID);
	
	/**
	 * 更新平台信息
	 * */
	Integer updateBrand(BrandInformation brandInformation);
	
	/**
	 * 删除平台删除所有的标
	 * */
	
	List<ObjectList> getAllObject(Integer ID);
	
	void deleteAllObjectList(Integer ID);

	/**
	 * 下架平台
	 * */
	Integer xiajiaBrand(@Param("brandID") Integer brandID,@Param("platState") Integer platState);

	/**
	 * 下架平台下的所有项目
	 * */
	Integer xiajiaObject(@Param("brandID") Integer brandID,@Param("platState")Integer platState);

	/**
	 *获取项目一个平台对应所有的项目的项目ID-
	 * */
	Integer getxiajiaObjectID(@Param("brandID") Integer brandID);

	/**
	 * 下架所有的返利方案
	 * */
	Integer xiajiaScheme(@Param("objectID") Integer objectID,@Param("platState")Integer platState);
}
