package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddEmployeeAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = (HttpSession) request.getSession();

		List list = null;

		try {
			list = employeeManagerImpl.showAlldept();
			session.setAttribute("list", list);
			return mapping.findForward("success");
		} catch (Exception e) {

			e.printStackTrace();
			return mapping.findForward("fail");
		}
	}

}
