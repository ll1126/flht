package com.wsloan.fanLiWang.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wsloan.fanLiWang.dao.ObjectListDao;
import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.entity.RebateScheme;

@Service
public class ObjectListServiceImpl implements ObjectListService {
	@Resource 
	private ObjectListDao objectListDao;
	/**
	 * 录入标的信息
	 * */
	public Integer addObject(ObjectList objectList) {
//		Date date = new Date();
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String objectUpTime = sdf.format(date);
		String zdljpc = objectList.getZdljpc().trim();
		String zdljapp = objectList.getZdljapp().trim();
		objectList.setZdljpc(zdljpc);
		objectList.setZdljapp(zdljapp);
		if(objectList.getObjectTian().equals("个月及以上")){
			int a = objectList.getObjectDeadline();
			int b = a*30;
			objectList.setZhuanWeiTian(b);
		}
		if(objectList.getObjectTian().equals("天及以上")){
			int a= objectList.getObjectDeadline();
			objectList.setZhuanWeiTian(a);
		}
		
		
		
		Integer number = objectListDao.addObject(objectList);
		if(number ==0){
			throw new ObjectListNotFoundException("录入标的信息失败");
		}
		return number;
		
	}
	/**
	 * 标的删除
	 * */
	public Integer deleteObject(Integer objectID) {
		List<RebateScheme> list = objectListDao.getAllScheme(objectID);
		int number = objectListDao.deleteObject(objectID);
		for(int i=0;i<list.size();i++){
			objectListDao.deleteAllSchemeList(list.get(i).getID());
		}
		if(number==0){
			throw new ObjectListNotFoundException("标的删除失败");
		}
		return number;
	}
	/**
	 * 标的的修改
	 * */
	public Integer update(ObjectList objectList) {
		String zdljpc = objectList.getZdljpc().trim();
		String zdljapp = objectList.getZdljapp().trim();
		objectList.setZdljpc(zdljpc);
		objectList.setZdljapp(zdljapp);
		if(objectList.getObjectTian().equals("个月及以上")){
			int a = objectList.getObjectDeadline();
			int b = a*30;
			objectList.setZhuanWeiTian(b);
		}
		if(objectList.getObjectTian().equals("天及以上")){
			int a= objectList.getObjectDeadline();
			objectList.setZhuanWeiTian(a);
		}
		Integer number = objectListDao.updateObject(objectList);
		
		if(number==0){
			return number;
		}
		return number;
	}
	/**
	 * 获取一条标的信息
	 * */
	public ObjectList getOneObject(Integer objectID) {
		ObjectList object = objectListDao.getOneObject(objectID);
		return object;
	}

	/**
	 * 获取标的列表
	 * */
	public List<ObjectList> getObjectList(String platform,Integer shangjia) {
		List<ObjectList> list = null;
		list = objectListDao.queryObjectList(platform,shangjia);
		return list;
	}


	public Integer updatePaixu(Integer paiXu,Integer id) {
		Integer numb = objectListDao.updatePaixu(paiXu,id);
		return  numb;
	}

}
