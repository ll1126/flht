package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class BrandInformation implements Serializable {

	/**
	 * 平台品牌信息
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 品牌ID
	 * */
	private Integer ID;
	/**
	 * 平台名称
	 * */
	private String platform;
	/**
	 * 平台Logo
	 * */
	private String platformLogo;
	/**
	 * 运营公司
	 * */
	private String operator;
	/**
	 * 上线时间
	 * */
	private String onlineTime;
	/**
	 * 利息水平
	 * */
	private String interestRate;
	/**
	 * 投资期限
	 * */
	private String investmentHorizon;
	/**
	 * 注册资金
	 * */
	private String registeredFund;
	/**
	 * 资金存管
	 * */
	private String depositFund;
	/**
	 * 担保公司
	 * */
	private String guaranteeCompany;
	/**
	 * 提现到账
	 * */
	private String withdraw;
	/**
	 * 客服电话
	 * */
	private String phoneNumber;
	/**
	 * 平台背景
	 * */
	private String backgroundPedestal;
	/**
	 * 融资背景
	 * */
	private String backgroundFinancing;
	/**
	 * 公司地址
	 * */
	private String address;
	/**
	 * 排名情况
	 * */
	private String standingList;
	/**
	 * 风险评估分数
	 * */
	private String riskAssessment;
	/**
	 * 回单数量
	 * */
	private int receiptNum;
	/**
	 * 置顶状态
	 * */
	private int zhiDing;
	/**
	 * 投资攻略
	 * */
	private String tzgl;
	/**
	 * 重要提示
	 * */
	private String zyts;
	/**
	 * 风险小组推荐理由
	 * */
	
	private String tjly;
	/**
	 * 上下架
	 * */
	private int shangjia;
	/**
	 * 风险标签
	 * */
	private String fengxianbq;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public String getInvestmentHorizon() {
		return investmentHorizon;
	}
	public void setInvestmentHorizon(String investmentHorizon) {
		this.investmentHorizon = investmentHorizon;
	}
	public String getRegisteredFund() {
		return registeredFund;
	}
	public void setRegisteredFund(String registeredFund) {
		this.registeredFund = registeredFund;
	}
	public String getDepositFund() {
		return depositFund;
	}
	public void setDepositFund(String depositFund) {
		this.depositFund = depositFund;
	}
	public String getGuaranteeCompany() {
		return guaranteeCompany;
	}
	public void setGuaranteeCompany(String guaranteeCompany) {
		this.guaranteeCompany = guaranteeCompany;
	}
	public String getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBackgroundPedestal() {
		return backgroundPedestal;
	}
	public void setBackgroundPedestal(String backgroundPedestal) {
		this.backgroundPedestal = backgroundPedestal;
	}
	public String getBackgroundFinancing() {
		return backgroundFinancing;
	}
	public void setBackgroundFinancing(String backgroundFinancing) {
		this.backgroundFinancing = backgroundFinancing;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStandingList() {
		return standingList;
	}
	public void setStandingList(String standingList) {
		this.standingList = standingList;
	}
	public String getRiskAssessment() {
		return riskAssessment;
	}
	public void setRiskAssessment(String riskAssessment) {
		this.riskAssessment = riskAssessment;
	}
	public int getReceiptNum() {
		return receiptNum;
	}
	public void setReceiptNum(int receiptNum) {
		this.receiptNum = receiptNum;
	}
	public int getZhiDing() {
		return zhiDing;
	}
	public void setZhiDing(int zhiDing) {
		this.zhiDing = zhiDing;
	}
	public String getPlatformLogo() {
		return platformLogo;
	}
	public void setPlatformLogo(String platformLogo) {
		this.platformLogo = platformLogo;
	}
	public String getTzgl() {
		return tzgl;
	}
	public void setTzgl(String tzgl) {
		this.tzgl = tzgl;
	}
	public String getZyts() {
		return zyts;
	}
	public void setZyts(String zyts) {
		this.zyts = zyts;
	}
	public String getTjly() {
		return tjly;
	}
	public void setTjly(String tjly) {
		this.tjly = tjly;
	}
	
	public int getShangjia() {
		return shangjia;
	}
	public void setShangjia(int shangjia) {
		this.shangjia = shangjia;
	}
	
	@Override
	public String toString() {
		return "BrandInformation [ID=" + ID + ", platform=" + platform + ", platformLogo=" + platformLogo
				+ ", operator=" + operator + ", onlineTime=" + onlineTime + ", interestRate=" + interestRate
				+ ", investmentHorizon=" + investmentHorizon + ", registeredFund=" + registeredFund + ", depositFund="
				+ depositFund + ", guaranteeCompany=" + guaranteeCompany + ", withdraw=" + withdraw + ", phoneNumber="
				+ phoneNumber + ", backgroundPedestal=" + backgroundPedestal + ", backgroundFinancing="
				+ backgroundFinancing + ", address=" + address + ", standingList=" + standingList + ", riskAssessment="
				+ riskAssessment + ", receiptNum=" + receiptNum + ", zhiDing=" + zhiDing + ", tzgl=" + tzgl + ", zyts="
				+ zyts + "]";
	}
	public String getFengxianbq() {
		return fengxianbq;
	}
	public void setFengxianbq(String fengxianbq) {
		this.fengxianbq = fengxianbq;
	}
	
}
