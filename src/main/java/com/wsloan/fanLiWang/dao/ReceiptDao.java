package com.wsloan.fanLiWang.dao;

import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.entity.DaiDaKuan;
import com.wsloan.fanLiWang.entity.FMoney;
import com.wsloan.fanLiWang.entity.Receipt;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ReceiptDao {
	
	/**
	 * 查询在对应平台的投资回单
	 * */
	
	List<Receipt> getReceiptList(@Param("receiptID")Integer receiptID, @Param("receiptState")Integer receiptState,@Param("phoneNumber")String phoneNumber,@Param("platform")String platform,
					@Param("submissionTimeStart") String submissionTimeStart,@Param("submissionTimeEnd") String submissionTimeEnd,
					@Param("min") Integer min,@Param("max") Integer max	);

	/*
	* 已驳回的回单记录数
	* */
	Integer getTotalYiBoHui(@Param("receiptState") Integer receiptState);
	/**
	 * 获取回单记录数
	 * */
	Integer getReceiptCount(@Param("platformID")Integer platformID,@Param("receiptState")Integer receiptState);
	
	/**
	 * 更新回执单状态
	 * */
	Integer updateState(@Param("receiptID")Integer receiptID,@Param("receiptState")Integer receiptState);
	
	/**
	 * 
	 * 回执单中根据平台和回执单状态进行筛选
	 * */
	/**
	 * 回执单中获取对应的平台列表
	 * */
	 List<BrandInformation>  getBrandList();
	 
	 
	//根据id查询回执单
		 Map selectReceipt(@Param("receiptID")Integer receiptID);
		 //根据id查询用户
		 Map selectUser(String userid);
		//注册时丢给他一个红包
		int diuRed(@Param("time")String time,@Param("id")String id,@Param("phone")String phone,@Param("jine")String jine,@Param("hzdid")Integer hzdid); 
		//修改新手红包的状态
		int updateRed(String redid);
		//查询红包
		Map selred(String userid);
		//改为不是新手
		int updateUser(String userid);
	//往总表中插入数据
	int insertUY(@Param("usfz")String usfz,@Param("ucard")String ucard,@Param("uphone")String uphone,
				 @Param("uname")String uname,@Param("umoney")String umoney,@Param("uAlipayName") String uAlipayName,
				 @Param("uAlipayId") String uAlipayId,@Param("ysfz")String ysfz,
				 @Param("ycard")String ycard,@Param("yphone")String yphone,@Param("yname")String yname,
				 @Param("ymoney")String ymoney,@Param("yAlipayName") String yAlipayName,
				 @Param("yAlipayId") String yAlipayId,
				 @Param("userid")String userid,@Param("time")String time,@Param("receiptID")Integer receiptID,@Param("payType") String payType);
		Map selyred(String hzdid);
	
	int updateUser2(@Param("userid")String userid,@Param("lj")String lj);
	
	Map selband(String id);
	Map selObject(String id);
	int updateband(@Param("num")Integer num,@Param("id")String id);
	int updateobject(@Param("num2")Integer num2,@Param("id")String id);
	/**
	 * 查看财务默认的回单，审核中的回单
	 * */
	
	List<Receipt> getCaiWuList(@Param("min") Integer min,@Param("max") Integer max);

	/**
	 * 一审查看的回执单
	 * */
	List<Receipt> getReceiptList222(@Param("min") Integer min,@Param("max") Integer max);
	/**
	 * 获取Excel的回执单
	 * */
	List<Receipt> getExcelList(@Param("receiptID")Integer receiptID,@Param("receiptState")Integer receiptState,
							   @Param("phoneNumber")String phoneNumber,@Param("platform")String platform,
							   @Param("submissionTimeStart") String submissionTimeStart,@Param("submissionTimeEnd") String submissionTimeEnd);

	/**
	 * 获取Excel财务待打款的回执单
	 * */
	List<DaiDaKuan> getExcelList2(@Param("platform")String platform,
								  @Param("submissionTimeStart") String submissionTimeStart, @Param("submissionTimeEnd") String submissionTimeEnd);

	/**
	 * 筛选财务打款展示列表
	 * */

	List<FMoney> getfmoney(@Param("receiptID")Integer receiptID,@Param("phoneNumber")String phoneNumber, @Param("submissionTimeStart") String submissionTimeStart,
						   @Param("submissionTimeEnd") String submissionTimeEnd,@Param("receiptState") Integer receiptState,@Param("min") Integer min,@Param("max") Integer max);

	/*未打款总的记录数*/
	Integer getWeiDaKuan();

	/*
	* 财务待打款总的记录数
	* */
	Integer getTotalCaiWu(@Param("receiptID")Integer receiptID,@Param("phoneNumber")String phoneNumber, @Param("submissionTimeStart") String submissionTimeStart,
						  @Param("submissionTimeEnd") String submissionTimeEnd,@Param("receiptState") Integer receiptState);

	/*
	* 财务导出的Excel表格
	* */
	List<FMoney> getfmoney2(@Param("receiptID")Integer receiptID,@Param("phoneNumber")String phoneNumber, @Param("submissionTimeStart") String submissionTimeStart,
							@Param("submissionTimeEnd") String submissionTimeEnd,@Param("receiptState") Integer receiptState);
	/**
	 * 获取全部回执单数量
	 * */
	 Integer getTotalReceipt(@Param("receiptID")Integer receiptID, @Param("receiptState")Integer receiptState,@Param("phoneNumber")String phoneNumber,@Param("platform")String platform,
							 @Param("submissionTimeStart") String submissionTimeStart,@Param("submissionTimeEnd") String submissionTimeEnd);

	 /*
	 * 财务打款将状态Fmoney中的打款改为已打款
	 * */
	 Integer updateFmoney(@Param("fmoneyID") Integer fmoneyID);

	 /*
	 * 一审中批量审核通过
	 * */
	 Integer updateBatchState(@Param("array") String[] array,@Param("receiptState") Integer receiptState);

	 /*待审核，财务审核页面返利总金额*/
	 Double getFanLiSum(@Param("receiptID")Integer receiptID, @Param("receiptState")Integer receiptState,@Param("phoneNumber")String phoneNumber,@Param("platform")String platform,
						@Param("submissionTimeStart") String submissionTimeStart,@Param("submissionTimeEnd") String submissionTimeEnd);

	 /*财务待打款用户返利总金额*/
	Double getFmoneySum(@Param("receiptID")Integer receiptID, @Param("receiptState")Integer receiptState,@Param("phoneNumber")String phoneNumber,
						@Param("submissionTimeStart") String submissionTimeStart,@Param("submissionTimeEnd") String submissionTimeEnd);

	/*
    * 批量打款通过
    * */
	Integer updateBatchFmoneyState(@Param("array") String[] array,@Param("receiptState") Integer receiptState);
}
