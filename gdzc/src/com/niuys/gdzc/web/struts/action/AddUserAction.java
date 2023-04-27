package com.niuys.gdzc.web.struts.action;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.UserInfo;
import com.niuys.gdzc.web.struts.form.AddUserForm;

public class AddUserAction extends BaseAction {


	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		AddUserForm auf= (AddUserForm)form;
		UserInfo user=new UserInfo();
		Comployee com=new Comployee();
		
		user.setUserName(auf.getUserName());
		user.setPwd(auf.getPassword());
		user.setCompetence(auf.getCompetence());
		String eno=auf.getComployeeNo();
		com.setComployeeNo(eno);
		user.setComployee(com);
		
		if(!employeeManagerImpl.isEmployeebyno(eno)){
			request.setAttribute("error", "*员工编号不存在");
			return mapping.findForward("fail");			
		}
		
		if(userManaManagerImpl.insertUser(user)){
			return mapping.findForward("success");

		}
		else{
			return mapping.findForward("fail");

		}

	}


	

}
