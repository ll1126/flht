package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class ObjectList implements Serializable{

	/**
	 * 标的明细类
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 标的ID
	 * */
	private Integer ID;
	/**
	 * 平台ID
	 * */
	private Integer platformID;
	/**
	 * 项目名称
	 * */
	private String platform;
	/**
	 * 平台logo
	 * */
	private String platformLogo;
	/**
	 * 类型
	 * */
	private Integer type;
	/**
	 * 综合年化最小值
	 * */
	private String annualizedReturns;//综合年化
	private String annualSection;//原年化
	private Double annualizedReturnsMin;
	/**
	 * 综合年化最大值
	 * */
	private Double annualizedReturnsMax;
	/**
	 * 原年化最小值
	 * */
	private Double annualSectionMin;
	/**
	 * 原年化最大值
	 * */
	private Double annualSectionMax;
	/**
	 * 标的期限
	 * */
	private Integer objectDeadline;
	/**
	 * 起投金额
	 * */
	private Double  minMoney;
	/**
	 * 最高限额
	 * */
	private Double maxMoney;
	/**
	 * 标签(一个标的对应多个标签)
	 * */
	private String tag;
	/**
	 * 风险评估
	 * */
	private String riskAssessment;
	/**
	 * 平台网址
	 * */
	private String platformAddress;
	/**
	 *最高返利金额 
	 * */
	private Double maxReturnMoney;
	/**
	 * 投资额度范围
	 * */
	private String investmentSection;
	/**
	 * 参与人数
	 * */
	private Integer participants;
	/**
	 * 返利方案
	 * */
	private Integer rebateScheme;
	/**
	 * 标的上线时间
	 * */
	private String objectUpTime;
	/**
	 * 上下架
	 * */
	private int objectState;
	/**
	 * platform 转为int(修改标的时候用)
	 * */
	private int platID;
	
	/**
	 * 个月及天
	 * */
	private String objectTian;
	
	/**
	 * 标的置顶
	 * */
	private int zhiding;
	
	/**
	 * 直达链接PC
	 * */
	private String zdljpc;
	/**
	 * 直达链接APP
	 * */
	private String zdljapp;
	private int pcapp;
	
	/**
	 * 个月及以上转为天
	 * */
	private int zhuanWeiTian;

	/**
	 * 项目排序
	 * */
	private int paixu;

	public int getPaixu() {
		return paixu;
	}

	public void setPaixu(int paixu) {
		this.paixu = paixu;
	}
	public String getZdljpc() {
		return zdljpc;
	}
	public void setZdljpc(String zdljpc) {
		this.zdljpc = zdljpc;
	}
	public String getZdljapp() {
		return zdljapp;
	}
	public void setZdljapp(String zdljapp) {
		this.zdljapp = zdljapp;
	}
	public int getPcapp() {
		return pcapp;
	}
	public void setPcapp(int pcapp) {
		this.pcapp = pcapp;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getPlatformID() {
		return platformID;
	}
	public void setPlatformID(Integer platformID) {
		this.platformID = platformID;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPlatformLogo() {
		return platformLogo;
	}
	public void setPlatformLogo(String platformLogo) {
		this.platformLogo = platformLogo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Double getAnnualizedReturnsMin() {
		return annualizedReturnsMin;
	}
	public void setAnnualizedReturnsMin(Double annualizedReturnsMin) {
		this.annualizedReturnsMin = annualizedReturnsMin;
	}
	public Double getAnnualizedReturnsMax() {
		return annualizedReturnsMax;
	}
	public void setAnnualizedReturnsMax(Double annualizedReturnsMax) {
		this.annualizedReturnsMax = annualizedReturnsMax;
	}
	public Double getAnnualSectionMin() {
		return annualSectionMin;
	}
	public void setAnnualSectionMin(Double annualSectionMin) {
		this.annualSectionMin = annualSectionMin;
	}
	public Double getAnnualSectionMax() {
		return annualSectionMax;
	}
	public void setAnnualSectionMax(Double annualSectionMax) {
		this.annualSectionMax = annualSectionMax;
	}
	public void setRebateScheme(Integer rebateScheme) {
		this.rebateScheme = rebateScheme;
	}
	public Integer getObjectDeadline() {
		return objectDeadline;
	}
	public void setObjectDeadline(Integer objectDeadline) {
		this.objectDeadline = objectDeadline;
	}
	public Double getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(Double minMoney) {
		this.minMoney = minMoney;
	}
	public Double getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(Double maxMoney) {
		this.maxMoney = maxMoney;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getRiskAssessment() {
		return riskAssessment;
	}
	public void setRiskAssessment(String riskAssessment) {
		this.riskAssessment = riskAssessment;
	}
	public String getPlatformAddress() {
		return platformAddress;
	}
	public void setPlatformAddress(String platformAddress) {
		this.platformAddress = platformAddress;
	}
	public Double getMaxReturnMoney() {
		return maxReturnMoney;
	}
	public void setMaxReturnMoney(Double maxReturnMoney) {
		this.maxReturnMoney = maxReturnMoney;
	}
	public String getInvestmentSection() {
		return investmentSection;
	}
	public void setInvestmentSection(String investmentSection) {
		this.investmentSection = investmentSection;
	}
	public Integer getParticipants() {
		return participants;
	}
	public void setParticipants(Integer participants) {
		this.participants = participants;
	}
	public Integer getRebateScheme() {
		return rebateScheme;
	}
	public String getObjectUpTime() {
		return objectUpTime;
	}
	public void setObjectUpTime(String objectUpTime) {
		this.objectUpTime = objectUpTime;
	}
	public int getObjectState() {
		return objectState;
	}
	public void setObjectState(int objectState) {
		this.objectState = objectState;
	}
	public int getPlatID() {
		return platID;
	}
	public void setPlatID(int platID) {
		this.platID = platID;
	}
	public String getAnnualizedReturns() {
		return annualizedReturns;
	}
	public void setAnnualizedReturns(String annualizedReturns) {
		this.annualizedReturns = annualizedReturns;
	}
	public String getAnnualSection() {
		return annualSection;
	}
	public void setAnnualSection(String annualSection) {
		this.annualSection = annualSection;
	}
	public String getObjectTian() {
		return objectTian;
	}
	public void setObjectTian(String objectTian) {
		this.objectTian = objectTian;
	}
	public int getZhiding() {
		return zhiding;
	}
	public void setZhiding(int zhiding) {
		this.zhiding = zhiding;
	}
	@Override
	public String toString() {
		return "ObjectList [ID=" + ID + ", platformID=" + platformID + ", platform=" + platform + ", platformLogo="
				+ platformLogo + ", type=" + type + ", annualizedReturns=" + annualizedReturns + ", annualSection="
				+ annualSection + ", annualizedReturnsMin=" + annualizedReturnsMin + ", annualizedReturnsMax="
				+ annualizedReturnsMax + ", annualSectionMin=" + annualSectionMin + ", annualSectionMax="
				+ annualSectionMax + ", objectDeadline=" + objectDeadline + ", minMoney=" + minMoney + ", maxMoney="
				+ maxMoney + ", tag=" + tag + ", riskAssessment=" + riskAssessment + ", platformAddress="
				+ platformAddress + ", maxReturnMoney=" + maxReturnMoney + ", investmentSection=" + investmentSection
				+ ", participants=" + participants + ", rebateScheme=" + rebateScheme + ", objectUpTime=" + objectUpTime
				+ ", objectState=" + objectState + ", platID=" + platID + ", objectTian=" + objectTian + ", zhiding="
				+ zhiding + ", zdljpc=" + zdljpc + ", zdljapp=" + zdljapp + ", pcapp=" + pcapp + "]";
	}
	public int getZhuanWeiTian() {
		return zhuanWeiTian;
	}
	public void setZhuanWeiTian(int zhuanWeiTian) {
		this.zhuanWeiTian = zhuanWeiTian;
	}
	
}
