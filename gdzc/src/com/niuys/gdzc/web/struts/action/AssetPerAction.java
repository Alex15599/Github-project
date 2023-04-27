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
		// ��ҳ
		int pageCount = 10; // ÿҳ��ʾ�ļ�¼��
		int totalCount = 0; // �ܼ�¼��
		int currrentPage = 1; // ��ǰҳ����
		int totalPage = 0; // ҳ������

		String tempStr = request.getParameter("currentPage");
		if (tempStr != null) {
			currrentPage = Integer.parseInt(tempStr);

		}
		// �����ܼ�¼��
		totalCount = assetPerManagerImpl.showAllPerAssets().size();

		// ������ҳ��
		totalPage = (totalCount % pageCount == 0) ? (totalCount / pageCount)
				: (totalCount / pageCount + 1);
		if (totalPage == 0) {
			totalPage = 1;
		}

		// ������ǰҳ���ţ�ȷ���� 1<=currrentPage<=totalPage
		if (currrentPage > totalPage) {
			currrentPage = totalPage;
		} else if (currrentPage < 1) {
			currrentPage = 1;
		}

		// ���㵱ǰҳ������ʾ�ĵ�һ����¼������
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
