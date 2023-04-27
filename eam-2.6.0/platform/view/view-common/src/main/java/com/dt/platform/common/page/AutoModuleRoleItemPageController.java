package com.dt.platform.common.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.common.AutoModuleRoleItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 赋权明细模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:04:25
*/

@Controller("SysAutoModuleRoleItemPageController")
@RequestMapping(AutoModuleRoleItemPageController.prefix)
public class AutoModuleRoleItemPageController extends ViewController {
	
	public static final String prefix="business/common/auto_module_role_item";

	private AutoModuleRoleItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public AutoModuleRoleItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=AutoModuleRoleItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 赋权明细 功能主页面
	 */
	@RequestMapping("/auto_module_role_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/auto_module_role_item_list";
	}

	/**
	 * 赋权明细 表单页面
	 */
	@RequestMapping("/auto_module_role_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/auto_module_role_item_form";
	}
}