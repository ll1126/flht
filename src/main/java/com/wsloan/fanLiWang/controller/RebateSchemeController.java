package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.RebateScheme;
import com.wsloan.fanLiWang.service.RebateSchemeService;
import com.wsloan.fanLiWang.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/rebate")
public class RebateSchemeController {
	@Resource
	private RebateSchemeService rebateSchemeService;
	@RequestMapping("/addScheme.do")
	@ResponseBody
	/**
	 * 录入返利方案
	 * */
	public JsonResult addScheme(HttpSession session,RebateScheme rebateScheme){
		
			BackgroundUser user = (BackgroundUser)session.getAttribute("user");
			if(user==null){
				return new JsonResult(1,"","未登录，请重新登录");
			}
			Integer number = rebateSchemeService.addScheme(rebateScheme);
			if(number==0){
				return new JsonResult(1,"","返利方案录入失败");
			}
			return new JsonResult(0,"","返利方案录入成功");
		}
	/**
	 * 删除平台信息
	 * */
	
	@RequestMapping("/deleteScheme.do")
	@ResponseBody
	public JsonResult deleteBrand(HttpSession session,Integer schemeID){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Integer number = rebateSchemeService.deleteScheme(schemeID);
		if(number==0){
			return new JsonResult(1,"","删除返利方案失败");
		}
		return new JsonResult(0,"","删除返利方案成功");
	}


	/**
	 * 获取返利方案列表
	 * */
	@RequestMapping("/getSchemeList.do")
	@ResponseBody
	public JsonResult getSchemeList(HttpSession session,Integer objectID2,String objectName,Integer shangjia){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		List<RebateScheme> list = null;
		
		list=rebateSchemeService.getScheme(objectID2,objectName,shangjia);
		return new JsonResult(0,list,"返利方案列表");
	}
	
	
	/**
	 * 方案的修改
	 * */
	
	@RequestMapping("/updateScheme.do")
	@ResponseBody
	public JsonResult updateScheme(HttpSession session,RebateScheme rebateScheme){
		int number = rebateSchemeService.updateScheme(rebateScheme);
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		if(number==0){
			return new JsonResult(1,number,"方案修改失败");
		}
		
		return new JsonResult(0,number,"方案修改成功");
	}
	
	
	/**
	 * 一条方案详情
	 * */
	
	@RequestMapping("/getOneScheme.do")
	@ResponseBody
	public JsonResult getOneScheme(HttpSession session,Integer schemeID){
		RebateScheme rebateScheme = rebateSchemeService.getOneScheme(schemeID);
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		
		return new JsonResult(0,rebateScheme,"方案详情");
	}
}
