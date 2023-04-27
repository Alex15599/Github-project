package com.niuys.gdzc.web.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class FindPerAssetbyPro extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("*********");

		List list=new ArrayList();
		int no=1;
		try {
			no = Integer.parseInt( request.getParameter("repair_no"));
		} catch (Exception e1) {
		}
		String sendtime=request.getParameter("send_time");
		String login_user=request.getParameter("login_user");
		String sender=request.getParameter("sender");
		String wx_result=request.getParameter("wx_result");
		
		try {
			list=assetPerManagerImpl.findPerAssetbyPro(sendtime,no, login_user,sender, wx_result);
			request.setAttribute("listbypro", list);
			System.out.println("00000000000000000000000000000");
			return mapping.findForward("success");
		} catch (Exception e) {

			e.printStackTrace();
		}

		return mapping.findForward("fail");
	}
	
	

}
