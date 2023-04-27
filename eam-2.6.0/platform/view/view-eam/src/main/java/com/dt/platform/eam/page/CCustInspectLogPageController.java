package com.dt.platform.eam.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.eam.CCustInspectLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 执行日志模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-10 10:17:17
*/

@Controller("EamCCustInspectLogPageController")
@RequestMapping(CCustInspectLogPageController.prefix)
public class CCustInspectLogPageController extends ViewController {

	public static final String prefix="business/eam/c_cust_inspect_log";

	private CCustInspectLogServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CCustInspectLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=CCustInspectLogServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 执行日志 功能主页面
	 */
	@RequestMapping("/c_cust_inspect_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"c_cust_inspect_log_list");
	}

	/**
	 * 执行日志 表单页面
	 */
	@RequestMapping("/c_cust_inspect_log_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"c_cust_inspect_log_form");
	}
}