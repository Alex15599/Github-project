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
		String error="û�в��뵽��̨���ݿ��У�";
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
		String str="����";
		
		//�ж����޸������Ƿ����
		if( employeeManagerImpl.isEmployeebyname(sender)){
			request.setAttribute("erroremp", "*��Ա��������");
			return mapping.findForward("fail");
			
		}
		//�ж�ά���ʲ���״̬
		if( !str.equals(inOutAssetManagerImpl.zcStatus(zcid))){
			request.setAttribute("errorzcid", "*�˱���ʲ��ѽ����δά�����");
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
