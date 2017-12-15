package com.wsloan.fanLiWang.entity;

import java.io.Serializable;

public class Rankings implements Serializable {

	/**
	 * 排名类
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 排名ID
	 * */
	private Integer ID;
	/**
	 * 综合排名
	 * */
	private String rankings;
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getRankings() {
		return rankings;
	}
	public void setRankings(String rankings) {
		this.rankings = rankings;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Rankings [ID=" + ID + ", rankings=" + rankings + "]";
	}
	

}
