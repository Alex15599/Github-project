package com.niuys.gdzc.web.struts.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niuys.gdzc.web.struts.form.LoginForm;

public class LoginAction extends BaseAction {	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		String err = "";

		HttpSession session=(HttpSession)request.getSession();
		//���ͼƬ�ϵ���֤��
		String randCode = (String) session.getAttribute("code");
		
		LoginForm lf=(LoginForm)form;
		String username=lf.getUsername();
		String password=lf.getPassword();

			if (lf.getCheckcode().equals(randCode)) {
				if (assetManagerImpl.login(username, password)) {
					// �ѵ�¼�ɹ����û���������cookie��
					Cookie c = new Cookie("username",username);
					c.setMaxAge(60 * 60 * 24);
					response.addCookie(c);

					// ��¼�ɹ���������ʾ���пγ̵�ҳ��
					String competence=userManaManagerImpl.competence(username);
					session.setAttribute("username", username);
					session.setAttribute("competence", competence);
					System.out.println("usernameΪ:"+username);
					System.out.println("passwordΪ:"+password);
					return mapping.findForward("success");
				} else {
					err = "�û������������";
				}
			} else {
			
				err = "��֤�����";
			}
			System.out.println(err+"====================");
			request.getSession().setAttribute("err", err);
			return mapping.findForward("fail");		
	}
}
