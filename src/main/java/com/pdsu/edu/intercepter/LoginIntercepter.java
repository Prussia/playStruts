package com.pdsu.edu.intercepter;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginIntercepter extends AbstractInterceptor {
	
	private static final Logger log = LoggerFactory.getLogger(LoginIntercepter.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		System.out.println(parameters.toString());
		log.info("user.username = " + parameters.get("user.username"));
//		return Action.INPUT;

		return invocation.invoke();
	}

}
