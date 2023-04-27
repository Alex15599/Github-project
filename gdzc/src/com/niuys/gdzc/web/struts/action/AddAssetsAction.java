package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.web.struts.form.ZCForm;

public class AddAssetsAction extends BaseAction {	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {	
		HttpSession session=(HttpSession)request.getSession();
		ZCForm zc = (ZCForm) form;
		String err1="入库时间必须晚于产品的生产日期";
		String err2="资产编号已经存在";
		
		ZcInfo zcinfo=new ZcInfo();
		zcinfo.setZcId(zc.getZc_id());
		zcinfo.setZcNo(zc.getZc_no());
		zcinfo.setZcName(zc.getZc_name());
		zcinfo.setZcPrice(Float.parseFloat(zc.getZc_price()));
		zcinfo.setZcFactory(zc.getZc_factory());
		zcinfo.setZcProduceTime(zc.getZc_produceTime());
		zcinfo.setZcBuyTime(zc.getZc_buyTime());		
		zcinfo.setZcBuyer(zc.getZc_buyer());
		zcinfo.setZcType(zc.getZc_type());
		zcinfo.setZcStatus(zc.getZc_status()); 
		zcinfo.setZcBzxx(zc.getZc_bzxx());	
		
		String zc_buyTime = zc.getZc_buyTime();
		String[] buy_numbers = zc_buyTime.split("-");
		int buy_year = Integer.parseInt(buy_numbers[0]);
		int buy_month = Integer.parseInt(buy_numbers[1]);
		int buy_date = Integer.parseInt(buy_numbers[2]);

		String zc_proTime =zc.getZc_produceTime();
		String[] pro_numbers = zc_proTime.split("-");
		int pro_year = Integer.parseInt(pro_numbers[0]);
		int pro_month = Integer.parseInt(pro_numbers[1]);
		int pro_date = Integer.parseInt(pro_numbers[2]);

		if(assetManagerImpl.checkZCID(zc.getZc_id())){
			if (buy_year >= pro_year) {
				if (buy_year == pro_year) {
					if (buy_month >= pro_month) {
						if (buy_month == pro_month) {
							if (buy_date >= pro_date) {
								assetManagerImpl.addAssets(zcinfo);
								return mapping.findForward("success");
							} else {
								request.setAttribute("gdzc.add.error1", err1);
								return mapping.findForward("fail");
							}
						}else{
							assetManagerImpl.addAssets(zcinfo);
							return mapping.findForward("success");
							}
					} else {
						request.setAttribute("gdzc.add.error1", err1);
						return mapping.findForward("fail");
					}
				} else {
					assetManagerImpl.addAssets(zcinfo);
					return mapping.findForward("success");
				}
			}else{
				request.setAttribute("gdzc.add.error1", err1);
				return mapping.findForward("fail");
			}
		}else{
			request.setAttribute("gdzc.add.error2", err2);
			return mapping.findForward("fail");
		}
	}
}
