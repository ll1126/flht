package com.wsloan.fanLiWang.controller;

import java.io.File;
import java.io.FileOutputStream;
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
import com.wsloan.fanLiWang.entity.BrandInformation;
import com.wsloan.fanLiWang.service.BrandInformationService;
import com.wsloan.fanLiWang.util.JsonResult;

@Controller
@RequestMapping("/brandInformation")
public class BrandInformationController {
	@Resource
	private BrandInformationService brandInformationService;
	
	@RequestMapping("/addBrand.do")
	@ResponseBody
	/**
	 * 录入平台信息
	 * */
	public JsonResult addBrand(HttpSession session,BrandInformation brandInformation){
		/*String platformLogo=session.getServletContext().getRealPath("/upload");
		String filename="";
		 if(file!=null){
			    String extention = file.getOriginalFilename().substring(
			    		file.getOriginalFilename().lastIndexOf(".")+1);
			    filename  = WorkOderUtil.createId()+"."+extention;
			   //导入Apache 文件上载包和配置上载解析器
				try {
					FileUploadorDown.fileUpload(file, filename, platformLogo);
				} catch (IOException e) {
					e.printStackTrace();
				//	throw new WorkOrderNotFindException("文件上传失败！");
				}
		}*/
		
		// 获得原始文件名
//				String fileName = file.getOriginalFilename();
//				// 新文件名
//				String newFileName = UUID.randomUUID() + fileName;
//
//				// 获得项目的路径
//				ServletContext sc = session.getServletContext();
//				// 上传位置
//				//以日期为文件名
////				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
////				String dateNow = sdf.format(new Date());
//				String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
//				File f = new File(path);
//				if (!f.exists())
//					f.mkdirs();
//				if (!file.isEmpty()) {
//					try {
//						FileOutputStream fos = new FileOutputStream(path + newFileName);
//						InputStream in = file.getInputStream();
//						int b = 0;
//						while ((b = in.read()) != -1) {
//							fos.write(b);
//						}
//						fos.close();
//						in.close();
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
		//	String platformLogo = "UploadFile/" +newFileName;
		
			BackgroundUser user = (BackgroundUser)session.getAttribute("user");
			if(user==null){
				return new JsonResult(1,"","未登录，请重新登录");
			}
			Integer number = brandInformationService.addBrand(brandInformation);
			if(number==null){
				return new JsonResult(1,"","品牌信息录入失败");
			}
			return new JsonResult(0,number,"品牌信息录入成功");
		}
	/**
	 * 删除平台信息
	 * */
	@RequestMapping("/deleteBrand.do")
	@ResponseBody
	public JsonResult deleteBrand(HttpSession session,Integer brandID){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Integer number = brandInformationService.deleteBrand(brandID);
		if(number==null){
			return new JsonResult(1,"","删除平台信息失败");
		}
		return new JsonResult(0,"","删除平台信息成功");
	}

	/**
	 * 获取平台列表
	 * */
	@RequestMapping("/getBrandList.do")
	@ResponseBody
	public JsonResult getBrandList(HttpSession session,String platform,Integer shangjia){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		List<BrandInformation> list = null;
		list=brandInformationService.getBrandList(platform,shangjia);
		return new JsonResult(0,list,"标的列表");
	}
	
	/**
	 * 获取平台详情
	 * */
	@RequestMapping("/getBrandDetails.do")
	@ResponseBody
	public JsonResult getBrandDetails(Integer brandID,HttpSession session,HttpServletRequest request){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		BrandInformation brandInformation = brandInformationService.getBrandDetails(brandID);
		return new JsonResult(0,brandInformation,"工单详情");
	}
	/**
	 * 修改平台信息
	 * */
	@RequestMapping("/updateBrand.do")
	@ResponseBody
	public JsonResult updateBrand(BrandInformation brandInformation,HttpSession session){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Integer number = brandInformationService.updateBrand(brandInformation);
		if(number==null){
			return new JsonResult(1,"","平台信息修改失败");
		}
		return new JsonResult(0,"","平台修改成功");
	}

	/**
	 * 下架平台，同时下架项目和返利方案
	 * */
	@RequestMapping("/xiajiaBrand.do")
	@ResponseBody
	public  JsonResult xiajiaBrand(Integer brandID,Integer platState,HttpSession session){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Integer number = brandInformationService.xiajiaBrand(brandID,platState);
		if(number==null){
			return new JsonResult(1,"","平台下架失败");
		}
		return new JsonResult(0,"","平台下架成功");

	}
	
}
