package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.model.ZcWx;
import com.niuys.gdzc.web.struts.form.FindPerAssetForm;

public class UpdatePerAssetAction extends BaseAction {

	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		FindPerAssetForm faf=(FindPerAssetForm)form;
		ZcWx zc=new ZcWx();
		ZcInfo zif=new ZcInfo();
		zc.setRepairNo(Integer.parseInt(faf.getRepair_no()));

		zif.setZcId(faf.getZc_id());
	
		zc.setZcInfo(zif);
		
		zc.setSendTime(faf.getSend_time());
		zc.setSender(faf.getSender());
		zc.setLoginUser(faf.getLogin_user());
		zc.setReason(faf.getReason());
		zc.setWx_time(faf.getWx_time());
		zc.setWx_result(faf.getWx_result());
		zc.setCost( Float.parseFloat(faf.getCost()));
		zc.setWx_comment(faf.getWx_comment());
		
		if(assetPerManagerImpl.updatePerAsset(zc)){
			return mapping.findForward("success");
		}
		else{
			return mapping.findForward("fail");
		}

	}
	
	

}
