package com.wsloan.fanLiWang.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wsloan.fanLiWang.entity.BackgroundUser;

/**
 * @Description: session监听器 用户唯一登录，后登陆挤掉先登录的
 * @author whl
 * @date 2014-10-21
 */

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	// log4j
	private final static Log log = LogFactory.getLog(SessionListener.class);

	// 保存当前登录的所有用户
	public static Map<String, HttpSession> loginUser = new HashMap<String, HttpSession>();

	// 用这个作为session中的key
	public static String SESSION_LOGIN_NAME = "user";

	// 执行setAttribute的时候, 当这个属性本来不存在于Session中时, 调用这个方法.
	public void attributeAdded(HttpSessionBindingEvent se) {

		// 如果添加的属性是用户名, 则加入map中
		if (se.getName().equals(SESSION_LOGIN_NAME)) {
			BackgroundUser u = (BackgroundUser) se.getValue();
			HttpSession session = loginUser.remove(u.getUserName());
			if (session != null) {
				session.removeAttribute("user");
			}
			loginUser.put(u.getUserName(), se.getSession());
		}

	}

	// 当执行removeAttribute时调用的方法
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// 如果移除的属性是用户名, 则从map中移除
		if (se.getName().equals(SESSION_LOGIN_NAME)) {
			try {
				BackgroundUser u = (BackgroundUser) se.getValue();
				loginUser.remove(u.getUserName());
			} catch (Exception e) {
				log.debug(e);
			}
		}
	}

	// 当执行setAttribute时 ,如果这个属性已经存在, 覆盖属性的时候, 调用这个方法
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// 如果改变的属性是用户名, 则跟着改变map
		if (se.getName().equals(SESSION_LOGIN_NAME)) {
			BackgroundUser u = (BackgroundUser) se.getValue();
			HttpSession session = loginUser.remove(u.getUserName());
			/*
			 * if (session != null) { session.removeAttribute("user"); }
			 */
			loginUser.put(u.getUserName(), se.getSession());
		}
	}

	// session创建时调用这个方法
	public void sessionCreated(HttpSessionEvent se) {
		log.debug("SessionListener........session创建-----" + se.getSession().getId());
	}

	// Session失效或者过期的时候调用的这个方法,
	public void sessionDestroyed(HttpSessionEvent se) {
		// 如果session超时, 则从map中移除这个用户
		try {
			BackgroundUser u = (BackgroundUser) se.getSession().getAttribute("user");
			System.out.println("destroy" + u);
			loginUser.remove(u.getUserName());
		} catch (Exception e) {
			log.debug(e);
		}
	}

}
