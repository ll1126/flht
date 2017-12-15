package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.BackgroundUser;
import com.wsloan.fanLiWang.entity.FMoney;
import com.wsloan.fanLiWang.entity.Receipt;
import com.wsloan.fanLiWang.entity.User;
import com.wsloan.fanLiWang.service.UserService;
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
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {
	  @Resource(name="userService")
      private UserService userService;
	  /**
		* 用户登录
	    */
		@RequestMapping("/login.do")
		@ResponseBody
		public JsonResult login(HttpServletRequest request,String username,String pwd){
			BackgroundUser user = userService.login(username,pwd);
			HttpSession session = request.getSession();
			if(user!=null){
				
				session.setAttribute("user", user);
				return new JsonResult(0, user, "登录成功！");
			}
			return new JsonResult(1,"","登录失败");
			//	session.setMaxInactiveInterval(120*60);
		}
		/**
		 * 退出登录，返回到登录界面
		 */
		@ResponseBody
		@RequestMapping("/logout.do")
		 public JsonResult logout(HttpSession session){
			session.removeAttribute("user");
			return  new JsonResult(0,"","退出登录");
		}
		
		
		/**
		 *修改密码 
		 */
		@RequestMapping("/updatePwd.do")
		@ResponseBody
		public JsonResult updatePassword(String oldpwd,String newpwd,String userName){
			Integer i = userService.updatePwd(oldpwd, newpwd, userName);
			if(i!=null){
				return new JsonResult(0,i,"修改密码成功");
			}
			return new JsonResult(1,"","修改密码失败");
		}
		
		
		/**
		 * 获取用户信息列表
		 * */
		@RequestMapping("/getUserList.do")
		@ResponseBody
		public JsonResult getUserList(Integer pageNumber,Integer pageSize,HttpSession session,String phoneNumber){
			BackgroundUser backUser = (BackgroundUser)session.getAttribute("user");
			if(backUser==null){
				return new JsonResult(1,"","未登录，请重新登录");
			}
//			List<User> list = null;
//			list = userService.getUserList(phoneNumber);
			Map<String,Object> map = userService.getUserList(pageNumber,pageSize,phoneNumber);
			return new JsonResult(0,map,"获取用户信息列表");
			
		}
		
		/**
		 * 拉入黑名单
		 * */
		@RequestMapping("/updateUserState.do")
		@ResponseBody
		public JsonResult updateUserState(HttpSession session,Integer userID){
			BackgroundUser backUser = (BackgroundUser)session.getAttribute("user");
			if(backUser==null){
				return new JsonResult(1,"","未登录，请重新登录");
			}
			Integer number= userService.updateUserState(userID);
			return new JsonResult(0,number,"拉黑成功");
			
		}
		
		/**
		 * 查看用户的回执单
		 * */
		@RequestMapping("/getUserReceipt.do")
		@ResponseBody
		public JsonResult getUserReceipt(HttpSession session,Integer userID){
			BackgroundUser backUser = (BackgroundUser)session.getAttribute("user");
			if(backUser==null){
				return new JsonResult(1,"","未登录，请重新登录");
			}
			List<Receipt> receipt= userService.getUserReceipt(userID);
			return new JsonResult(0,receipt,"拉黑成功");
			
		}
		
		/**
		 * 获得推荐人列表
		 * */
		@RequestMapping("/getTuijianren.do")
		@ResponseBody
		public JsonResult getTuijianren(HttpSession session,Integer refferredID){
			BackgroundUser backUser = (BackgroundUser)session.getAttribute("user");
			if(backUser==null){
				return new JsonResult(1,"","未登录，请重新登录");
			}
			List<User> list = userService.getTuijianren(refferredID);
			return new JsonResult(0,list,"推荐人列表");
			
		}

	/**
	 * 获得验证码
	 * */
	@RequestMapping("/getCode.do")
	@ResponseBody
	public JsonResult getCode(HttpSession session, String phoneNumber){
		BackgroundUser backUser = (BackgroundUser)session.getAttribute("user");
		if(backUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		Map map = userService.getCode(phoneNumber);
		return new JsonResult(0,map,"验证码");

	}

	/*
	* 导出用户Excel信息
	* */
	@RequestMapping("/exportUser.do")
	@ResponseBody
	public  JsonResult exportUser(HttpSession session,String start_time_one,String end_time_one,HttpServletRequest req, HttpServletResponse response){
		BackgroundUser backgroundUser =(BackgroundUser) session.getAttribute("user");
		if(backgroundUser==null){
			return new JsonResult(1,"","未登录，请重新登录");
		}
		List<User> list = userService.exportUser(start_time_one,end_time_one);
		ExportExcel<User> ex = new ExportExcel<User>();
		String[] headers = { "用户编号", "用户手机号", "真实姓名", "收款银行账户" ,"推荐人ID","用户来源","绑卡时间"};
		try {
			req.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			OutputStream out = response.getOutputStream();// 取得输出流
			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename="+new String("用户信息列表.xls".getBytes(),"ISO-8859-1"));// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=utf-8");// 定义输出类型
			ex.exportExcel(headers, list, out);
			out.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  null;
	}

	/*成为代理商*/
	@RequestMapping("/beAgent.do")
	@ResponseBody
	public JsonResult beAgent(HttpSession session,Integer userID,Integer beAgent){
		JsonResult jsonResult = new JsonResult();
		BackgroundUser backgroundUser = (BackgroundUser) session.getAttribute("user");
		if(backgroundUser==null){
			jsonResult.setMessage("未登录，请重新登录");
			jsonResult.setContent("");
			jsonResult.setCode(JsonResult.ERROR);
			return jsonResult;
		}
		Integer num = userService.beAgent(userID,beAgent);
		if(num>0){
			jsonResult.setCode(JsonResult.SUCCESS);
			jsonResult.setContent(num);
			jsonResult.setMessage("成为代理成功");
		}
		return jsonResult;
	}

}
