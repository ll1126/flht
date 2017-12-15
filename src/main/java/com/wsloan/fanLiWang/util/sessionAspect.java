package com.wsloan.fanLiWang.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wsloan.fanLiWang.entity.BackgroundUser;

//@Aspect
//@Component
public class sessionAspect {

	@Around("within(com.wsloan.channel.controller.*Controller)")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		HttpServletResponse response = sra.getResponse();
		HttpSession session = request.getSession();
		BackgroundUser user = (BackgroundUser) session.getAttribute("user");
		Object result = null;
		// System.out.println("-----"+user);
		// System.out.println(response);
		if (user == null) {
			System.out.println("没有session");
			System.out.println("aaa"+response);
			response.sendRedirect("../login.html");
			// return false;
		} else {
			result = pjp.proceed();
		}
		return result;
	}
}
