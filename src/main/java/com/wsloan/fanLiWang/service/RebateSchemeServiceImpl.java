package com.wsloan.fanLiWang.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsloan.fanLiWang.dao.RebateSchemeDao;
import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.entity.RebateScheme;

@Service
public class RebateSchemeServiceImpl implements RebateSchemeService {
	@Resource 
	private RebateSchemeDao rebateSchemeDao;
	/**
	 * 录入返利方案
	 * */
	public Integer addScheme(RebateScheme rebateScheme) {
		Integer number = rebateSchemeDao.addScheme(rebateScheme);
		if(number==0){
			return null;
		}
		return number;
	}
	
	/**
	 * 获取返利方案列表
	 * */
	public List<RebateScheme> getScheme(Integer objectID,String objectName,Integer shangjia) {
		List<RebateScheme> list = null;
		list = rebateSchemeDao.getScheme(objectID,objectName,shangjia);
		return list;
	}

	/**
	 * 删除返利方案
	 * */
	public Integer deleteScheme(Integer schemeID) {
		Integer number = rebateSchemeDao.deleteScheme(schemeID);
		if(number==0){
			return number;
		}
		return number;
	}

	public Integer updateScheme(RebateScheme rebateScheme) {
//		System.out.println(rebateScheme);
		Integer number = rebateSchemeDao.updateScheme(rebateScheme);
		return number;
	}

	public RebateScheme getOneScheme(Integer schemeID) {
		RebateScheme rebateScheme = rebateSchemeDao.getOneScheme(schemeID);
		return rebateScheme;
	}
	
	
}
