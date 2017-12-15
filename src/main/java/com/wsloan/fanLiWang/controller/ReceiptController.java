package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.*;
import com.wsloan.fanLiWang.service.ReceiptService;
import com.wsloan.fanLiWang.util.ExcelException;
import com.wsloan.fanLiWang.util.ExportExcel;
import com.wsloan.fanLiWang.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {
	
	@Resource 
	private ReceiptService receiptService;
	
	/**
	 * 获取回执单列表
	 * */
	@RequestMapping("/getReceiptList.do")
	@ResponseBody
	public JsonResult getReceiptList(Integer receiptID,Integer receiptState,String phoneNumber,String platform,String start_time_one,String end_time_one,
									 Integer pageNumber,Integer pageSize,HttpSession session){
		BackgroundUser user = (BackgroundUser) session.getAttribute("user");
		if(user==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Map<String,Object> map = receiptService.getReceiptList(receiptID, receiptState,phoneNumber,platform,start_time_one,end_time_one,pageNumber,pageSize);
		return new JsonResult(0,map,"回单列表");
	}
	
	/**
	 * 根据回执单ID更新回执单
	 * */
	@RequestMapping("/updateState.do")
	@ResponseBody
	public JsonResult updateState(Integer receiptID,Integer receiptState,HttpSession session){
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Integer number = receiptService.updateState(receiptID, receiptState);
		if(number==0){
			return new JsonResult(1,"","更新回执单状态失败");
		}
		return new JsonResult(0,"","更新回执单状态成功");
	}
	
	/**
	 * 
	 * 获取回单页面的平台列表
	 * */
	@RequestMapping("/getBrandList.do")
	@ResponseBody
	public JsonResult getPlatformList(HttpSession session){
		BackgroundUser user = (BackgroundUser) session.getAttribute("user");
		if(user==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		List<BrandInformation> list = null;
		list = receiptService.getBrandList();
		return new JsonResult(0,list,"回单列表");
		
	}
	
	/**
	 * 查看财务默认的回单
	 * */
	@RequestMapping("/getCaiWuList.do")
	@ResponseBody
	public JsonResult getCaiWuList(HttpSession session,Integer pageNumber,Integer pageSize){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Map<String,Object> map  =receiptService.getCaiWuList(pageNumber,pageSize);
		return new JsonResult(0,map,"回单列表");
	}
	
	/**
	 * 一审查看的回单
	 * */
	@RequestMapping("/getReceiptList222.do")
	@ResponseBody
	public JsonResult getReceiptList222(HttpSession session,Integer pageNumber,Integer pageSize){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Map<String,Object> map =receiptService.getReceiptList222(pageNumber,pageSize);
		return new JsonResult(0,map,"回单列表");
	}

	/**
	 * 导出Excel
	 * @throws ExcelException 
	 * */
	@RequestMapping("/exportExcel.do")
	@ResponseBody
	public void exportExcel(Integer receiptID,Integer receiptState,String phoneNumber, String platform, String start_time_one, String end_time_one, HttpSession session, HttpServletRequest req, HttpServletResponse response) throws ExcelException{
		List<Receipt> list = null;
		list=receiptService.getExcelList(receiptID,receiptState,phoneNumber,platform,start_time_one,end_time_one);
		ExportExcel<DaiShenHe> ex = new ExportExcel<DaiShenHe>();
		List<DaiShenHe> dataset = new ArrayList<DaiShenHe>();
		String[] headers = { "回执单编号", "平台名","第三方平台返利利率","给用户返利方式","给用户返利金额/返利利率", "注册手机号", "注册用户名" ,"投资金额","标的期限","投资时间","推荐人ID","返利金额","代理商"};
		for(int i = 0;i<list.size();i++){
			DaiShenHe daiShenHe = new DaiShenHe();
			daiShenHe.setId(list.get(i).getID());
			daiShenHe.setPlatform(list.get(i).getPlatform());
			daiShenHe.setPhone(list.get(i).getPhoneNumber());
			if(list.get(i).getPlatformUser()!=null){
				daiShenHe.setYonghu(list.get(i).getPlatformUser());
			}
			daiShenHe.setInvestMoney(list.get(i).getInvestmentMoney());
			daiShenHe.setInvestLimit(list.get(i).getInvestmentLimit());
			daiShenHe.setInvestTime(list.get(i).getSubmissionTime());
			if(list.get(i).getUserID()!=null){
				daiShenHe.setRefferID(list.get(i).getUserID());
			}
			if(list.get(i).getFandian()!=null){
				if(list.get(i).getFandian()==0){
					daiShenHe.setFandian("区间式");
				}else {
					daiShenHe.setFandian("浮点式");
				}
			}
			if(list.get(i).getRebateScheme()!=null){
				if(list.get(i).getFandian()!=null){
					if(list.get(i).getFandian()==0){
						daiShenHe.setRebateScheme(list.get(i).getRebateScheme()+"元");
					}else {
						daiShenHe.setRebateScheme(list.get(i).getRebateScheme()+"%");
					}

				}

			}
			if(list.get(i).getDisanfang()!=null){
				daiShenHe.setDisanfang(list.get(i).getDisanfang()+"%");

			}
			if(list.get(i).getBeAgent()!=null&&list.get(i).getBeAgent()==1){
				daiShenHe.setDailishang(list.get(i).getSkr());
			}
			daiShenHe.setFanli(list.get(i).getFanli());
			dataset.add(daiShenHe);
		}
		try {
			req.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			OutputStream out = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename="+new String("待审核回单.xls".getBytes(),"ISO-8859-1"));// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=utf-8");// 定义输出类型
			ex.exportExcel(headers, dataset, out);
			out.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 财务待打款回执单导出Excel
	 * */

	@RequestMapping("/exportExcel2.do")
	@ResponseBody
	public void exportExcel2(Integer receiptID,String phoneNumber,String start_time_one,String end_time_one,Integer receiptState,
							 HttpSession session,HttpServletRequest req, HttpServletResponse response) throws ExcelException{
		List<FMoney> list = receiptService.getfmoney2(receiptID,phoneNumber, start_time_one, end_time_one,receiptState);
		ExportExcel<FMoney> ex = new ExportExcel<FMoney>();
		String[] headers = { "回执单编号", "用户姓名", "用户卡开户行", "用户手机号" ,"用户银行卡号","用户支付宝用户名","用户支付宝账号","返利总金额","推荐人卡开户行","推荐人手机号","推荐人银行卡号",
				"推荐人支付宝用户名","推荐人支付宝账号","推荐人红包","推荐人姓名","回单提交时间","支付方式"};
		try {
			req.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			OutputStream out = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename="+new String("财务待打款回单.xls".getBytes(),"ISO-8859-1"));// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=utf-8");// 定义输出类型
			ex.exportExcel(headers, list, out);
			out.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	* 默认展示财务待打款列表
	* *//*
	@RequestMapping("/getfmoney3.do")
	@ResponseBody
	public JsonResult getfmoney3(HttpSession session,Integer pageNumber,Integer pageSize){
		JsonResult jsonResult = new JsonResult();
		try {
			BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
			if(backgroundUser==null){
				jsonResult.setCode(1);
				jsonResult.setMessage("未登录，请重新登录");
			} else {
				Map<String,Object> map = receiptService.getfmoney3(pageNumber,pageSize);
				jsonResult.setCode(JsonResult.SUCCESS);
				jsonResult.setMessage("财务待打款回执单列表");
				jsonResult.setContent(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setMessage("系统异常！");
		}
		return jsonResult;

	}*/

	/**
	 * 筛选财务打款表
	 * */
	@RequestMapping("/getfmoney.do")
	@ResponseBody
	public JsonResult getfmoney(Integer receiptID,String phoneNumber,String start_time_one,String end_time_one,Integer receiptState,HttpSession session,
								Integer pageNumber,Integer pageSize){
		JsonResult jsonResult = new JsonResult();
		try {
			BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
			if(backgroundUser==null){
                jsonResult.setCode(1);
                jsonResult.setMessage("未登录，请重新登录");
            } else {
				Map<String,Object> map = receiptService.getfmoney(receiptID,phoneNumber,start_time_one,end_time_one,receiptState,pageNumber,pageSize);
				jsonResult.setCode(JsonResult.SUCCESS);
				jsonResult.setMessage("财务待打款回执单列表");
				jsonResult.setContent(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setMessage("系统异常！");
		}
		return jsonResult;
	}

	/*
	* 更新财务待打款状态
	* */
	@RequestMapping("/updateFmoney.do")
	@ResponseBody
	public  JsonResult updateFmoney(Integer fmoneyID){
		JsonResult jsonResult = new JsonResult();
		Integer num = receiptService.updateFmoney(fmoneyID);
		if (num==null){
			jsonResult.setCode(1);
			jsonResult.setContent("");
			jsonResult.setMessage("更新状态失败");
			return jsonResult;
		}else {
			jsonResult.setCode(0);
			jsonResult.setContent(num);
			jsonResult.setMessage("更新状态成功");
			return jsonResult;
		}
	}

	/*
	* 批量审核（一审）通过
	* */
	@RequestMapping("/updateBatchState.do")
	@ResponseBody
	public  JsonResult updateBatchState(String ids,Integer receiptState,HttpSession session){

		JsonResult jsonResult = new JsonResult();
		try {
			BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
			if(backgroundUser==null){
				jsonResult.setCode(1);
				jsonResult.setMessage("未登录，请重新登录");
			} else {
				Integer num = receiptService.updateBatchState(ids,receiptState);
				String[] s2 = ids.split(",");
				List list = new ArrayList();
					for (int i=0;i<s2.length;i++){
						receiptService.updateState(Integer.parseInt(s2[i]),receiptState);
					}

				if (num>0){
					jsonResult.setCode(JsonResult.SUCCESS);
					jsonResult.setMessage("批量审核成功");
					jsonResult.setContent(num);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setMessage("系统异常！");
		}
		return jsonResult;
	}

	/*待审核页面加载待审核返利总金额*/
	@RequestMapping("/getFanLiSum.do")
	@ResponseBody
	public JsonResult getFanLiSum(Integer receiptID,Integer receiptState,String phoneNumber,
								  String platform,String start_time_one,String end_time_one){
		JsonResult jsonResult = new JsonResult();
		Map map = receiptService.getFanLiSum(receiptID,receiptState,phoneNumber,platform,start_time_one,end_time_one);
		jsonResult.setCode(JsonResult.SUCCESS);
		jsonResult.setContent(map);
		jsonResult.setMessage("返利总金额");
		return jsonResult;
	}

	/*财务打款页面用户返利总金额*/
	@RequestMapping("/getFmoneySum.do")
	@ResponseBody
	public JsonResult getFmoneySum(Integer receiptID,Integer receiptState,String phoneNumber,
								  String start_time_one,String end_time_one){
		JsonResult jsonResult = new JsonResult();
		Map map = receiptService.getFmoneySum(receiptID,receiptState,phoneNumber,start_time_one,end_time_one);
		jsonResult.setCode(JsonResult.SUCCESS);
		jsonResult.setContent(map);
		jsonResult.setMessage("返利总金额");
		return jsonResult;
	}

	/*
	* 批量打款
	* */
	@RequestMapping("/updateBatchFmoneyState.do")
	@ResponseBody
	public  JsonResult updateBatchFmoneyState(String ids,Integer receiptState,HttpSession session){

		JsonResult jsonResult = new JsonResult();
		try {
			BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
			if(backgroundUser==null){
				jsonResult.setCode(1);
				jsonResult.setMessage("未登录，请重新登录");
			} else {
				Integer num = receiptService.updateBatchFmoneyState(ids,receiptState);
				if (num>0){
					jsonResult.setCode(JsonResult.SUCCESS);
					jsonResult.setMessage("批量审核成功");
					jsonResult.setContent(num);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setMessage("系统异常！");
		}
		return jsonResult;
	}

}
