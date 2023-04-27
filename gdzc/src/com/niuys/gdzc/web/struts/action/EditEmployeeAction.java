package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.web.struts.form.EditEmployeeForm;

public class EditEmployeeAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=(HttpSession)request.getSession();

		EditEmployeeForm eef=(EditEmployeeForm)form;
       List list=null;
       List listemp=null;
		try {
			list=employeeManagerImpl.showAlldept();
			session.setAttribute("upemplist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		try {
			String eno=request.getParameter("eno");
			listemp= employeeManagerImpl.findEmployeebyeno(eno);
			Comployee com=(Comployee)listemp.get(0);
//	
//			com.getComployeeNo();
//			com.getComployeeName();
//			com.getSex();
//			com.getAge();
//			com.getDepartment().getDept();
//			com.getProfession();
//			com.getAddress();
//			com.getPhone();
//			com.getComployeeStatus();
			
			session.setAttribute("com", com);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapping.findForward("success");

		

	}
	

}
