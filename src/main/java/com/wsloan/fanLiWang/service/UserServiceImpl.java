package com.wsloan.fanLiWang.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.wsloan.fanLiWang.util.MD5Util;
import org.springframework.stereotype.Service;

import com.wsloan.fanLiWang.dao.UserDao;
import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Receipt;
import com.wsloan.fanLiWang.entity.User;
import com.wsloan.fanLiWang.util.WorkOderUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
    private UserDao userDao;
	/*
	 * 查询用户
	 * 
	 * */
	public BackgroundUser login(String name,String pwd) throws UsersNotFoundException {
		BackgroundUser user = userDao.login(name);
		String password = user.getPassword();
		pwd = MD5Util.getMD5(pwd);
		if(pwd.equals(password)){
			return  user;
		}
		return  null;

	}

	/*
	 * 修改用户密码
	 * 
	 */
	public Integer updatePwd(String oldpwd,String newpwd,String name) {
		BackgroundUser user  = userDao.login(name);
		String oldpwd2 = user.getPassword().trim();	//数据库原密码
		oldpwd = MD5Util.getMD5(oldpwd);
		newpwd = MD5Util.getMD5(newpwd);
		if(oldpwd.equals(oldpwd2)){
			Integer i = userDao.updatePwd(name,newpwd);
			return i;
		}
		return null;
		
	}

	/**
	 * 用户信息查询
	 * */
	public Map<String ,Object> getUserList(Integer pageNumber,Integer pageSize,String phoneNumber) {
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		List<User> list = null;
		Map<String,Object> map = new HashMap<String, Object>();
		list = userDao.getUserList(phoneNumber,min,max);
		Integer total = userDao.getTotal(phoneNumber);
		for(int i=0;i<list.size();i++){
			String card = list.get(i).getCardNo();
			Integer comefrom  = list.get(i).getComefrom();
			if(comefrom==2){
				list.get(i).setComefromChinese("WAP端");

			}else if(comefrom==3){
				list.get(i).setComefromChinese("PC端");
			}else {
				list.get(i).setComefromChinese("APP端");
			}

			if(card!=null ){
				list.get(i).setBangka("已绑卡");
				
			}else{
				list.get(i).setBangka("未绑卡");
			}
		}
		map.put("rows",list);
		map.put("total",total);
		return map;


	}
	
	/**
	 * 拉入黑名单
	 * */
	public Integer updateUserState(Integer userState){
		Integer number=userDao.updateUserState(userState);
		return number;
		
	}

	public List<Receipt> getUserReceipt(Integer userID) {
		User user = userDao.getUserDetails(userID);
		String phoneNumber = user.getPhoneNumber();
		List<Receipt> list = userDao.getUserReceipt(phoneNumber);
		return list;
	}

	/**
	 * 查看推荐人列表
	 * */
	public List<User> getTuijianren(Integer refferredID) {
		List<User> list = userDao.getTuijianren(refferredID);
		return list;
	}

	public Map<String, Object> getCode(String phoneNumber) {
		Map<String,Object> map = new HashMap<String, Object>();
		Map map1 = userDao.getSecurityCode(phoneNumber);
		Integer code1 = userDao.getZhuCeCode(phoneNumber);
		map.put("zhuceYZM",code1);
		if(map1!=null){
			map.put("securityCode",map1.get("securityCode"));
		}
		return map;
	}

	public List<User> exportUser(String start_time_one,String end_time_one) {
		List<User> list = null;
 		list=userDao.exportUser(start_time_one,end_time_one);
		for(int i=0;i<list.size();i++){
			Integer comefrom  = list.get(i).getComefrom();
			if(comefrom==2){
				list.get(i).setComefromChinese("WAP端");

			}else if(comefrom==3){
				list.get(i).setComefromChinese("PC端");
			}else {
				list.get(i).setComefromChinese("APP端");
			}
		}
		return list;
	}

	public Integer beAgent(Integer userID,Integer beAgent) {
		Integer num = userDao.beAgent(userID,beAgent);
		return num;
	}
}
