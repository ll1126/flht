package com.wsloan.fanLiWang.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wsloan.fanLiWang.util.JsonResult;
import com.wsloan.fanLiWang.util.MyWebSocket;


public abstract class BaseController {
	@Resource
	MyWebSocket mywebsocket;
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult exceptionHandle(Exception e) {
		//参数e就是被捕获到的异常对象
		e.printStackTrace();
		return new JsonResult(e);
	}

}