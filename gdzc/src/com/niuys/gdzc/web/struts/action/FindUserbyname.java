package com.niuys.gdzc.web.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.UserInfo;
import com.niuys.gdzc.web.struts.form.AddUserForm;

public class FindUserbyname extends BaseAction {


	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("~~~~~~~~~~~~~~~~~~");
		AddUserForm auf=new AddUserForm();
		List list=new ArrayList();	
		String name=request.getParameter("username");
		
		try {
			list=userManaManagerImpl.findUserbyname(name);
			UserInfo uif=(UserInfo)list.get(0);
			request.setAttribute("compno", uif.getComployee().getComployeeNo());
			request.setAttribute("userName", uif.getUserName());
			return mapping.findForward("success");
		} catch (Exception e) {
			e.printStackTrace();
			return mapping.findForward("fail");
		}

	}
	
	

}
