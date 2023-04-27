package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.web.struts.form.ZCForm;

public class BackZCAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message="";
		HttpSession session=(HttpSession)request.getSession();	
		
		String inoutNo=request.getParameter("inout_no");
		String zcId=request.getParameter("zc_id");
		
		if(inOutAssetManagerImpl.backZC(inoutNo, zcId)){
			return mapping.findForward("success");
		}
		return mapping.findForward("fail");
	}
}
