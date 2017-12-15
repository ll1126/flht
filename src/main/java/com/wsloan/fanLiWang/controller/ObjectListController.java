package com.wsloan.fanLiWang.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.ObjectList;
import com.wsloan.fanLiWang.service.ObjectListService;
import com.wsloan.fanLiWang.util.JsonResult;

@Controller
@RequestMapping("/objectList")
public class ObjectListController {
	@Resource
	private ObjectListService objectListService;
	/**
	 * 录入标的信息
	 * */
	@RequestMapping("/addObject.do")
	@ResponseBody
	public JsonResult addObject(HttpSession session,ObjectList objectList,MultipartFile file){
//		String[] ss = platformIDString.split(",");
//		Integer id = Integer.valueOf(ss[0]);
//		String platform = ss[1];
		
		//4位随机数
		
		if(file!=null){
			int a = (int)(Math.random()*(9999-1000+1))+1000;
			//以日期为文件名
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = sdf.format(new Date());
//			// 获得原始文件名
			String fileName = file.getOriginalFilename();
			fileName= fileName.split("\\.")[1];
//			// 新文件名
//			String newFileName = UUID.randomUUID() + fileName;
			// 获得项目的路径
			ServletContext sc = session.getServletContext();
			// 上传位置
			
			String newFileName = dateNow+a+'.'+fileName;
			String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			if (!file.isEmpty()) {
				FileOutputStream fos = null;
				InputStream in=null;
				try {
					fos = new FileOutputStream(path +'/'+ newFileName);
					in  = file.getInputStream();
					int b = 0;
					while ((b = in.read()) != -1) {
						fos.write(b);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						fos.close();
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			
			String platformLogo = newFileName;
			objectList.setPlatformLogo(platformLogo);
		}
		
		int zhiding = 0;
		int participants=0;
		objectList.setParticipants(participants);
		objectList.setZhiding(zhiding);
		if(objectList.getZdljapp()!=null&&objectList.getZdljapp()==null){
			objectList.setPcapp(0);
		}
		if(objectList.getZdljapp()==null&&objectList.getZdljapp()!=null){
			objectList.setPcapp(1);
		}
		int number = objectListService.addObject(objectList);
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(0,"","未登录，请重新登录");
		}
		if(number==1){
			return new JsonResult(0,"","标的录入成功");
			
		}
		return new JsonResult(1,"","标的录入失败");
		
	}
	
	/**
	 * 标的删除
	 * */
	@RequestMapping("/deleteObject.do")
	@ResponseBody
	public JsonResult deleteObject(Integer objectID,HttpSession session){
		BackgroundUser user =(BackgroundUser)session.getAttribute("user");
		int number = objectListService.deleteObject(objectID);
		if(user==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}else{
			if(number==0){
				return new JsonResult(1,"","标的删除失败");
			}
			return new JsonResult(0,"","标的删除成功");
		}
	}
	
	/**
	 * 标的的修改
	 * */
	
	@RequestMapping("/updateObject.do")
	@ResponseBody
	public JsonResult updateObject(HttpSession session,ObjectList objectList,MultipartFile file,HttpServletRequest request){
		if(file!=null){
			int a = (int)(Math.random()*(9999-1000+1))+1000;
			//以日期为文件名
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = sdf.format(new Date());
//			// 获得原始文件名
			String fileName = file.getOriginalFilename();
			fileName= fileName.split("\\.")[1];
//			// 新文件名
//			String newFileName = UUID.randomUUID() + fileName;
			// 获得项目的路径
			ServletContext sc = session.getServletContext();
			// 上传位置
			
			String newFileName = dateNow+a+'.'+fileName;
			String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			if (!file.isEmpty()) {
				FileOutputStream fos = null;
				InputStream in = null;
				try {
					fos = new FileOutputStream(path +'/'+ newFileName);
				 	in = file.getInputStream();
					int b = 0;
					while ((b = in.read()) != -1) {
						fos.write(b);
					}
					fos.close();
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			String platformLogo = newFileName;
			objectList.setPlatformLogo(platformLogo);
		}
		
		if(objectList.getZdljapp()!=null&&objectList.getZdljapp()==null){
			objectList.setPcapp(0);
		}
		if(objectList.getZdljapp()==null&&objectList.getZdljapp()!=null){
			objectList.setPcapp(1);
		}
		
		int number = objectListService.update(objectList);
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		if(number==0){
			return new JsonResult(1,"","标的修改失败");
		}
		
		return new JsonResult(0,"","标的修改成功");
	}
	
	/**
	 * 获取一条标的详情
	 * */
	@RequestMapping("/getOneObject.do")
	@ResponseBody
	public JsonResult getOneObjet(Integer objectID,HttpSession session){
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		ObjectList objectList = objectListService.getOneObject(objectID);
		if(user==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		return new JsonResult(0,objectList,"标的详情");
	}
	
	/**
	 * 获取标的列表
	 * */
	@RequestMapping("/getObjectList.do")
	@ResponseBody
	public JsonResult getObjectList(HttpSession session,String platform,Integer shangjia){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		List<ObjectList> list = null;
		list=objectListService.getObjectList(platform,shangjia);
		return new JsonResult(0,list,"标的列表");
	}

	/*
	* 单独修改项目排序
	* */
	@RequestMapping("/updatePaixu.do")
	@ResponseBody
	public JsonResult updatePaixu(HttpSession session,Integer paixu,Integer id){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Integer numb = objectListService.updatePaixu(paixu,id);
		if(numb==1){
			return  new JsonResult(0,"","更新排序成功");
		}else {
			return new JsonResult(1,"","更新失败");
		}
	}
}
