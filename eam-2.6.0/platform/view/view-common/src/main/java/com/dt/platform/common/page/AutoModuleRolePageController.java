package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.AutoModuleRoleServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 模块角色模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-04 15:14:31
*/

@Controller("SysAutoModuleRolePageController")
@RequestMapping(AutoModuleRolePageController.prefix)
public class AutoModuleRolePageController extends ViewController {

	public static final String prefix="business/common/auto_module_role";

	private AutoModuleRoleServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public AutoModuleRoleServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoModuleRoleServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 模块角色 功能主页面
	 */
	@RequestMapping("/auto_module_role_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"auto_module_role_list");
	}

	/**
	 * 模块角色 功能主页面
	 */
	@RequestMapping("/permission_downgrade_list.html")
	public String permlist(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"permission_downgrade_list");
	}


	/**
	 * 模块角色 表单页面
	 */
	@RequestMapping("/auto_module_role_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"auto_module_role_form");
	}
}