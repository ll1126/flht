package com.wsloan.fanLiWang.service;

import java.util.List;
import java.util.Map;

import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.entity.DaiDaKuan;
import com.wsloan.fanLiWang.entity.FMoney;
import com.wsloan.fanLiWang.entity.Receipt;

public interface ReceiptService {

	/**
	 * 	获取回单记录列表
	 * */
	Map<String,Object> getReceiptList(Integer receiptID,Integer receiptState,String phoneNumber,String platform,String submissionTimeStart,
									  String submissionTimeEnd,Integer pageNumber,Integer pageSize);
	
	/**
	 * 根据回执单ID修改回执单状态
	 * */
	Integer updateState(Integer receiptID,Integer receiptState);
	
	/**
	 * 回单列表中对应平台
	 * */
	List<BrandInformation> getBrandList();
	
	/**
	 * 获取财务默认看到的回单
	 * */
	Map<String,Object> getCaiWuList(Integer pageNumber,Integer pageSize);

	/**一审查看的回执单
	 * */
	Map<String,Object> getReceiptList222(Integer pageNumber,Integer pageSize);

	/**
	 * 获取Excel的回执单
	 * */
	List<Receipt> getExcelList(Integer receiptID,Integer receiptState,String phoneNumber,String platform,String submissionTimeStart,String submissionTimeEnd);

	/**
	 * 获取Excel财务待打款回执单
	 * */
	List<DaiDaKuan> getExcelList2(String platform, String submissionTimeStart, String submissionTimeEnd);

	/**
	 * 筛选财务最终打款表
	 * */
	Map<String,Object> getfmoney(Integer receiptID,String phoneNumber, String submissionTimeStart, String submissionTimeEnd,Integer receiptState,Integer pageNumber,Integer pageSize);

	/*
	财务导出Excel的表格
	*/

	List<FMoney> getfmoney2(Integer receiptID,String phoneNumber, String submissionTimeStart, String submissionTimeEnd,Integer receiptState);

	/*
	* 更新财务打款状态
	* */
	Integer updateFmoney(Integer fmoneyID);

	/*财务默认的打款表*//*
	Map<String,Object> getfmoney3(Integer pageNumber,Integer pageSize);*/

	/*批量审核通过*/
	Integer updateBatchState(String ids,Integer receiptState);

	/*待审核和财务审核页面返利总金额*/
	Map getFanLiSum(Integer receiptID,Integer receiptState,String phoneNumber,
					String platform,String start_time_one,String end_time_one);

	/*财务待打款返利总金额*/
	Map getFmoneySum(Integer receiptID,Integer receiptState,String phoneNumber,
					 String start_time_one,String end_time_one);

	/*批量打款通过*/
	Integer updateBatchFmoneyState(String ids,Integer receiptState);
}
