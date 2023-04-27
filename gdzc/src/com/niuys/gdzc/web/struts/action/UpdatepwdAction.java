package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.web.struts.form.UpdatepwdForm;

public class UpdatepwdAction extends BaseAction {


	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UpdatepwdForm utf=(UpdatepwdForm)form;
		String username=utf.getUsername();
		String oldpwd=utf.getOldpwd();
		String newpwd=utf.getNewpwd();
		
		if(userManaManagerImpl.ispwd(username, oldpwd)){
			if(userManaManagerImpl.changepwd(username, newpwd)){
				System.out.println("–¬√‹¬Î:"+newpwd);
				return mapping.findForward("success");
			}
			else{
				return mapping.findForward("fail");
			}			
		}
		else{
			request.setAttribute("error", "*æ…√‹¬Î”–ŒÛ");
			return mapping.findForward("fail");
		}

	}

}
