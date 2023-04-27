package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DeleteEmployeeAction extends BaseAction {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		String eno=request.getParameter("eno");
		
		if(employeeManagerImpl.deleteEmployee(eno)){
			return mapping.findForward("success");
		}
		else{
			return mapping.findForward("fail");
		}
		
	}
	
	

}
