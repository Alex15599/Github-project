package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcWx;
import com.niuys.gdzc.web.struts.form.AddPerAssetForm;

public class AddPerAssetAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session=(HttpSession)request.getSession();
		String error="没有插入到后台数据库中！";
		AddPerAssetForm aaf = (AddPerAssetForm) form;

		ZcWx zcwx = new ZcWx();
		ZcInfo zcinfo=new ZcInfo();
		zcwx.setSendTime(aaf.getSend_time());
		String zcid=aaf.getZc_id();
		zcinfo.setZcId(zcid);
		zcwx.setZcInfo(zcinfo);
		String sender=aaf.getSender();
		zcwx.setSender(sender);
		zcwx.setLoginUser(aaf.getLogin_user());
		zcwx.setReason(aaf.getReason());
		String str="正常";
		
		//判断送修负责人是否存在
		if( employeeManagerImpl.isEmployeebyname(sender)){
			request.setAttribute("erroremp", "*该员工不存在");
			return mapping.findForward("fail");
			
		}
		//判断维修资产的状态
		if( !str.equals(inOutAssetManagerImpl.zcStatus(zcid))){
			request.setAttribute("errorzcid", "*此编号资产已借出或未维修完成");
			return mapping.findForward("fail");

		}
	
			if(assetPerManagerImpl.insertPerAssets(zcwx)){
			
				return mapping.findForward("success");
			}
			else
			{
				request.setAttribute("error",error);
				return mapping.findForward("fail");
			}
		} 

}
