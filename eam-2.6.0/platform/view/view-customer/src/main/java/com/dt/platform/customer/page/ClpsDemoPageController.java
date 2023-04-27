package com.dt.platform.customer.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.customer.ClpsDemoServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * CLPS测试模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 08:52:09
*/

@Controller("CustClpsDemoPageController")
@RequestMapping(ClpsDemoPageController.prefix)
public class ClpsDemoPageController extends ViewController {

	public static final String prefix="business/customer/clps_demo";

	private ClpsDemoServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public ClpsDemoServiceProxy proxy() {
		if(proxy==null) {
			proxy=ClpsDemoServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * CLPS测试 功能主页面
	 */
	@RequestMapping("/clps_demo_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"clps_demo_list");
	}

	/**
	 * CLPS测试 表单页面
	 */
	@RequestMapping("/clps_demo_form.html")
	public String form(Model model,HttpServletRequest request , Long id) {
		return getTemplatePath(prefix,"clps_demo_form");
	}
}