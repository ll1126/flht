package com.wsloan.fanLiWang.service;

import com.wsloan.fanLiWang.dao.ReceiptDao;
import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.entity.DaiDaKuan;
import com.wsloan.fanLiWang.entity.FMoney;
import com.wsloan.fanLiWang.entity.Receipt;
import org.aspectj.apache.bcel.generic.NEW;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	@Resource
	private ReceiptDao receiptDao;
	
	/**
	 * 回单记录列表
	 * */
	public Map<String, Object> getReceiptList( Integer receiptID,Integer receiptState,String phoneNumber,String platform,String submissionTimeStart,String submissionTimeEnd,
										Integer pageNumber,Integer pageSize) {
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		String d = submissionTimeEnd;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");/*** 加一天*/
		try {
			if(d!=null&& d.length()> 0){
				Date dd = df.parse(d);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dd);
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				String ss = df.format(calendar.getTime());
				submissionTimeEnd=ss;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Receipt> list = receiptDao.getReceiptList(receiptID,receiptState,phoneNumber,platform,submissionTimeStart,submissionTimeEnd,min,max);
		Integer total = receiptDao.getTotalReceipt(receiptID,receiptState,phoneNumber,platform,submissionTimeStart,submissionTimeEnd);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows",list);
		map.put("total",total);
		return map;
	}

	/**
	 * 根据回执单ID修改回执单状态
	 * */
	@Transactional
	public Integer updateState(Integer receiptID, Integer receiptState) {
		Integer number = receiptDao.updateState(receiptID, receiptState);
		String userid = null;
		String hid = null; //平台id
		String payType = null;//支付方式
		int type = 0;//判断支付方式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		if(receiptState==3){//财务审核（生成总表信息和修改邀请人红包状态）
			//查询回执单
			Map m = receiptDao.selectReceipt(receiptID);
			hid = m.get("PlatformID").toString();
			//获取用户id
			userid = m.get("UserID").toString();
			//支付方式
			if(m.get("payType")!=null){
				payType = m.get("payType").toString();
				type = Integer.parseInt(payType);
			}

			//获取用户信息
			Map mm = receiptDao.selectUser(userid);
			//插入到总表一条数据(方便导出来打钱)
			//获得邀请人信息(不管有没有)
			String yname = null;   //邀请人名字
			String yphone= null;   //邀请人手机
			String ycard = null;   //邀请人卡号
			String ymoney = null;  //邀请人获得的钱
			String ysfz = null;    //邀请人的开户行
			String yAlipayName=null;//邀请人的支付宝用户名
			String yAlipayId = null;//邀请人的支付宝账号

			//获取投资人信息
			String uname = null;   //投资人名字
			String uphone =  null; //投资人手机
			String ucard = null;   //投资人卡号
			String umoney = null;  //投资人的钱
			String usfz = null;    //投资人的开户行
			String uAlipayName= null;//投资人的支付宝用户名
			String uAlipayId= null;//投资人的支付宝账号
			if(mm!=null){
				//获取投资人信息
				uname = mm.get("skr").toString();   //投资人名字
				uphone =  mm.get("PhoneNumber").toString();  //投资人手机
				ucard = mm.get("CardNo").toString();   //投资人卡号
				umoney = m.get("fanli").toString();   //投资人的钱
				usfz = mm.get("BankName").toString();  //投资人的开户行
				if(mm.get("alipayName")!=null){
					uAlipayName = mm.get("alipayName").toString();//投资人的支付宝账户名
				}
				if(mm.get("alipayId")!=null){
					uAlipayId = mm.get("alipayId").toString();//投资人的支付宝账号
				}
				//如果是新手
				if(mm.get("xinshou")==null){
					//返利的钱加红包的钱（5块）
					Double umoney2 = Double.parseDouble(umoney)+5;
					umoney = umoney2.toString();
					//修改新手红包的状态(改为已审核)
					Map red = receiptDao.selred(userid);
					if(red!=null && red.get("id")!=null){
						receiptDao.updateRed(red.get("id").toString());
					}
					//更新用户状态  改为不是新手
					receiptDao.updateUser(userid);
					//判断是否有邀请人
					if(mm.get("ReferrerID")!=null){
						//邀请人id
						String id  = mm.get("ReferrerID").toString();
						//修改邀请人的分享红包状态
						//根据回执单投资金额判断该给邀请人多少钱
						Double money = Double.parseDouble(m.get("InvestmentMoney").toString());
						String phone = mm.get("PhoneNumber").toString();
						String jine = null;
						if(money>=1000 && money<5000){
							jine = "5";
						}else if(money>=5000 && money<10000){
							jine = "10";
						}else if(money>=10000 && money<50000){
							jine = "15";
						} else if(money>=50000){
							jine = "20";
						}
						//给邀请人分享红包
						receiptDao.diuRed(time, id, phone, jine,Integer.parseInt(m.get("ID").toString()));
						//获得邀请人信息
						Map ymap = receiptDao.selectUser(id);
						if(ymap.get("BankName")!=null){
							ysfz = ymap.get("BankName").toString();
						}
						if(ymap.get("skr")!=null){
							yname = ymap.get("skr").toString();
						}
						if(ymap.get("CardNo")!=null){
							ycard = ymap.get("CardNo").toString();
						}
						yphone =  ymap.get("PhoneNumber").toString();
						if(ymap.get("alipayName")!=null){
							yAlipayName = ymap.get("alipayName").toString();
						}
						if(ymap.get("alipayId")!=null){
							yAlipayId=ymap.get("alipayId").toString();
						}
						ymoney = jine;
					}
				}else {//不是新手  是老手了
					Double umoney2 = Double.parseDouble(umoney);
					umoney = umoney2.toString();
				}
			}
			String payType2=null;//插入fMoney表中的支付方式
			if(type==1){
				payType2="支付宝";
			}else {
				payType2="银行卡";
			}
			//用户表累计收益加一下
			//用户已经有的累计收益
			String lj = mm.get("LJProfit").toString();
			Double lj2 = Double.parseDouble(lj)+Double.parseDouble(umoney);
			receiptDao.updateUser2(userid, lj2.toString());
			int a = receiptDao.insertUY(usfz, ucard, uphone, uname, umoney, uAlipayName,uAlipayId,ysfz, ycard, yphone, yname, ymoney,yAlipayName,yAlipayId,userid,time,receiptID,payType2);
			//读取平台信息
			Map bandm = receiptDao.selband(hid);
			Map objectnum = receiptDao.selObject(hid);
			Integer num = 0;
			//修改平台成功回执单数
			if(bandm!=null){
				if(bandm.get("ReceiptNum")!=null){
					num = Integer.parseInt(bandm.get("ReceiptNum").toString())+1;
				}
			}
			Integer num2 = 0;
			//修改项目参与人数
			if(objectnum!=null){
				num2 = Integer.parseInt(objectnum.get("Participants").toString())+1;
			}
			receiptDao.updateband(num, hid);
			receiptDao.updateobject(num2, hid);
		}

		return number;
	}
	
	/**
	 * 回单列表中对应平台查询
	 * */
	public List<BrandInformation> getBrandList() {
		List<BrandInformation> list = receiptDao.getBrandList();
		return list;
	}
	
	/**
	 * 获取财务默认的回单
	 * */
	
	public Map<String,Object> getCaiWuList(Integer pageNumber,Integer pageSize){
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		Map<String,Object> map = new HashMap<String, Object>();
		Integer total = receiptDao.getTotalYiBoHui(2);
		List<Receipt> list =  receiptDao.getCaiWuList(min,max);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getXinshou()!=null){
				list.get(i).setXshb(0);
			}else {
				list.get(i).setXshb(5);
			}
			if(list.get(i).getXinshou()!=null&&list.get(i).getReferrerID()!=null){
				int money = list.get(i).getInvestmentMoney();
				if(money>=1000 && money<=5000){
					list.get(i).setFxhb(5);
				}else if(money>=5000 && money<10000){
					list.get(i).setFxhb(10);
				}else if(money>=10000 && money<50000){
					list.get(i).setFxhb(15);
				}else if(money>=50000){
					list.get(i).setFxhb(20);
				}

			}else {
				list.get(i).setFxhb(0);
			}
		}
		map.put("rows",list);
		map.put("total",total);
		return  map;

	}

	public Map<String,Object> getReceiptList222(Integer pageNumber,Integer pageSize) {
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		Map<String,Object> map = new HashMap<String, Object>();
		List<Receipt> list = null;
		list = receiptDao.getReceiptList222(min,max);
		Integer total = receiptDao.getTotalReceipt(null,1,"","","","");
		map.put("rows",list);
		map.put("total",total);
		return  map;
	}

	public List<Receipt> getExcelList(Integer receiptID,Integer receiptState, String phoneNumber,String platform, String submissionTimeStart, String submissionTimeEnd) {
		List<Receipt> list = null;
		list = receiptDao.getExcelList( receiptID,1,phoneNumber,platform,submissionTimeStart,submissionTimeEnd);
		return list;
	}

	public List<DaiDaKuan> getExcelList2(String platform, String submissionTimeStart, String submissionTimeEnd) {
		List<DaiDaKuan> list = null;
		list = receiptDao.getExcelList2(platform,submissionTimeStart,submissionTimeEnd);
		return list;
	}

	public Map<String,Object> getfmoney(Integer receiptID,String phoneNumber, String submissionTimeStart, String submissionTimeEnd,Integer receiptState,Integer pageNumber,Integer pageSize){
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		String d = submissionTimeEnd;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");/*** 加一天*/
		try {
			if(d!=null&& d.length()> 0){
				Date dd = df.parse(d);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dd);
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				String ss = df.format(calendar.getTime());
				submissionTimeEnd=ss;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<FMoney> list = receiptDao.getfmoney(receiptID,phoneNumber,submissionTimeStart,submissionTimeEnd,receiptState,min,max);
		Integer total = receiptDao.getTotalCaiWu(receiptID,phoneNumber,submissionTimeStart,submissionTimeEnd,receiptState);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows",list);
		map.put("total",total);
		return map;
	}

	public List<FMoney> getfmoney2(Integer receiptID,String phoneNumber, String submissionTimeStart, String submissionTimeEnd,Integer receiptState) {
		String d = submissionTimeEnd;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");/*** 加一天*/
		try {
			if(d!=null&& d.length()> 0){
				Date dd = df.parse(d);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dd);
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				String ss = df.format(calendar.getTime());
				submissionTimeEnd=ss;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<FMoney> list = receiptDao.getfmoney2(receiptID,phoneNumber,submissionTimeStart,submissionTimeEnd,receiptState);
		return  list;
	}

	public Integer updateFmoney(Integer fmoneyID) {
		Integer num = receiptDao.updateFmoney(fmoneyID);
		return  num;
	}

/*	public Map<String, Object> getfmoney3( Integer pageNumber, Integer pageSize) {
		Integer min = (pageNumber-1)*pageSize+1;//计算该页显示几到几条
		Integer max = pageNumber*pageSize;
		Integer state = 0;
		List<FMoney> list = receiptDao.getfmoney("","","",state,min,max);
		Integer total = receiptDao.getWeiDaKuan();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("rows",list);
		map.put("total",total);
		return map;
	}*/

	public Integer updateBatchState(String ids,Integer receiptState) {
		String[] ss = ids.split(",");
	/*	List list = new ArrayList();
		for (int i=0;i<ss.length;i++){
			list.add(ss[i]);
		}*/
		Integer num = receiptDao.updateBatchState(ss,receiptState);
		return num;
	}

	public Map getFanLiSum(Integer receiptID,Integer receiptState,String phoneNumber,
						   String platform,String start_time_one,String end_time_one) {
		Double fanliSum = receiptDao.getFanLiSum(receiptID,receiptState,phoneNumber,platform,start_time_one,end_time_one);
		Map<String,Double> map = new HashMap<String, Double>();
		map.put("fanliSum",fanliSum);
		return map;
	}

	public Map getFmoneySum(Integer receiptID,Integer receiptState,String phoneNumber,
							String start_time_one,String end_time_one) {
		Map<String,Double> map = new HashMap<String, Double>();
		Double fanliSum = receiptDao.getFmoneySum(receiptID,receiptState,phoneNumber,start_time_one,end_time_one);
		map.put("fanliSum",fanliSum);
		return map;
	}

	public Integer updateBatchFmoneyState(String ids, Integer receiptState) {
		String[] ss = ids.split(",");
		Integer num = receiptDao.updateBatchFmoneyState(ss,receiptState);
		return num;
	}
}
