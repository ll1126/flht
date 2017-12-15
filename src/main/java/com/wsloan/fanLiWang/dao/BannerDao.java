package com.wsloan.fanLiWang.dao;

import com.wsloan.fanLiWang.entity.Banner;
import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.entity.RebateScheme;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerDao {

	/**
	 * PC端banner录入
	 * */
	Integer addPCBanner(Banner banner);
	/*
	*APP端banner录入
	* */
	Integer addAPPBanner(Banner banner);
	/**
	 * banner删除
	 * */
	Integer deleteBanner(Integer bannerID);

	/**
	 * PC端banner修改
	 * */
	Integer updatePCBanner(Banner banner);

	/**
	 * APP端banner修改
	 * */
	Integer updateAPPBanner(Banner banner);

	/**
	 * 标的列表批量查询
	 * */
	List<Banner> queryBanner();
	
	/**
	 * 查看一条标的详细信息
	 * */
	Banner getOneBanner(Integer bannerID);
	
}
