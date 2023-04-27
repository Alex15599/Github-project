package com.dt.platform.workorder.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.workorder.ServiceDeskServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 服务台 模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-07 07:36:40
*/

@Controller("WoServiceDeskPageController")
@RequestMapping(ServiceDeskPageController.prefix)
public class ServiceDeskPageController extends ViewController {
	
	public static final String prefix="business/workorder/service_desk";

	private ServiceDeskServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ServiceDeskServiceProxy proxy() {
		if(proxy==null) {
			proxy=ServiceDeskServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 服务台 功能主页面
	 */
	@RequestMapping("/service_desk_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/service_desk_list";
	}

	/**
	 * 服务台 表单页面
	 */
	@RequestMapping("/service_desk_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/service_desk_form";
	}
}