package com.wsloan.fanLiWang.dao;

import com.wsloan.fanLiWang.entity.CountMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CountMessageDao {
	/**
	 * 根据回执单表进行统计
	 * */
	List<CountMessage> getCountMessage(@Param("submissionTimeStart") String submissionTimeStart,
									   @Param("submissionTimeEnd") String submissionTimeEnd);

	/**
	 * 获取注册返利网人数
	 * */
	Map getRegistPeople(@Param("date_start") String date_start,@Param("date_end")String date_end);

	/**
	 * 已审核的回单数
	 * */

	Map getZuoRiReceipt(@Param("date_start") String date_start,@Param("date_end")String date_end);

	/**
	 * 已审核的投资总额
	 * */
	Map getInvestMoney(@Param("date_start") String date_start,@Param("date_end")String date_end);

	/**
	 *绑卡人数
	 * */
	Map getZuoRiBangKa(@Param("date_start") String date_start,@Param("date_end")String date_end);

	/**
	 * 总注册人数
	 * */
	Map getRegistPeopleSum();
	/**
	 *总绑卡人数
	 * */
	Map getBangKaSum();

	/**
	 * 总审核通过回单数
	 * */
	Map getReceiptSum();

	/**
	 *总投资额
	 * */
	Map getInvestMoneySum();


}
