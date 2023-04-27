package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.web.struts.form.ZCForm;

public class LendZCAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message="";
		HttpSession session=(HttpSession)request.getSession();	
		
		String zcId=request.getParameter("zc_id");
		String comployeeNo=request.getParameter("em_id");
		String status=inOutAssetManagerImpl.zcStatus(zcId);
	
		if(!employeeManagerImpl.isEmployeebyno(comployeeNo)){
			message="此员工编号不存在！";
		}else if(status==null){
			message="此物品 不存在！";
		}else if(status.equals("维修")){
			message="此物品正在维修，无法借出！请选择其他资产！";
		}else if(status.equals("报废")){
			message="对不起，此物品已经报废！请选择其他资产！";
		}else if(status.equals("借出")){
			message="对不起，此物品已经借出！请选择其他资产！";
		}else{
		return mapping.findForward("success");
		}
		request.setAttribute("gdzc.status.message", message);
		return mapping.findForward("fail");
	}
}
