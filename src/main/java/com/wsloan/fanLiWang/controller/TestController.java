package com.wsloan.fanLiWang.controller;

import com.wsloan.fanLiWang.entity.User;
import com.wsloan.fanLiWang.service.TestService;
import com.wsloan.fanLiWang.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
	  @Resource
      private TestService testService;

		@RequestMapping("/getUserList.do")
		@ResponseBody
		public JsonResult getUserList(Integer pageNumber,Integer pageSize){
			List<User> list = testService.getUserList(pageNumber,pageSize);
			return  new JsonResult(0,list,"成功");
		}

}
