package com.dt.platform.customer.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.customer.RepiarDemoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 报修模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 09:23:38
*/

@Controller("CustRepiarDemoPageController")
@RequestMapping(RepiarDemoPageController.prefix)
public class RepiarDemoPageController extends ViewController {

	public static final String prefix="business/customer/repiar_demo";

	private RepiarDemoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public RepiarDemoServiceProxy proxy() {
		if(proxy==null) {
			proxy=RepiarDemoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 报修 功能主页面
	 */
	@RequestMapping("/repiar_demo_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"repiar_demo_list");
	}

	/**
	 * 报修 表单页面
	 */
	@RequestMapping("/repiar_demo_form.html")
	public String form(Model model,HttpServletRequest request , Long id) {
		return getTemplatePath(prefix,"repiar_demo_form");
	}
}