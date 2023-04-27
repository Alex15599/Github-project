package com.niuys.gdzc.web.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.model.ZcInfo;
import com.niuys.gdzc.util.DataPageBean;


public class StoreInShowAllAction extends BaseAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
//开始分页
		
		List<ZcInfo> list = assetManagerImpl.showAllAssets();
		DataPageBean dpb = new DataPageBean();
		int _countRecord = list.size();
		dpb.setAll(_countRecord, 3);
		
		int currentPage = 1;
		String currentPage1 = request.getParameter("currentPage");
		if(currentPage1 != null){
			currentPage = Integer.parseInt(currentPage1);
		}
		
		if(currentPage>dpb.getCountPage()){
			currentPage=dpb.getCountPage();
		}else if(currentPage< 1){
			currentPage = 1;
		}
		
		int begin = (currentPage-1)*dpb.getSizePage();
		int size = dpb.getSizePage();
		
		List<ZcInfo> listPage = assetManagerImpl.findPageAssets(begin, size);
		
//结束分页
		
		request.setAttribute("countRecord", _countRecord);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("countPage", dpb.getCountPage());
		request.setAttribute("StoreInlist", listPage);
		return mapping.findForward("success");
	}

}
