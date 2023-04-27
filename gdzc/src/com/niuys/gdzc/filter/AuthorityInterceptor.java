package com.niuys.gdzc.filter;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.struts.action.ActionMapping;

public class AuthorityInterceptor implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		HttpServletRequest request = null;
		ActionMapping mapping = null;
		Object[] args = invocation.getArguments();
		for (int i = 0; i < args.length; i++) {
			if (args[i] instanceof HttpServletRequest)
				request = (HttpServletRequest) args[i];
			if (args[i] instanceof ActionMapping)
				mapping = (ActionMapping) args[i];
		}
		
		if(request.getSession().getAttribute("username")!=null)
		{
			return invocation.proceed();	
		}else{
			return mapping.findForward("faillogin");
		}

		
	}

}
