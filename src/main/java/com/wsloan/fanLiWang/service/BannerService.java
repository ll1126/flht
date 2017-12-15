package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.entity.Banner;
import com.wsloan.fanLiWang.entity.ObjectList;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BannerService {
	/**
	 * PC端banner的录入
	 * */

	Integer addPCBanner(Banner banner) throws Exception;
	/*
	* APP端banner录入
	* */
	Integer addAPPBanner(Banner banner);
	/**
	 * 删除banner信息
	 * */
	Integer deleteBanner(Integer bannerID);

	/**
	 * PC端banenr的修改
	 * */
	Integer updatePCBanner(Banner banner);

	/**
	 * APP端banenr的修改
	 * */
	Integer updateAPPBanner(Banner banner);

	/**
	 * 获取banner列表
	 * */
	List<Banner> queryBanner();
	
	/**
	 * 查看一条banner详情
	 * */
	Banner getOneBanner(Integer bannerID);
}
