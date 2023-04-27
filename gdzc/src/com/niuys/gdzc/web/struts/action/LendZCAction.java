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
			message="��Ա����Ų����ڣ�";
		}else if(status==null){
			message="����Ʒ �����ڣ�";
		}else if(status.equals("ά��")){
			message="����Ʒ����ά�ޣ��޷��������ѡ�������ʲ���";
		}else if(status.equals("����")){
			message="�Բ��𣬴���Ʒ�Ѿ����ϣ���ѡ�������ʲ���";
		}else if(status.equals("���")){
			message="�Բ��𣬴���Ʒ�Ѿ��������ѡ�������ʲ���";
		}else{
		return mapping.findForward("success");
		}
		request.setAttribute("gdzc.status.message", message);
		return mapping.findForward("fail");
	}
}
