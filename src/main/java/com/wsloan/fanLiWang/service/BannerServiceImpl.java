package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.dao.BannerDao;
import com.wsloan.fanLiWang.dao.ObjectListDao;
import com.wsloan.fanLiWang.entity.Banner;
import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.entity.RebateScheme;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
	@Resource 
	private BannerDao bannerDao;
	/**
	 * 录入PC端banner信息
	 * */
	public Integer addPCBanner(Banner banner) throws Exception{

		Integer number = bannerDao.addPCBanner(banner);
		if(number ==0){
			throw new Exception("录入失败");
		}
		return number;
		
	}

	public Integer addAPPBanner(Banner banner) {
		Integer number = bannerDao.addAPPBanner(banner);
		return number;
	}

	/**
	 * banner删除
	 * */
	public Integer deleteBanner(Integer bannerID) {
		int number = bannerDao.deleteBanner(bannerID);
		return number;
	}
	/**
	 * PC端banner的修改
	 * */
	public Integer updatePCBanner(Banner banner) {

		Integer number = bannerDao.updatePCBanner(banner);

		return number;
	}
	/**
	 * APP端banner的修改
	 * */
	public Integer updateAPPBanner(Banner banner) {

		Integer number = bannerDao.updateAPPBanner(banner);

		return number;
	}
	/**
	 * 获取一条banner信息
	 * */
	public Banner getOneBanner(Integer bannerID) {
		Banner banner = bannerDao.getOneBanner(bannerID);
		return banner;
	}
	
	/**
	 * 获取banner列表
	 * */
	public List<Banner> queryBanner() {

		List<Banner> list = null;
		list = bannerDao.queryBanner();
		return list;
	}

}
