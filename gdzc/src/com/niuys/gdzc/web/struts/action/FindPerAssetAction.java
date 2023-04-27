package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcWx;
import com.niuys.gdzc.web.struts.form.FindPerAssetForm;

public class FindPerAssetAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=(HttpSession)request.getSession();
		FindPerAssetForm faf=(FindPerAssetForm)form;
		String num=request.getParameter("repair_no");
		int id=Integer.parseInt(num);
		List list=null;
		
		try {
		list=assetPerManagerImpl.findPerAssetbyid(id);
		ZcWx zc= (ZcWx)list.get(0);
		faf.setRepair_no(zc.getRepairNo()+"");
		
		faf.setZc_id(zc.getZcInfo().getZcId());
		
		faf.setSend_time(zc.getSendTime());
		faf.setSender(zc.getSender());
		faf.setLogin_user(zc.getLoginUser());
		faf.setReason(zc.getReason());
		faf.setWx_time(zc.getWx_time());
		faf.setWx_result(zc.getWx_result());
		faf.setCost(zc.getCost()+"");
		faf.setWx_comment(zc.getWx_comment());	
		
		} catch (Exception e) {
			e.printStackTrace();
		return mapping.findForward("fail");			
		}		
		session.setAttribute("updatePerAssetlist", list);
		return mapping.findForward("success");
	}
	

}
