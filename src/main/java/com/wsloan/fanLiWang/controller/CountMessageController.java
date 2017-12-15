package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.CountMessage;
import com.wsloan.fanLiWang.service.CountMessageService;
import com.wsloan.fanLiWang.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/count")
public class CountMessageController {
	@Resource
	private CountMessageService countMessageService;
	/**
	 * 查看统计信息
	 * */
	@RequestMapping("/getCountMessage.do")
	@ResponseBody
	public JsonResult getCountMessage(HttpSession session,String submissionTimeStart,String submissionTimeEnd){
		
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		List<CountMessage> list = countMessageService.getCountMessage(submissionTimeStart,submissionTimeEnd);
		return new JsonResult(0,list,"统计成功");
		
	}

	/*根据时间查询注册，绑卡等用户信息数量*/
	@RequestMapping("/getZuoRiShuJu.do")
	@ResponseBody
	public  JsonResult getZuoRiShuJu(HttpSession session,String date_start,String date_end){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		JsonResult jsonResult = new JsonResult();
		if(backgroundUser==null){
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setContent("");
			jsonResult.setMessage("未登录，请重新登录");
			return jsonResult;
		}
		List<Map> list = null;
		list=countMessageService.getZuoRiShuJu(date_start,date_end);
		jsonResult.setCode(JsonResult.SUCCESS);
		jsonResult.setContent(list);
		jsonResult.setMessage("查询成功");
		return jsonResult;

	}

	@RequestMapping("/getTotalShuJu.do")
	@ResponseBody
	public  JsonResult getTotalShuJu(HttpSession session){
		JsonResult jsonResult = new JsonResult();
		List<Map> list = null;
		list=countMessageService.getTotalShuJu();
		jsonResult.setCode(JsonResult.SUCCESS);
		jsonResult.setContent(list);
		jsonResult.setMessage("查询成功");
		return jsonResult;

	}

	@RequestMapping("/getNowShuJu.do")
	@ResponseBody
	public  JsonResult getNowShuJu(){
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date_start=dateFormat.format(now);
		String date_end=dateFormat.format(now);
		JsonResult jsonResult = new JsonResult();
		List<Map> list = null;
		list=countMessageService.getZuoRiShuJu(date_start,date_end);
		jsonResult.setCode(JsonResult.SUCCESS);
		jsonResult.setContent(list);
		jsonResult.setMessage("查询成功");
		return jsonResult;

	}

}