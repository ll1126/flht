package com.wsloan.fanLiWang.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Receipt;
import com.wsloan.fanLiWang.entity.User;

public interface UserService {
	/**
	 * 登录功能方法
	 * @param name 用户名
	 * @param pwd 密码
	 */
	BackgroundUser login(String name,String pwd) throws UsersNotFoundException;

	/**
	 * 修改密码方法
	 *  @param name 用户名
	 * @param oldpwd 老密码
	 * @param newpwd 新密码
	 * */
	Integer updatePwd(String oldpwd,String newpwd,String name);
	
	/**
	 * 获取用户信息
	 * */

	Map<String,Object> getUserList(Integer pageNumber,Integer pageSize,String phoneNumber);
	
	
	/**
	 * 拉入黑名单
	 * */
	Integer updateUserState(Integer userID);
	
	/**
	 * 查看用户回单
	 * */
	List<Receipt> getUserReceipt(Integer userID);
	
	/**
	 * 查看推荐人列表
	 * */
	List<User> getTuijianren(Integer refferredID);

	/**
	 * 查询验证码
	 * */
	Map<String,Object> getCode(String phoneNumber);

	/*
	* 导出Excel用户信息
	* */
	List<User> exportUser(String start_time_one,String end_time_one);

	/*成为代理商*/
	Integer beAgent(Integer userID,Integer beAgent);
}
