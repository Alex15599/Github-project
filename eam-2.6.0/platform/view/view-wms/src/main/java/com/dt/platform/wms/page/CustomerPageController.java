package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.CustomerServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 客户模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 12:16:11
*/

@Controller("WmsCustomerPageController")
@RequestMapping(CustomerPageController.prefix)
public class CustomerPageController extends ViewController {

	public static final String prefix="business/wms/customer";

	private CustomerServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public CustomerServiceProxy proxy() {
		if(proxy==null) {
			proxy=CustomerServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 客户 功能主页面
	 */
	@RequestMapping("/customer_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"customer_list");
	}

	/**
	 * 客户 表单页面
	 */
	@RequestMapping("/customer_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"customer_form");
	}
}