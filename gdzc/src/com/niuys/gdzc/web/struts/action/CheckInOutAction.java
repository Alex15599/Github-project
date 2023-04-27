package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.Comployee;
import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcWx;
import com.niuys.gdzc.web.struts.form.FindPerAssetForm;
import com.niuys.gdzc.web.struts.form.ZCForm;

public class CheckInOutAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=(HttpSession)request.getSession();		
		String zcId=request.getParameter("zc_id");
		String comployeeNo=request.getParameter("e_id");
		
		Comployee comployee=inOutAssetManagerImpl.getOneEmployee(comployeeNo);
		session.setAttribute("comployee", comployee);
		ZcInfo zcinfo=inOutAssetManagerImpl.getOneZc(zcId);
		session.setAttribute("zcinfo", zcinfo);
		
		return mapping.findForward("success");		
	}
}

