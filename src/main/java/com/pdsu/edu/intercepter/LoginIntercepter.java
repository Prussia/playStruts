package com.pdsu.edu.intercepter;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.pdsu.edu.domain.User;

public class LoginIntercepter extends AbstractInterceptor {

	private static final Logger log = LoggerFactory.getLogger(LoginIntercepter.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String namespace = invocation.getProxy().getNamespace();  
        String actionName = invocation.getProxy().getActionName();  
//        invocation.getStack().findValue("user.username");
//        invocation.getProxy().getAction().
          
        if(
        		("/user".equals(namespace) && "user_login".equals(actionName))
        		) {  
            return invocation.invoke();  
        } else {  
            Map<String, Object> session = ActionContext.getContext().getSession();  
            User user = (User) session.get("cur_user");  
            if(user == null) {  
                return Action.LOGIN;  
            } else {  
                return invocation.invoke();  
            }  
              
        }  

	}

}
