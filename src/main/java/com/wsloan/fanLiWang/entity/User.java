package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 投资用户实体类
	 */
	private Integer ID; //
	private String phoneNumber;//手机号
	private  String skr;
	private String cardNo;//银行卡号
	private String referrerID;//推荐人ID
	private  String comefromChinese;//用户来源中文映射
	private  String cBkTime;//绑卡时间
	private String registrationTime;//注册时间
	private String password;//密码
	private String userName;//账户名
	private String referrerCode;//推荐人邀请码
	private String loginVerifyTime;//登录验证时间
	private String securityCode;//验证码
	private String loginTime;//登陆时间
	private int blacklist;//黑名单
	private String lJProfit;//累计收益
	private String jRProfit;//今日收益
	private Integer pwdCWCS;//密码错误次数
	private String bankName;//银行名字
	private String sheng;//开户省
	private String shi;//开户市
	private String quancheng;//开户行全程或县区
	private String bangka;//绑卡状态
	private String blackListChinese;
	private int comefrom;//用户来源
	private  String alipayId;//支付宝账号

	private  String alipayName;//支付宝名字
	private Integer beAgent;//代理商

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkr() {
		return skr;
	}

	public void setSkr(String skr) {
		this.skr = skr;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSheng() {
		return sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getQuancheng() {
		return quancheng;
	}

	public void setQuancheng(String quancheng) {
		this.quancheng = quancheng;
	}

	public String getBangka() {
		return bangka;
	}

	public void setBangka(String bangka) {
		this.bangka = bangka;
	}

	public String getBlackListChinese() {
		return blackListChinese;
	}

	public void setBlackListChinese(String blackListChinese) {
		this.blackListChinese = blackListChinese;
	}

	public int getComefrom() {
		return comefrom;
	}

	public void setComefrom(int comefrom) {
		this.comefrom = comefrom;
	}

	public String getAlipayId() {
		return alipayId;
	}

	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}

	public String getAlipayName() {
		return alipayName;
	}

	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getReferrerID() {
		return referrerID;
	}

	public void setReferrerID(String referrerID) {
		this.referrerID = referrerID;
	}

	public String getComefromChinese() {
		return comefromChinese;
	}

	public void setComefromChinese(String comefromChinese) {
		this.comefromChinese = comefromChinese;
	}

	public String getCBkTime() {
		return cBkTime;
	}

	public void setCBkTime(String cBkTime) {
		this.cBkTime = cBkTime;
	}

	public String getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReferrerCode() {
		return referrerCode;
	}

	public void setReferrerCode(String referrerCode) {
		this.referrerCode = referrerCode;
	}

	public String getLoginVerifyTime() {
		return loginVerifyTime;
	}

	public void setLoginVerifyTime(String loginVerifyTime) {
		this.loginVerifyTime = loginVerifyTime;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public int getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}

	public String getLJProfit() {
		return lJProfit;
	}

	public void setLJProfit(String lJProfit) {
		this.lJProfit = lJProfit;
	}

	public String getJRProfit() {
		return jRProfit;
	}

	public void setJRProfit(String jRProfit) {
		this.jRProfit = jRProfit;
	}

	public Integer getPwdCWCS() {
		return pwdCWCS;
	}

	public void setPwdCWCS(Integer pwdCWCS) {
		this.pwdCWCS = pwdCWCS;
	}

	public Integer getBeAgent() {
		return beAgent;
	}

	public void setBeAgent(Integer beAgent) {
		this.beAgent = beAgent;
	}
}
