package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;

public class PrintStoreInAction extends BaseAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		List<ZcInfo> list = assetManagerImpl.showAllAssets();
		
		
		   
		request.setAttribute("list", list);
		return mapping.findForward("success");
	}

}
