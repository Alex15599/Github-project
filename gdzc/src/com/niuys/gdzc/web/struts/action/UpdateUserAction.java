package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.UserInfo;
import com.niuys.gdzc.web.struts.form.AddUserForm;

public class UpdateUserAction extends BaseAction {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserInfo user=new UserInfo();
		Comployee com =new Comployee();
		String comployeeNo=request.getParameter("comployeeNo");
		com.setComployeeNo(comployeeNo);
		user.setComployee(com);
		user.setUserName(request.getParameter("userName"));
		user.setCompetence(request.getParameter("competence"));
		
		if(userManaManagerImpl.updateUser(user)){
			return mapping.findForward("success");
		}
		else
		{
			return mapping.findForward("fail");
		}

	}
	
	

}
