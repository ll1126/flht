package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.Banner;
import com.wsloan.fanLiWang.service.BannerService;
import com.wsloan.fanLiWang.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {
	@Resource
	private BannerService bannerService;
	/**
	 * 录入PC端banner
	 * */
	@RequestMapping("/addPCBanner.do")
	@ResponseBody
	public JsonResult addPCBanner(HttpSession session, Banner banner, MultipartFile PCFile){
		if(PCFile!=null){
			int a = (int)(Math.random()*(9999-1000+1))+1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = sdf.format(new Date());
			String fileName = PCFile.getOriginalFilename();
			fileName= fileName.split("\\.")[1];
			ServletContext sc = session.getServletContext();
			String newFileName = dateNow+a+'.'+fileName;
			String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			if (!PCFile.isEmpty()) {
				FileOutputStream fos = null;
				InputStream in=null;
				try {
					fos = new FileOutputStream(path +'/'+ newFileName);
					in  = PCFile.getInputStream();
					int c = 0;
					while ((c = in.read()) != -1) {
						fos.write(c);
					}
					fos.close();
					in.close();
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
			banner.setImage(newFileName);
		}
		JsonResult jsonResult = new JsonResult();
		try {
			BackgroundUser user = (BackgroundUser)session.getAttribute("user");
			if(user == null){
				jsonResult.setCode(JsonResult.ERROR);
				jsonResult.setMessage("未登录，请重新登录");
				return jsonResult;
			}
			Integer number = bannerService.addPCBanner(banner);
			jsonResult.setCode(JsonResult.SUCCESS);
			jsonResult.setContent("");
			jsonResult.setMessage("录入成功");

		}catch(Exception e){
			e.printStackTrace();
		}

		return jsonResult;
		
	}

	/**
	 * 录入APP端banner
	 * */
	@RequestMapping("/addAPPBanner.do")
	@ResponseBody
	public JsonResult addAPPBanner(HttpSession session, Banner banner, MultipartFile appFile){
		if(appFile!=null){
			int a = (int)(Math.random()*(9999-1000+1))+1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = sdf.format(new Date());
			String fileName = appFile.getOriginalFilename();
			fileName= fileName.split("\\.")[1];
			ServletContext sc = session.getServletContext();
			String newFileName = dateNow+a+'.'+fileName;
			String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			if (!appFile.isEmpty()) {
				FileOutputStream fos = null;
				InputStream in=null;
				try {
					fos = new FileOutputStream(path +'/'+ newFileName);
					in  = appFile.getInputStream();
					int b = 0;
					while ((b = in.read()) != -1) {
						fos.write(b);
					}
					fos.close();
					in.close();
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
			banner.setAppimage(newFileName);
		}

		JsonResult jsonResult = new JsonResult();
		try {
			BackgroundUser user = (BackgroundUser)session.getAttribute("user");
			if(user == null){
				jsonResult.setCode(JsonResult.ERROR);
				jsonResult.setMessage("未登录，请重新登录");
				return jsonResult;
			}
			Integer number = bannerService.addAPPBanner(banner);
			jsonResult.setCode(JsonResult.SUCCESS);
			jsonResult.setContent("");
			jsonResult.setMessage("录入成功");

		}catch(Exception e){
			e.printStackTrace();
		}

		return jsonResult;

	}

	/**
	 * banner删除
	 * */
	@RequestMapping("/deleteBanner.do")
	@ResponseBody
	public JsonResult deleteBanner(Integer bannerID,HttpSession session){
		JsonResult jsonResult = new JsonResult();
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		if(user == null){
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setMessage("未登录，请重新登录");
			return jsonResult;
		}
		Integer number = bannerService.deleteBanner(bannerID);
		if(number==0){
			jsonResult.setCode(JsonResult.SUCCESS);
			jsonResult.setContent("");
			jsonResult.setMessage("删除成功");
		}else {
			jsonResult.setCode(JsonResult.ERROR);
			jsonResult.setContent("");
			jsonResult.setMessage("轮播录入失败");
		}

		return jsonResult;
	}
	
	/**
	 * PC端banner的修改
	 * */
	
	@RequestMapping("/updatePCBanner.do")
	@ResponseBody
	public JsonResult updatePCBanner(HttpSession session,Banner banner, MultipartFile PCFile){
		if(PCFile!=null){
			int a = (int)(Math.random()*(9999-1000+1))+1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = sdf.format(new Date());
			String fileName = PCFile.getOriginalFilename();
			fileName= fileName.split("\\.")[1];
			ServletContext sc = session.getServletContext();
			String newFileName = dateNow+a+'.'+fileName;
			String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			if (!PCFile.isEmpty()) {
				FileOutputStream fos = null;
				InputStream in=null;
				try {
					fos = new FileOutputStream(path +'/'+ newFileName);
					in  = PCFile.getInputStream();
					int c = 0;
					while ((c = in.read()) != -1) {
						fos.write(c);
					}
					fos.close();
					in.close();
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
			banner.setImage(newFileName);
		}

		JsonResult jsonResult = new JsonResult();

		try {
			BackgroundUser user = (BackgroundUser)session.getAttribute("user");
			if(user == null){
				jsonResult.setCode(JsonResult.ERROR);
				jsonResult.setMessage("未登录，请重新登录");
				return  jsonResult;
			}
			Integer number = bannerService.updatePCBanner(banner);
			jsonResult.setCode(JsonResult.SUCCESS);
			jsonResult.setContent("");
			jsonResult.setMessage("修改成功");
		}catch(Exception e){
			e.printStackTrace();
		}

		return jsonResult;

	}

	/*
	* APP端banner修改
	* */

	@RequestMapping("/updateAPPBanner.do")
	@ResponseBody
	public JsonResult updateAPPBanner(HttpSession session,Banner banner, MultipartFile appFile){
		if(appFile!=null){
			int a = (int)(Math.random()*(9999-1000+1))+1000;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateNow = sdf.format(new Date());
			String fileName = appFile.getOriginalFilename();
			fileName= fileName.split("\\.")[1];
			ServletContext sc = session.getServletContext();
			String newFileName = dateNow+a+'.'+fileName;
			String path = sc.getRealPath("/UploadFile/"); // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			if (!appFile.isEmpty()) {
				FileOutputStream fos = null;
				InputStream in=null;
				try {
					fos = new FileOutputStream(path +'/'+ newFileName);
					in  = appFile.getInputStream();
					int b = 0;
					while ((b = in.read()) != -1) {
						fos.write(b);
					}
					fos.close();
					in.close();
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
			banner.setAppimage(newFileName);
		}
		JsonResult jsonResult = new JsonResult();

		try {
			BackgroundUser user = (BackgroundUser)session.getAttribute("user");
			if(user == null){
				jsonResult.setCode(JsonResult.ERROR);
				jsonResult.setMessage("未登录，请重新登录");
				return  jsonResult;
			}
			Integer number = bannerService.updateAPPBanner(banner);
			jsonResult.setCode(JsonResult.SUCCESS);
			jsonResult.setContent("");
			jsonResult.setMessage("修改成功");
		}catch(Exception e){
			e.printStackTrace();
		}

		return jsonResult;

	}
	/**
	 * 获取一条banner详情
	 * */
	@RequestMapping("/getOneBanner.do")
	@ResponseBody
	public JsonResult getOneBanner(Integer bannerID,HttpSession session){
		BackgroundUser user = (BackgroundUser)session.getAttribute("user");
		Banner banner = bannerService.getOneBanner(bannerID);
		if(user==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		return new JsonResult(0,banner,"标的详情");
	}
	
	/**
	 * 获取标的列表
	 * */
	@RequestMapping("/getBannerList.do")
	@ResponseBody
	public JsonResult getBannerList(HttpSession session){
		BackgroundUser backgroundUser = (BackgroundUser)session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		List<Banner> list = null;
		list=bannerService.queryBanner();
		//String savePath = session.getServletContext().getRealPath("/") + "UploadFile/";
		/*for(int i=0;i<list.size();i++){
			if(list.get(i).getImage()!=null){
				String image ="D:/201797backGroundFanLiWang/BackgroundFanLiWang/target/BackgroundFanLiWang/UploadFile/"+ list.get(i).getImage();
				list.get(i).setImage(image);
			}
			if(list.get(i).getAppimage()!=null){
				String appimage = "D:/201797backGroundFanLiWang/BackgroundFanLiWang/target/BackgroundFanLiWang/UploadFile/"+list.get(i).getAppimage();
				list.get(i).setAppimage(appimage);
			}
		}*/
		return new JsonResult(0,list,"banner列表");
	}

}
