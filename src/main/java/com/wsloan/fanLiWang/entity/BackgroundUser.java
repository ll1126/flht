package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class BackgroundUser implements Serializable{

	/**
	 * 后台用户表
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 后台用户ID
	 * */
	private Integer ID;
	/**
	 * 用户名
	 * */
	private String userName;
	/**
	 * 密码
	 * */
	private String password;
	/**
	 * 权限
	 * */
	private Integer power;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getPower() {
		return power;
	}
	public void setPower(Integer power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "BackgroundUser [ID=" + ID + ", userName=" + userName + ", password=" + password + ", power=" + power
				+ "]";
	}
	
	
}
