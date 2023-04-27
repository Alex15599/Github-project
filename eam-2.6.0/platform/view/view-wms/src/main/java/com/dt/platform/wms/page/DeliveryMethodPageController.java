package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.DeliveryMethodServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 提货方式模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:28
*/

@Controller("WmsDeliveryMethodPageController")
@RequestMapping(DeliveryMethodPageController.prefix)
public class DeliveryMethodPageController extends ViewController {

	public static final String prefix="business/wms/delivery_method";

	private DeliveryMethodServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public DeliveryMethodServiceProxy proxy() {
		if(proxy==null) {
			proxy=DeliveryMethodServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 提货方式 功能主页面
	 */
	@RequestMapping("/delivery_method_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"delivery_method_list");
	}

	/**
	 * 提货方式 表单页面
	 */
	@RequestMapping("/delivery_method_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"delivery_method_form");
	}
}