package com.wsloan.fanLiWang.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsloan.fanLiWang.dao.BrandInformationDao;
import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.entity.ObjectList;

@Service
public class BrandInformationServiceImpl implements BrandInformationService {
	@Resource
	private BrandInformationDao brandInformationDao;
	
	/**
	 * 增加平台信息
	 * */
	public Integer addBrand(BrandInformation brandInformation) {
		
		Integer fenshu = Integer.parseInt(brandInformation.getRiskAssessment().toString());
		if(0<=fenshu && fenshu<=15){ //0~15分
			brandInformation.setFengxianbq("风险极高");
		}else if(fenshu<=24){// 16~24分
			brandInformation.setFengxianbq("风险偏高");
		}else if(fenshu<=40){// 25~40分
			brandInformation.setFengxianbq("风险一般");
		}else if(fenshu<=60){// 41~60分
			brandInformation.setFengxianbq("风险偏低");
		}else{
			brandInformation.setFengxianbq("风险极低");
		}
		
		Integer number = brandInformationDao.addBrand(brandInformation);
		if(number==0){
			return null;
		}
		return number;
	}
	/**
	 * 删除对应平台
	 * */
	public Integer deleteBrand(Integer brandID) {
		
		List<ObjectList> list = brandInformationDao.getAllObject(brandID);
		Integer number = brandInformationDao.deleteBrand(brandID);
		for(ObjectList ob:list){
			System.out.println(ob);
			
		}
		for(int i=0;i<list.size();i++){
			brandInformationDao.deleteAllObjectList(list.get(i).getID());
		}
		
		if(number==0){
			return null;
		}
		return number;
	}
	
	/**
	 * 获取平台列表
	 * */
	public List<BrandInformation> getBrandList(String platform,Integer shangjia) {
//		Integer min = (page-1)*pageSize-1;//计算该页显示几到几条
//		Integer max = page*pageSize;
		List<BrandInformation> list = null;
		list = brandInformationDao.getBrandList(platform,shangjia);
//		Map<Integer,Object> map= new HashMap<Integer,Object>();
//		int number = brandInformationDao.getCountBrand();
//		map.put(number, list);
		return list;
	}
	
	/**
	 * 平台详情
	 * */
	public BrandInformation getBrandDetails(Integer brandID) {
		BrandInformation brandInformation = brandInformationDao.getBrandDetails(brandID);
		return brandInformation;
	}
	/**
	 * 修改平台详情
	 * */
	public Integer updateBrand(BrandInformation brandInformation) {
		Integer fenshu = Integer.parseInt(brandInformation.getRiskAssessment().toString());
		if(0<=fenshu && fenshu<=15){ //0~15分
			brandInformation.setFengxianbq("风险极高");
		}else if(fenshu<=24){// 16~24分
			brandInformation.setFengxianbq("风险偏高");
		}else if(fenshu<=40){// 25~40分
			brandInformation.setFengxianbq("风险一般");
		}else if(fenshu<=60){// 41~60分
			brandInformation.setFengxianbq("风险偏低");
		}else{
			brandInformation.setFengxianbq("风险极低");
		}
		Integer number = brandInformationDao.updateBrand(brandInformation);
		if(number==0){
			return null;
		}
		return number;
	}

	public Integer xiajiaBrand(Integer brandID,Integer platState) {

		Integer a = brandInformationDao.xiajiaBrand(brandID,platState);
		Integer b = brandInformationDao.xiajiaObject(brandID,platState);
		Integer objectID = brandInformationDao.getxiajiaObjectID(brandID);
	    Integer c = brandInformationDao.xiajiaScheme(objectID,platState);
		return b;
	}


}
