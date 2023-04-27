package com.niuys.gdzc.web.struts.action;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;

public class UpdateAssetsAction extends BaseAction {	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=(HttpSession)request.getSession();
		
		String id=request.getParameter("zc_id");
		ZcInfo zcinfo=assetManagerImpl.getOneZc(id);
		session.setAttribute("zcinfo", zcinfo);
		return mapping.findForward("success");		
	}
}
