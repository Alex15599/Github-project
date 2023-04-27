package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.Department;
import com.niuys.gdzc.web.struts.form.EmployeeInfoForm;

public class AddEmployeeInfoAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		EmployeeInfoForm elf=(EmployeeInfoForm)form;
		Comployee com= new Comployee();
		Department dep=new Department();
		dep.setDept(elf.getEdept());
		String eno=elf.getEno();
		int age=0;
		try {
			age=Integer.parseInt(elf.getEage());
		} catch (Exception e) {

			e.printStackTrace();
		}
		com.setComployeeNo(eno);
		com.setDepartment(dep);
		com.setComployeeName(elf.getEname());
		com.setSex(elf.getEsex());
		com.setAge(age);
		com.setProfession(elf.getEpro());
		com.setAddress(elf.getEaddr());
		com.setPhone(elf.getEphone());
		com.setComployeeStatus(elf.getEstatus());
		
		if(age<18||age>150){
			request.setAttribute("errorage", "*年龄应在18-150之间");
			return mapping.findForward("fail");
		}
		if(employeeManagerImpl.isEmployeebyno(eno)){
			request.setAttribute("errorno", "*员工编号已存在");
			return mapping.findForward("fail");			
		}
		
//	System.out.println(employeeManagerImpl.insertEmployee(com));
		if(employeeManagerImpl.insertEmployee(com)){
			
			return mapping.findForward("success");
		}else{
			return mapping.findForward("fail");
		}

	}
	
	

}
