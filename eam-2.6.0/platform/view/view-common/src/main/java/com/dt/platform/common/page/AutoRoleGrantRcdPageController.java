package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.AutoRoleGrantRcdServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 操作日志模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:19:25
*/

@Controller("SysAutoRoleGrantRcdPageController")
@RequestMapping(AutoRoleGrantRcdPageController.prefix)
public class AutoRoleGrantRcdPageController extends ViewController {
	
	public static final String prefix="business/common/auto_role_grant_rcd";

	private AutoRoleGrantRcdServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoRoleGrantRcdServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoRoleGrantRcdServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 操作日志 功能主页面
	 */
	@RequestMapping("/auto_role_grant_rcd_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/auto_role_grant_rcd_list";
	}

	/**
	 * 操作日志 表单页面
	 */
	@RequestMapping("/auto_role_grant_rcd_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_role_grant_rcd_form";
	}
}