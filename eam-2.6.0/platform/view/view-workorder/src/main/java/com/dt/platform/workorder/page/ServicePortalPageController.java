package com.dt.platform.workorder.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.workorder.ServicePortalServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 服务门户 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-08 22:24:19
*/

@Controller("WoServicePortalPageController")
@RequestMapping(ServicePortalPageController.prefix)
public class ServicePortalPageController extends ViewController {
	
	public static final String prefix="business/workorder/service_portal";

	private ServicePortalServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ServicePortalServiceProxy proxy() {
		if(proxy==null) {
			proxy=ServicePortalServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 服务门户 功能主页面
	 */
	@RequestMapping("/service_portal_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/service_portal_list";
	}

	/**
	 * 服务门户 表单页面
	 */
	@RequestMapping("/service_portal_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/service_portal_form";
	}
}