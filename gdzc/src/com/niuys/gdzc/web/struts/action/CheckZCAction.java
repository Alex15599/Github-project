package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.web.struts.form.SelectZCForm;
public class CheckZCAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String err="";
		
		SelectZCForm zc = (SelectZCForm) form;
		String zcId=zc.getZc_id();
		String zcFactory=zc.getZc_factory();
		String zcNo=zc.getZc_no();
		String zcType=zc.getZc_type();
		String zcName=zc.getZc_name();
		String zcStatus=zc.getZc_status();
		String zcBuyer=zc.getZc_buyer();
		
		List list=assetManagerImpl.checkZC(zcId, zcFactory, zcNo, zcName, zcType, zcStatus, zcBuyer);
		if(list.size()==0){
			err = "您输入的查询信息有误！";
			request.setAttribute("gdzc.check.error", err);
		}else{
		request.setAttribute("list", list);
		}
		return mapping.findForward("success");
	}
}

