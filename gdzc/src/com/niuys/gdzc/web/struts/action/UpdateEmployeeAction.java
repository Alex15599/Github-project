package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.Department;
import com.niuys.gdzc.web.struts.form.EditEmployeeForm;

public class UpdateEmployeeAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		EditEmployeeForm eef=(EditEmployeeForm)form;
		Department dep=new Department();
		Comployee com=new Comployee();
		int age=Integer.parseInt(eef.getEage());
		
		dep.setDept(eef.getEdept());
		com.setComployeeNo(eef.getEno());
		com.setDepartment(dep);
		com.setComployeeName(eef.getEname());
		com.setSex(eef.getEsex());
		com.setAge(age);
		com.setProfession(eef.getEpro());
		com.setAddress(eef.getEaddr());
		com.setPhone(eef.getEphone());
		com.setComployeeStatus(eef.getEstatus());
		
		if(age<18 ||age>150 ){
			request.setAttribute("error", "*年龄应在18-150之间");
			return mapping.findForward("fail");
		}
		
		if(employeeManagerImpl.updateEmployee(com)){
			return mapping.findForward("success");
			
		}
		else{
			return mapping.findForward("fail");
			
		}
	}
	

}
