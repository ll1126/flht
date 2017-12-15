package com.wsloan.fanLiWang.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {
	
	
	@Around("within(com.wsloan.channel.controller.*)")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		System.out.println(11);
		MultipleDataSource.setDataSourceKey("dataSourceZqp1");
		Object result = pjp.proceed();
		
		return result;
	}

}
