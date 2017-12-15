package com.wsloan.fanLiWang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Receipt;
import com.wsloan.fanLiWang.entity.User;

public interface UserDao {
	/**
	 * 根据用户名登录
	 * */
	BackgroundUser login(@Param("username") String username);
	
	/**
	 * 根据用户ID修改密码
	 * */
	Integer updatePwd(@Param("userName") String userName,@Param("newpwd") String newpwd);
	
	/**
	 * 用户信息管理
	 * */
	
	List<User>  getUserList(@Param("phoneNumber") String phoneNumber,@Param("min") Integer min,@Param("max") Integer max);
	
	/**
	 * 拉入黑名单
	 * */
	Integer updateUserState(@Param("userID")Integer userID);
	
	/**
	 * 查看用户回执单
	 * */
	List<Receipt> getUserReceipt(@Param("phoneNumber")String phoneNumber);
	
	/**
	 * 查看用户详情
	 * */
	User getUserDetails(@Param("userID")Integer userID);
	
	/**
	 * 查看推荐人列表
	 * */
	List<User> getTuijianren(@Param("refferredID")Integer refferredID);

	/**
	 * 投资用户总的记录数
	 * */
	Integer getTotal(@Param("phoneNumber")String phoneNumber);

	/**
	 * 注册验证码查询
	 * */
	Integer getZhuCeCode(@Param("phoneNumber") String phoneNumber);

	/**
	 * 更换密码验证码
	 * */
	Map getSecurityCode(@Param("phoneNumber") String phoneNumber);

	/*
	* 导出Excel 用户信息
	* */
	List<User> exportUser(@Param("start_time_one")String start_time_one, @Param("end_time_one") String end_time_one);

	/*
	* 成为代理商
	* */
	Integer beAgent(@Param("userID") Integer userID,@Param("beAgent")Integer beAgent);
}
