package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcInout;
import com.niuys.gdzc.model.ZcWx;
import com.niuys.gdzc.web.struts.form.FindPerAssetForm;
import com.niuys.gdzc.web.struts.form.ZCForm;

public class ZCInOutAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String err="";
		HttpSession session=(HttpSession)request.getSession();
		
		ZcInfo info=new ZcInfo();
		ZcInout inout=new ZcInout();
		
		String zcId=request.getParameter("zc_id");
		String comployeeNo=request.getParameter("comployeeNo");
		
		info.setZcId(zcId);
		inout.setZcInfo(info);
		inout.setComployeeNo(comployeeNo);
		
		List list=inOutAssetManagerImpl.ZCInOut(inout);
		if(list.size()==0){
			err = "您输入的信息有误！";
			request.setAttribute("gdzc.zcinout.error", err);
		}else{
		request.setAttribute("list", list);
		}
		return mapping.findForward("success");
	}
}

