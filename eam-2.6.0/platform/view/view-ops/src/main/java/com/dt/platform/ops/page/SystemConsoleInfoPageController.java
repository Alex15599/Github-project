package com.dt.platform.ops.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.ops.SystemConsoleInfoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 管理台台账 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-04 07:30:05
*/

@Controller("OpsSystemConsoleInfoPageController")
@RequestMapping(SystemConsoleInfoPageController.prefix)
public class SystemConsoleInfoPageController extends ViewController {
	
	public static final String prefix="business/ops/system_console_info";

	private SystemConsoleInfoServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public SystemConsoleInfoServiceProxy proxy() {
		if(proxy==null) {
			proxy=SystemConsoleInfoServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 管理台台账 功能主页面
	 */
	@RequestMapping("/system_console_info_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/system_console_info_list";
	}

	/**
	 * 管理台台账 表单页面
	 */
	@RequestMapping("/system_console_info_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/system_console_info_form";
	}
}