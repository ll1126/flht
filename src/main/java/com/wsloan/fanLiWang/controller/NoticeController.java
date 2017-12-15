package com.wsloan.fanLiWang.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Notice;
import com.wsloan.fanLiWang.service.NoticeService;
import com.wsloan.fanLiWang.util.JsonResult;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Resource
	private NoticeService noticeService;
	/**
	 * 录入标的信息
	 * */
	@RequestMapping("/addNotice.do")
	@ResponseBody
	public JsonResult addNotice(HttpSession session,Notice notice){
		
		Integer number = noticeService.addNotice(notice);
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		if(number==1){
			return new JsonResult(0,"","公告录入成功");
			
		}
		return new JsonResult(1,"","公告录入失败");
		
	}
	
	
	@RequestMapping("/deleteNotice.do")
	@ResponseBody
	public JsonResult deleteNotice(Integer noticeID,HttpSession session){
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		Integer number = noticeService.deleteNotice(noticeID);
		if(number==0){
			return new JsonResult(1,"","公告删除失败");
		}
		return new JsonResult(0,"","公告删除成功");
	}
	
	
	@RequestMapping("/getNoticeList.do")
	@ResponseBody
	public JsonResult getNoticeList(HttpSession session){
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		List<Notice> list= noticeService.getNoticeList();
		return new JsonResult(0,list,"查询失败");
	}
	
	@RequestMapping("/getOneNotice.do")
	@ResponseBody
	public JsonResult getOneNotice(HttpSession session,Integer noticeID){
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		Notice notice = noticeService.getOneNotice(noticeID);
		return new JsonResult(0,notice,"修改");
	}
	
	@RequestMapping("/updateNotice.do")
	@ResponseBody
	public JsonResult updateNotice(HttpSession session,Notice notice){
		
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		Integer number = noticeService.update(notice);
		if(number==1){
			return new JsonResult(0,number,"修改成功");
			
		}
		return new JsonResult(1,number,"修改失败");
	}
	
}