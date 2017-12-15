package com.wsloan.fanLiWang.entity;

public class Receipt  {

	/**
	 * 回执单类
	 */
	//private static final long serialVersionUID = 1L;
	/**
	 * 回执单ID
	 * */
	private Integer ID;
	/**
	 * 映射平台名称
	 * */
	private String platform;
	/*
	* 返利方式
	* */
	private  Integer fandian;
	/*
	* 返利利率
	* */
	private Double rebateScheme;
	/**
	 * 注册手机号
	 * */
	private String phoneNumber;
	/**
	 * 注册平台用户名
	 * */
	private String platformUser;
	/**
	 * 实际投资金额
	 * */
	private Integer investmentMoney;
	/**
	 * 投资期限
	 * */
	private String investmentLimit;
	/**
	 * 投资日期
	 * */
	private String investmentDate;
	/**
	 * 用户ID
	 * */
	private Integer userID;
	/*
	* 第三方返利利率
	* */
	private  Double disanfang;
	/**
	 * 返利金额
	 * */
	private Double fanli;

	/**
	 * 收款用户名
	 * */

	private String gatheringUser;
	/**
	 * 收款银行账户
	 * */
	private String gatherAccount;

	/**
	 * 回执单状态
	 * */
	private Integer receiptState;

	/**
	 * 回执单状态（中文显示）
	 * */
	private String stateChinese;
	/**
	 * 提交时间
	 * */
	private String submissionTime;

	/**
	 * 是否新手
	 * */
	private Integer xinshou;

	/**
	 * 新手红包
	 * */
	private  Integer xshb;
	/**
	 * 分享红包
	 * */
	private Integer fxhb;
	/**
	 * 推荐人ID
	 * */
	private  String referrerID;
	/**
	 * 支付宝用户名
	 * */
	private  String alipayName;
	/**
	 * 支付宝账户
	 * */
	private  String alipayId;


	/*是否是代理*/
	private  Integer beAgent;

	/*批量提交回单时候银行卡账户就是推手名字*/
	private String skr;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}



	public Integer getFandian() {
		return fandian;
	}

	public void setFandian(Integer fandian) {
		this.fandian = fandian;
	}

	public Double getRebateScheme() {
		return rebateScheme;
	}

	public void setRebateScheme(Double rebateScheme) {
		this.rebateScheme = rebateScheme;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPlatformUser() {
		return platformUser;
	}

	public void setPlatformUser(String platformUser) {
		this.platformUser = platformUser;
	}

	public Integer getInvestmentMoney() {
		return investmentMoney;
	}

	public void setInvestmentMoney(Integer investmentMoney) {
		this.investmentMoney = investmentMoney;
	}

	public String getInvestmentLimit() {
		return investmentLimit;
	}

	public void setInvestmentLimit(String investmentLimit) {
		this.investmentLimit = investmentLimit;
	}

	public String getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(String investmentDate) {
		this.investmentDate = investmentDate;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Double getFanli() {
		return fanli;
	}

	public void setFanli(Double fanli) {
		this.fanli = fanli;
	}

	public String getGatheringUser() {
		return gatheringUser;
	}

	public void setGatheringUser(String gatheringUser) {
		this.gatheringUser = gatheringUser;
	}

	public String getGatherAccount() {
		return gatherAccount;
	}

	public void setGatherAccount(String gatherAccount) {
		this.gatherAccount = gatherAccount;
	}

	public Integer getReceiptState() {
		return receiptState;
	}

	public void setReceiptState(Integer receiptState) {
		this.receiptState = receiptState;
	}

	public String getStateChinese() {
		return stateChinese;
	}

	public void setStateChinese(String stateChinese) {
		this.stateChinese = stateChinese;
	}

	public String getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(String submissionTime) {
		this.submissionTime = submissionTime;
	}

	public Integer getXinshou() {
		return xinshou;
	}

	public void setXinshou(Integer xinshou) {
		this.xinshou = xinshou;
	}

	public Integer getXshb() {
		return xshb;
	}

	public void setXshb(Integer xshb) {
		this.xshb = xshb;
	}

	public Integer getFxhb() {
		return fxhb;
	}

	public void setFxhb(Integer fxhb) {
		this.fxhb = fxhb;
	}

	public String getReferrerID() {
		return referrerID;
	}

	public void setReferrerID(String referrerID) {
		this.referrerID = referrerID;
	}

	public String getAlipayName() {
		return alipayName;
	}

	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}

	public String getAlipayId() {
		return alipayId;
	}

	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}
	public Double getDisanfang() {
		return disanfang;
	}

	public void setDisanfang(Double disanfang) {
		this.disanfang = disanfang;
	}


	public Integer getBeAgent() {
		return beAgent;
	}

	public void setBeAgent(Integer beAgent) {
		this.beAgent = beAgent;
	}

	@Override
	public String toString() {
		return "Receipt{" +
				"ID=" + ID +
				", platform='" + platform + '\'' +
				", rebateScheme=" + rebateScheme +
				", fandian=" + fandian +
				", phoneNumber='" + phoneNumber + '\'' +
				", platformUser='" + platformUser + '\'' +
				", investmentMoney=" + investmentMoney +
				", investmentLimit='" + investmentLimit + '\'' +
				", investmentDate='" + investmentDate + '\'' +
				", userID=" + userID +
				", fanli=" + fanli +
				", gatheringUser='" + gatheringUser + '\'' +
				", gatherAccount='" + gatherAccount + '\'' +
				", receiptState=" + receiptState +
				", stateChinese='" + stateChinese + '\'' +
				", submissionTime='" + submissionTime + '\'' +
				", xinshou=" + xinshou +
				", xshb=" + xshb +
				", fxhb=" + fxhb +
				", referrerID='" + referrerID + '\'' +
				", alipayName='" + alipayName + '\'' +
				", alipayId='" + alipayId + '\'' +
				'}';
	}


	public String getSkr() {
		return skr;
	}

	public void setSkr(String skr) {
		this.skr = skr;
	}
}
