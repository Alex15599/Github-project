package com.dt.platform.wms.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.dt.platform.proxy.wms.TransportAddrServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 地址管理模版页面控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:06:55
*/

@Controller("WmsTransportAddrPageController")
@RequestMapping(TransportAddrPageController.prefix)
public class TransportAddrPageController extends ViewController {

	public static final String prefix="business/wms/transport_addr";

	private TransportAddrServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public TransportAddrServiceProxy proxy() {
		if(proxy==null) {
			proxy=TransportAddrServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 地址管理 功能主页面
	 */
	@RequestMapping("/transport_addr_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"transport_addr_list");
	}

	/**
	 * 地址管理 表单页面
	 */
	@RequestMapping("/transport_addr_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"transport_addr_form");
	}
}