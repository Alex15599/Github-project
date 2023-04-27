package com.niuys.gdzc.web.struts.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AssetPerAction extends BaseAction {
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		// 分页
		int pageCount = 10; // 每页显示的记录数
		int totalCount = 0; // 总记录数
		int currrentPage = 1; // 当前页面编号
		int totalPage = 0; // 页面总数

		String tempStr = request.getParameter("currentPage");
		if (tempStr != null) {
			currrentPage = Integer.parseInt(tempStr);

		}
		// 计算总记录数
		totalCount = assetPerManagerImpl.showAllPerAssets().size();

		// 计算总页数
		totalPage = (totalCount % pageCount == 0) ? (totalCount / pageCount)
				: (totalCount / pageCount + 1);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// 修正当前页面编号，确保： 1<=currrentPage<=totalPage
		if (currrentPage > totalPage) {
			currrentPage = totalPage;
		} else if (currrentPage < 1) {
			currrentPage = 1;
		}

		// 计算当前页面所显示的第一个记录的索引
		int pageStartRow = (currrentPage - 1) * pageCount;
		List list = assetPerManagerImpl.findPagePerAssets(pageStartRow, pageCount);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("pageCount", pageCount);
		session.setAttribute("countpage", totalPage);
		request.setAttribute("pages", currrentPage);
		request.setAttribute("list", list);
		
		return mapping.findForward("success");		
	
	}

}
