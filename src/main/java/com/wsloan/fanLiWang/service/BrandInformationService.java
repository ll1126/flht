package com.wsloan.fanLiWang.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.BrandInformation;

public interface BrandInformationService {
	/**
	 * 录入平台信息
	 * */
	Integer addBrand(BrandInformation brandInformation);
	
	/**
	 * 删除平台信息
	 * */
	Integer deleteBrand(Integer brandID);
	
	/**
	 * 获取平台列表
	 * */
	List<BrandInformation> getBrandList(String platform,Integer shangjia);

	/**
	 * 平台详情
	 * */
	BrandInformation getBrandDetails(Integer brandID);
	
	/**
	 * 修改平台信息
	 * */
	Integer updateBrand(BrandInformation brandInformation);

	/**
	 * 下架平台，下架所有项目和返利方案
	 * */
	Integer xiajiaBrand(Integer brandID,Integer platState);
}
