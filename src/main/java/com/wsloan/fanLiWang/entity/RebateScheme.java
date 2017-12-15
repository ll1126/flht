package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class RebateScheme implements Serializable{

	/**
	 * 返利方案类
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 返利编号
	 */
	private int ID;
	/**
	 * 有效期限
	 * */
	private String limitedDuration;
	/**
	 * 有效项目
	 * */
	private String effectiveProject;
	/**
	 * 投资额度
	 * */
	private Double investmentLimit;
	/**
	 * 即可返利
	 * */
	private Double rebateImmediately;
	/**
	 * 原平台利息
	 * */
	private Double platformRate;
	
	/**
	 * 红包
	 * */
	private Double redPacket;
	/**
	 * 其他
	 * */
	private Double rest;
	/**
	 * 总收益
	 * */
	private Double totalRevenue;
	/**
	 * 原年化
	 * */
	private String primaryRate;
	/**
	 * 综合年化
	 * */
	private String synthesizeRate;
	/**
	 * 返利周期
	 * */
	private String rebateDuration;
	/**
	 * 标的ID
	 * */
	private Integer objectID;
	
	/**
	 * 标的名称
	 * */
	private String objectName;
	
	/**
	 * 上架
	 * */
	private  int shangjia;

	/**
	 * 我方给用户返点值
	 * */
	private Integer fanDian;



	/**
	 * 返点方案（固定式0，浮点式1）
	 * */

	private Double fanDianScheme;
	/**
	 * 固定式返点值（最小返点区间，如0-1000返100，然后1000-2000返200）
	 * */
	/*
	* 第三方平台返点
	* */
	private  Double disanfang;

	private  Integer agentFanDian;/*代理商返利放式*/
	private  Double agentFanDianScheme;/*代理商返点值大小*/
	public Integer getObjectID() {
		return objectID;
	}
	public void setObjectID(Integer objectID) {
		this.objectID = objectID;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getLimitedDuration() {
		return limitedDuration;
	}
	public void setLimitedDuration(String limitedDuration) {
		this.limitedDuration = limitedDuration;
	}
	public String getEffectiveProject() {
		return effectiveProject;
	}
	public void setEffectiveProject(String effectiveProject) {
		this.effectiveProject = effectiveProject;
	}
	public Double getInvestmentLimit() {
		return investmentLimit;
	}
	public void setInvestmentLimit(Double investmentLimit) {
		this.investmentLimit = investmentLimit;
	}
	public Double getRebateImmediately() {
		return rebateImmediately;
	}
	public void setRebateImmediately(Double rebateImmediately) {
		this.rebateImmediately = rebateImmediately;
	}
	public Double getRedPacket() {
		return redPacket;
	}
	public void setRedPacket(Double redPacket) {
		this.redPacket = redPacket;
	}
	public Double getRest() {
		return rest;
	}
	public void setRest(Double rest) {
		this.rest = rest;
	}
	public Double getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(Double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	public String getPrimaryRate() {
		return primaryRate;
	}
	public void setPrimaryRate(String primaryRate) {
		this.primaryRate = primaryRate;
	}
	public String getSynthesizeRate() {
		return synthesizeRate;
	}
	public void setSynthesizeRate(String synthesizeRate) {
		this.synthesizeRate = synthesizeRate;
	}
	public String getRebateDuration() {
		return rebateDuration;
	}
	public void setRebateDuration(String rebateDuration) {
		this.rebateDuration = rebateDuration;
	}
	public Integer getFanDian() {
		return fanDian;
	}
	public void setFanDian(Integer fanDian) {
		this.fanDian = fanDian;
	}
	public Double getFanDianScheme() {
		return fanDianScheme;
	}
	public void setFanDianScheme(Double fanDianScheme) {
		this.fanDianScheme = fanDianScheme;
	}
	public Double getPlatformRate() {
		return platformRate;
	}
	public void setPlatformRate(Double platformRate) {
		this.platformRate = platformRate;
	}
	public String getObjectName() {
		return objectName;
	}
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	public int getShangjia() {
		return shangjia;
	}
	public void setShangjia(int shangjia) {
		this.shangjia = shangjia;
	}

	public Double getDisanfang() {
		return disanfang;
	}

	public void setDisanfang(Double disanfang) {
		this.disanfang = disanfang;
	}
	public Integer getAgentFanDian() {
		return agentFanDian;
	}

	public void setAgentFanDian(Integer agentFanDian) {
		this.agentFanDian = agentFanDian;
	}

	public Double getAgentFanDianScheme() {
		return agentFanDianScheme;
	}

	public void setAgentFanDianScheme(Double agentFanDianScheme) {
		this.agentFanDianScheme = agentFanDianScheme;
	}

	@Override
	public String toString() {
		return "RebateScheme{" +
				"ID=" + ID +
				", limitedDuration='" + limitedDuration + '\'' +
				", effectiveProject='" + effectiveProject + '\'' +
				", investmentLimit=" + investmentLimit +
				", rebateImmediately=" + rebateImmediately +
				", platformRate=" + platformRate +
				", redPacket=" + redPacket +
				", rest=" + rest +
				", totalRevenue=" + totalRevenue +
				", primaryRate='" + primaryRate + '\'' +
				", synthesizeRate='" + synthesizeRate + '\'' +
				", rebateDuration='" + rebateDuration + '\'' +
				", objectID=" + objectID +
				", objectName='" + objectName + '\'' +
				", shangjia=" + shangjia +
				", fanDian=" + fanDian +
				", fanDianScheme=" + fanDianScheme +
				", disanfang=" + disanfang +
				", agentFanDian=" + agentFanDian +
				", agentFanDianScheme=" + agentFanDianScheme +
				'}';
	}
}
